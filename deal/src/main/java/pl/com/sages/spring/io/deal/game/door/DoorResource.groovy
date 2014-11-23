package pl.com.sages.spring.io.deal.game.door

import groovy.transform.TypeChecked
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.Resource
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pl.com.sages.spring.io.deal.game.Game
import pl.com.sages.spring.io.deal.game.GameService

import javax.validation.constraints.NotNull

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.PUT

@TypeChecked
@Validated
@RestController
@RequestMapping("/games/{game}/doors")
class DoorResource {

    private final GameService service

    @Autowired
    DoorResource(GameService service) {
        this.service = service
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @RequestMapping(value = "/{doorIdx}", method = GET)
    Resource<Door> read(@NotNull @PathVariable Game game,
                        @NotNull @PathVariable Integer doorIdx) {
        return toResource(game, doorIdx)
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @RequestMapping(value = "/{doorIdx}", method = PUT)
    void update(@NotNull @PathVariable Game game,
                @NotNull @PathVariable Integer doorIdx,
                @NotNull @RequestBody Door door) {
        game.takeAction(doorIdx, door.status)
        service.save(game);
    }
    
    static Resource<Door> toResource(Game game, Integer doorIdx) {
        Door door = game.getDoor(doorIdx)
        Resource<Door> resource = new Resource<>(door);
        resource.add(linkTo(DoorResource, game.id).slash(door).withSelfRel());
        return resource;
    }
}