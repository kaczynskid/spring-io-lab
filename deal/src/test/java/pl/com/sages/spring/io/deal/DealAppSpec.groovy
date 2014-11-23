package pl.com.sages.spring.io.deal

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.hateoas.Link
import org.springframework.hateoas.Resource
import org.springframework.http.MediaType
import org.springframework.mock.web.MockHttpServletResponse
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext
import pl.com.sages.spring.io.deal.game.Game
import pl.com.sages.spring.io.deal.game.door.Door
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

import static javax.servlet.http.HttpServletResponse.SC_CREATED
import static javax.servlet.http.HttpServletResponse.SC_OK
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup

@ContextConfiguration(classes = DealApp, loader = SpringApplicationContextLoader)
@WebAppConfiguration
@Stepwise
class DealAppSpec extends Specification {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    ObjectMapper jsonMapper

    @Shared
    MockMvc mvc;

    @Shared
    String gameLocation;

    @Shared
    Resource<Game> game

    void setup() {
        mvc = webAppContextSetup(this.webApplicationContext).build();
    }

    def "Player starts the game"() {
        when:
            MockHttpServletResponse response = mvc
                .perform(post("/games"))
                .andDo(print())
                .andReturn().response
        then:
            response.status == SC_CREATED
            (gameLocation = response.getHeader('Location')) != null
    }

    def "Game awaits initial selection"() {
        when:
            readGame()
        then:
            game.content.status == Game.Status.AWAITING_PRIMARY_SELECTION
            doorsThatAre(Door.Status.CLOSED).size() == 3
    }

    def "Player selects the door"() {
        when:
            MockHttpServletResponse response = mvc
                .perform(put(doorLinks()[1].href)
                    .content("{ \"status\": \"SELECTED\"}")
                    .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn().response
        then:
            response.status == SC_OK
    }

    def "Game opened one empty door and awaits secondary selection"() {
        when:
            readGame()
        then:
            game.content.status == Game.Status.AWAITING_SECONDARY_SELECTION
            game.content.doors[1].status == Door.Status.SELECTED
            doorsThatAre(Door.Status.OPENED)
                .collect { Door door -> door.content } == [Door.Content.EMPTY]
    }

    def "Player chooses door to open"() {
        given:
            int idx = game.content.doors[0].status == Door.Status.CLOSED ? 0 : 2
        when:
            MockHttpServletResponse response = mvc
                .perform(put(doorLinks()[idx].href)
                .content("{ \"status\": \"OPENED\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn().response
        then:
            response.status == SC_OK
    }

    def "Game ends"() {
        when:
            readGame()
        then:
            [Game.Status.LOST, Game.Status.WON].contains(game.content.status)
    }

    void readGame() {
        String json = mvc.perform(get(gameLocation)).andDo(print()).andReturn().response.contentAsString
        game = jsonMapper.readValue(json, new TypeReference<Resource<Game>>() {})
    }

    List<Link> doorLinks() {
        return game.links.findAll({ Link l -> 'door'.equals(l.rel) })
    }

    List<Door> doorsThatAre(Door.Status status) {
        return game.content.doors.findAll() { Door door -> status == door.status}
    }
}
