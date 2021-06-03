package guru.spring.petclinic.service.map;

import guru.spring.petclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();


    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (object.getId() == null) {
            object.setId(getNextId());
        }
        return map.put(object.getId(), object);
    }

    void delete(T object) {
        map.entrySet().removeIf(e -> e.getValue().equals(object));
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    protected Long getNextId() {
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet());
            nextId += 1L;
        } catch (Exception e) {
            nextId = 1L;
        }
        return nextId;
    }
}
