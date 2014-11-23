package pl.com.sages.spring.io.deal.game

import groovy.transform.TypeChecked;
import org.springframework.stereotype.Component;

import pl.com.sages.spring.io.deal.data.InMemoryRepository;

@TypeChecked
@Component
class GameRepository extends InMemoryRepository<Game> {
}
