package pl.com.sages.spring.io.lab03.cowsay.chuck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.com.sages.spring.io.lab03.cowsay.Cow;

@RestController
public class CowSayChuck {

    private final Cow cow;
    private final Chuck chuck;

    @Autowired
    public CowSayChuck(Cow cow, Chuck chuck) {
        this.cow = cow;
        this.chuck = chuck;
    }

    @RequestMapping("/chuck")
    public String chuck() {
        return cow.sayHtml(chuck.joke());
    }

}
