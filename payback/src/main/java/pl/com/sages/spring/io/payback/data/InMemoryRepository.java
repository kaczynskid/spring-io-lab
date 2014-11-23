package pl.com.sages.spring.io.payback.data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class InMemoryRepository<ID, T extends Entity<ID>> {

    private final ConcurrentMap<ID, T> storage = new ConcurrentHashMap<>();

    public T findOne(ID id) {
        return storage.get(id);
    }

    public void save(T entity) {
        storage.put(entity.getId(), entity);
    }
}
