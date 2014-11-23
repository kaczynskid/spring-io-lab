package pl.com.sages.spring.io.deal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.web.config.EnableSpringDataWebSupport
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
@EnableTransactionManagement(proxyTargetClass = true)
@EnableSpringDataWebSupport
@ComponentScan(basePackageClasses = DealApp.class)
class DealApp {

    static void main(String[] args) {
        SpringApplication.run(DealApp.class);
    }
}
