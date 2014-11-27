package pl.com.sages.spring.io.deal.data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public abstract class InMemoryRepository<T extends Entity> {

    private final AtomicLong sequence = new AtomicLong(1L);

    private final ConcurrentMap<Long, T> storage = new ConcurrentHashMap<>();

    public T findOne(Long id) {
        return storage.get(id);
    }

    public T save(T entity) {
        if (entity.getId() == null) {
            entity.setId(sequence.getAndIncrement());
        }
        storage.put(entity.getId(), entity);
        return entity;
    }
}
