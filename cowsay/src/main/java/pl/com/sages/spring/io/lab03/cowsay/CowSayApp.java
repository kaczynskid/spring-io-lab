package pl.com.sages.spring.io.lab03.cowsay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = CowSayApp.class)
public class CowSayApp {

    public static void main(String[] args) {
        SpringApplication.run(CowSayApp.class);
    }

    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }
}
