package pl.com.sages.spring.io.deal

import groovy.transform.TypeChecked
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.concurrent.ConcurrentMapCache
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.web.config.EnableSpringDataWebSupport
import org.springframework.transaction.annotation.EnableTransactionManagement

@TypeChecked
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
@EnableSpringDataWebSupport
@EnableTransactionManagement(proxyTargetClass = true)
//@EnableCaching(proxyTargetClass = false)
@ComponentScan(basePackageClasses = DealApp.class)
class DealApp {

    static void main(String[] args) {
        SpringApplication.run(DealApp.class);
    }

    @Bean
    static CacheManager cacheManager() {
        return new SimpleCacheManager(caches: [new ConcurrentMapCache('games')]);
    }
}
