package pl.com.sages.spring.io.deal.game

import groovy.transform.TypeChecked
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.CachePut
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository

@TypeChecked
@CacheConfig(cacheNames = 'games')
interface GameRepository extends PagingAndSortingRepository<Game, Long> {

    @Cacheable(key = '#p0')
    Game findOne(Long id);

    @CachePut(key = '#p0.id')
    Game save(Game game)

    @CacheEvict(key = '#p0')
    void delete(Long id)
}
