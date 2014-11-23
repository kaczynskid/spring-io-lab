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
 - elementy TDD & BDD
 - testowanie jednostkowe
 - testowanie integracyjne
 - testowanie zasobów Web'owych

## REST-ful API design
 - [Teach a Dog to REST](https://blog.apigee.com/detail/restful_api_design)
 - Zasoby i ich reprezentacja
 - Punkt wejścia i inne adresy
 - [Designing REST-ful API using Spring](https://www.parleys.com/play/529e1742e4b0e619540cc3e6)
 - Metody i ich parametry
 - Modelowanie relacji
 - [Spring Hateoas](https://github.com/spring-projects/spring-hateoas/blob/master/readme.md)
 - Testowanie
 - [API debug console](https://apigee.com/providers)
 - [REST assured](https://github.com/jayway/rest-assured)

## Więcej o Sring MVC
 - Obsługa wyjątków (@ResponseStatus & @ExceptionHandler)
 - @ControllerAdvice
 - Konfiguracja mapowania do JSON'a
 - Odbieranie plików

## Spring Data
 - Definiowanie interfejsów Repository
 - Tworzenie metod zapytań
 - Dodawanie własnych implementacji dla wybranych metod
 - Specyfikacje
 - QueryDSL
 - Web support

## Cross cutting concers aka Spring AOP
 - Jak działają AOP proxy?
 - Co to są Pointcut, JoinPoint, Aspect?
 - Testowanie aspektów
 - Obsługa transakcji
 - Konfiguracja cache'a

## Monitoring i zarządzanie
 - JMX
 - spring-boot-actuator
 - spring-boot-remote-shell
 - spring-monitor

## Spring Security
 - Logowanie przez formularz i HTTP Basic
 - Zabezpieczanie adresów URL
 - Podłączanie bazy użytkowników i uprawnień
 - Zabezpieczanie metod
 - springSecurityFilterChain i inne główne bean'y
 - Spring OAuth2

