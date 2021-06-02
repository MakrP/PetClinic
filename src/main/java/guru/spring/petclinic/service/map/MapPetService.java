package guru.spring.petclinic.service.map;

import guru.spring.petclinic.model.Pet;
import guru.spring.petclinic.service.CrudService;
import guru.spring.petclinic.service.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MapPetService extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long aLong) {
        return super.findById(aLong);
    }
}
