package pl.com.sages.spring.io.lab03.cowsay.chuck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import pl.com.sages.spring.io.lab03.cowsay.CowSay;

@RestController
public class CowSayChuck extends CowSay {

    private final RestTemplate rest;

    @Autowired
    public CowSayChuck(RestTemplate rest) {
        this.rest = rest;
    }

    @RequestMapping("/chuck")
    public String chuck() {
        return sayHtml(rest.getForObject("http://api.icndb.com/jokes/random", ChuckResponse.class).getValue().getJoke());
    }

}
