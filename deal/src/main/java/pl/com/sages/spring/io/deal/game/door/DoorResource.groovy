package pl.com.sages.spring.io.deal.game.door

import groovy.transform.TypeChecked
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.Resource
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pl.com.sages.spring.io.deal.game.Game
import pl.com.sages.spring.io.deal.game.GameService

import javax.validation.constraints.NotNull

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo

@TypeChecked
@Validated
@RestController
@RequestMapping("/games/{gameId}/doors")
class DoorResource {

    private final GameService service

    @Autowired
    DoorResource(GameService service) {
        this.service = service
    }

    @RequestMapping(value = "/{doorIdx}")
    Resource<Door> read(@NotNull @PathVariable Long gameId,
                        @NotNull @PathVariable Integer doorIdx) {
        Game game = service.findOne(gameId);
        return toResource(game, doorIdx)
    }

    @RequestMapping(value = "/{doorIdx}")
    void update(@NotNull @PathVariable Long gameId,
                @NotNull @PathVariable Integer doorIdx,
                @NotNull @RequestBody Door door) {
        service.findOne(gameId).takeAction(doorIdx, door.status);
    }
    
    static Resource<Door> toResource(Game game, Integer doorIdx) {
        Door door = game.getDoor(doorIdx)
        Resource<Door> resource = new Resource<>(door);
        resource.add(linkTo(DoorResource, game.id).slash(door).withSelfRel());
        return resource;
    }
}