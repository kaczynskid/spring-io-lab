package pl.com.sages.spring.io.deal.game

import groovy.transform.TypeChecked
import org.springframework.cache.annotation.*
import org.springframework.data.repository.PagingAndSortingRepository

@TypeChecked
@CacheConfig(cacheNames = 'games')
interface GameRepository extends PagingAndSortingRepository<Game, Long> {

    @Cacheable(key = '#id')
    Game findOne(Long id);

    @CachePut(key = '#game.id')
    Game save(Game game)

    @CacheEvict(key = '#id')
    void delete(Long id)
}
