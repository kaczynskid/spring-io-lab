## Spring Boot
 - Tówj pierszy mikroserwis < 140 znaków
 - Interfejs linii kolemnd i [Groovy Version Manager](http://gvmtool.net/)
 - [Spring Boot Initializer](http://start.spring.io/)
    - hello
 - Spring Boot [Starter Maven POMs](http://docs.spring.io/spring-boot/docs/1.1.9.RELEASE/reference/htmlsingle/#using-boot-starter-poms)
 - [Spring IO Guides](https://spring.io/guides)
 - Konwencje i [konfiguracje](http://docs.spring.io/spring-boot/docs/1.1.9.RELEASE/reference/htmlsingle/#boot-features-external-config)
    - guide

## Mikroserwisy na Spring IO
 - [Wprowadzenie](http://vimeo.com/105751281) (3:35-8:05) do [mikroserwisów](http://martinfowler.com/articles/microservices.html)
 - Czy mikroserwisy są [dla Ciebie](http://vimeo.com/74589816) (1:55-6:00)?
    - [cowsay](http://cowsay.morecode.org/)
 - Spring IO [BOM](http://platform.spring.io/platform/)
 - `@EnableAutoConfiguration` - [jak to działa](http://docs.spring.io/spring-boot/docs/1.1.9.RELEASE/reference/htmlsingle/#boot-features-developing-auto-configuration)?
    - cowsay + [chuck](http://api.icndb.com/)
 - Pakowanie i [uruchamianie](http://docs.spring.io/spring-boot/docs/1.1.9.RELEASE/reference/htmlsingle/#using-boot-running-your-application) lokalne
    - cowsay + chuck + date
 - Uruchamianie na [chmurze](http://docs.spring.io/spring-boot/docs/1.1.9.RELEASE/reference/htmlsingle/#cloud-deployment)
 - [Environment](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#beans-environment)
   and [profiles](http://docs.spring.io/spring-boot/docs/1.1.9.RELEASE/reference/htmlsingle/#boot-features-profiles)
    - all of it on [heroku](https://devcenter.heroku.com/articles/getting-started-with-java)  

## Testowanie
 - Elementy TDD & BDD
 - [Testowanie jednostkowe](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#unit-testing)
 - [Testowanie integracyjne](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#integration-testing)
 - [Testowanie zasobów Web'owych](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#spring-mvc-test-framework)

## REST-ful API design
 - [Teach a Dog to REST](https://blog.apigee.com/detail/restful_api_design)
 - Zasoby i ich reprezentacja
 - Punkt wejścia i inne adresy
 - [Designing REST-ful API using Spring](https://www.parleys.com/play/529e1742e4b0e619540cc3e6)
    - [Alt](http://spring.io/blog/2014/11/24/springone2gx-2014-replay-creating-rest-ful-hypermedia-based-micro-services-with-spring-boot)
 - Metody i ich parametry
 - Modelowanie relacji
 - [Spring Hateoas](https://github.com/spring-projects/spring-hateoas/blob/master/readme.md)
 - Testowanie
 - [API debug console](https://apigee.com/providers)
 - [REST assured](https://github.com/jayway/rest-assured)

## Więcej o Sring MVC
 - [Obsługa wyjątków](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc-exceptionhandlers)
 - [@ControllerAdvice](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc-ann-controller-advice)
 - [Konfiguracja mapowania do JSON'a](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc-ann-jsonview)
 - [Odbieranie plików](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc-multipart)

## Spring Data
 - [Definiowanie interfejsów `Repositor`y](http://docs.spring.io/spring-data/jpa/docs/1.7.1.RELEASE/reference/html/#repositories.definition)     
 - [Tworzenie metod zapytań](http://docs.spring.io/spring-data/jpa/docs/1.7.1.RELEASE/reference/html/#repositories.query-methods.details)
 - [Dodawanie własnych implementacji dla wybranych metod](http://docs.spring.io/spring-data/jpa/docs/1.7.1.RELEASE/reference/html/#repositories.custom-implementations)
 - [Specyfikacje](http://docs.spring.io/spring-data/jpa/docs/1.7.1.RELEASE/reference/html/#specifications)
 - [QueryDSL](http://www.querydsl.com/)
 - [Web support](http://docs.spring.io/spring-data/jpa/docs/1.7.1.RELEASE/reference/html/#core.web)

## Cross cutting concers aka Spring AOP
 - [Co to są Pointcut, JoinPoint, Aspect?](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#aop-introduction-defn)
 - [Jak działają AOP proxy?](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#aop-proxying)
 - [Testowanie aspektów](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#aop-aspectj-programmatic)
 - [Walidacja na metodach](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#validation-beanvalidation-spring-method)
 - [Obsługa transakcji](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#transaction-declarative-annotations)
 - [Konfiguracja cache'a](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#cache-annotations)

## Monitoring i zarządzanie
 - [JMX](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#jmx)
 - [spring-boot-actuator](http://docs.spring.io/spring-boot/docs/1.1.9.RELEASE/reference/htmlsingle/#production-ready)
 - [spring-boot-remote-shell](http://docs.spring.io/spring-boot/docs/1.1.9.RELEASE/reference/htmlsingle/#production-ready-remote-shell)
 - [Metrics](http://docs.spring.io/spring-boot/docs/1.1.9.RELEASE/reference/htmlsingle/#production-ready-metrics)
 - [Auditing](http://docs.spring.io/spring-boot/docs/1.1.9.RELEASE/reference/htmlsingle/#production-ready-auditing)
 - [Tracing](http://docs.spring.io/spring-boot/docs/1.1.9.RELEASE/reference/htmlsingle/#production-ready-tracing)

## Spring Security
 - Logowanie przez formularz i HTTP Basic
 - Zabezpieczanie adresów URL
 - Podłączanie bazy użytkowników i uprawnień
 - Zabezpieczanie metod
 - springSecurityFilterChain i inne główne bean'y
 - Spring OAuth2
