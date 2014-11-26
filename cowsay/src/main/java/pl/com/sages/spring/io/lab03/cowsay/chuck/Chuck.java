package pl.com.sages.spring.io.lab03.cowsay.chuck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Chuck {

    private final RestTemplate rest;

    @Autowired
    public Chuck(RestTemplate rest) {
        this.rest = rest;
    }

    public String joke() {
        try {
            return rest.getForObject("http://api.icndb.com/jokes/random", ChuckResponse.class)
                    .getValue().getJoke();
        } catch (Exception e) {
            return "Chuck is ill. No jokes today.";
        }
    }

}
