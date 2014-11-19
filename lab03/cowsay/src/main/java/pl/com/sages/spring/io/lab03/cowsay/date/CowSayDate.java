package pl.com.sages.spring.io.lab03.cowsay.date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import pl.com.sages.spring.io.lab03.cowsay.CowSay;

@RestController
public class CowSayDate extends CowSay {

    private final RestTemplate rest;

    @Autowired
    public CowSayDate(RestTemplate rest) {
        this.rest = rest;
    }

    @RequestMapping("/date")
    public String date() {
        return sayHtml(rest.getForObject("http://localhost:8032/", String.class));
    }

}
