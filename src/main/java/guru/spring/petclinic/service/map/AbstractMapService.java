package guru.spring.petclinic.service.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> {
    protected Map<ID, T> map = new HashMap<>();


    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    T save(ID id, T object) {
        return map.put(id, object);
    }

    void delete(T object) {
        map.entrySet().removeIf(e -> e.getValue().equals(object));
    }

    void deleteById(ID id) {
        map.remove(id);
    }
}
