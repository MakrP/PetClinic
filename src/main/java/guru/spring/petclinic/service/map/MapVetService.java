package guru.spring.petclinic.service.map;

import guru.spring.petclinic.model.Vet;
import guru.spring.petclinic.service.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MapVetService extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long aLong) {
        return super.findById(aLong);
    }
}
