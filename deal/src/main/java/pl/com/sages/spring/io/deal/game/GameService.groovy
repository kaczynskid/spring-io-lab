package pl.com.sages.spring.io.deal.game

import groovy.transform.TypeChecked
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import pl.com.sages.spring.io.deal.game.door.Door

@TypeChecked
@Component
class GameService {

    static Random random = new Random()

    private final GameRepository repository

    @Autowired
    GameService(GameRepository repository) {
        this.repository = repository
    }

    Game findOne(Long id) {
        return repository.findOne(id)
    }

    Game startNewGame() {
        return repository.save(new Game(
            status: Game.Status.AWAITING_PRIMARY_SELECTION,
            doors: 1..Game.MAX_EMPTY_DOORS
                .collect([Door.withLoot()], { List<Door> doors, int idx ->
                    random.nextBoolean() ? doors.add(0, Door.withNothing()) : doors.add(Door.withNothing())
                })
        ))
    }

}