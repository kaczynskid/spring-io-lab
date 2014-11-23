package pl.com.sages.spring.io.deal.data

import groovy.transform.TypeChecked;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@TypeChecked
abstract class InMemoryRepository<T extends Entity> {

    private final AtomicLong sequence = new AtomicLong(1L)

    private final ConcurrentMap<Long, T> storage = new ConcurrentHashMap<>()

    T findOne(Long id) {
        return storage.get(id);
    }

    T save(T entity) {
        if (entity.getId() == null) {
            entity.setId(sequence.getAndIncrement())
        }
        storage.put(entity.getId(), entity)
        return entity;
    }
}
