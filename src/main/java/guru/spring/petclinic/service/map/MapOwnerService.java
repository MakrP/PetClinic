package guru.spring.petclinic.service.map;

import guru.spring.petclinic.model.Owner;
import guru.spring.petclinic.service.CrudService;
import guru.spring.petclinic.service.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MapOwnerService extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long aLong) {
        return super.findById(aLong);
    }
}
