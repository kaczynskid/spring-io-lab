package pl.com.sages.spring.io.deal.game

import groovy.transform.TypeChecked
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import pl.com.sages.spring.io.deal.game.door.Door

@TypeChecked
@Component
class GameService {

    static final int MAX_EMPTY_DOORS = 2

    private final Random random = new Random()

    private final GameRepository repository

    @Autowired
    GameService(GameRepository repository) {
        this.repository = repository
    }

    Game findOne(Long id) {
        return repository.findOne(id)
    }

    Game create() {
        return repository.save(new Game(
            status: Game.Status.AWAITING_PRIMARY_SELECTION,
            doors: newDoors()
        ))
    }

    Game save(Game game) {
        return repository.save(game)
    }

    private List<Door> newDoors() {
        List<Door> doors = [new Door(Door.Content.LOOT)];
        [1, MAX_EMPTY_DOORS].each { idx ->
            random.nextBoolean() ?
                doors.add(0, new Door(Door.Content.EMPTY)) :
                doors.add(new Door(Door.Content.EMPTY))
        }
        return doors
    }

}