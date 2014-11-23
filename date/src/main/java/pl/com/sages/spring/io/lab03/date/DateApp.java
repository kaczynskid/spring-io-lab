package pl.com.sages.spring.io.lab03.date;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class DateApp {

    private static final Logger log = LoggerFactory.getLogger(DateApp.class);

    public static void main(String[] args) {
        SpringApplication.run(DateApp.class);
    }

    @RequestMapping("/")
    public String date() {
        String dateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now()).format(ISO_LOCAL_DATE_TIME);
        log.info(dateTime);
        return dateTime;
    }
}
