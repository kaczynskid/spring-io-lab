package pl.com.sages.spring.io.lab03.cowsay.date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import pl.com.sages.spring.io.lab03.cowsay.Cow;

@RestController
public class CowSayDate {

    private final Cow cow;
    private final RestTemplate rest;

    @Autowired
    public CowSayDate(Cow cow, RestTemplate rest) {
        this.cow = cow;
        this.rest = rest;
    }

    @RequestMapping("/date")
    public String date() {
        return cow.sayHtml(rest.getForObject("http://localhost:8032/", String.class));
    }

}
