package pl.com.sages.spring.io.deal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = DealApp.class)
class DealApp {

    static void main(String[] args) {
        SpringApplication.run(DealApp.class);
    }
}
