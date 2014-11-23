package pl.com.sages.spring.io.deal.game

import groovy.transform.TypeChecked
import org.springframework.data.repository.PagingAndSortingRepository

@TypeChecked
interface GameRepository extends PagingAndSortingRepository<Game, Long> {
}
