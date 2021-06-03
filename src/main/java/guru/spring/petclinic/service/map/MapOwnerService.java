package guru.spring.petclinic.service.map;

import guru.spring.petclinic.model.Owner;
import guru.spring.petclinic.model.Pet;
import guru.spring.petclinic.service.OwnerService;
import guru.spring.petclinic.service.PetService;
import guru.spring.petclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MapOwnerService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public MapOwnerService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner save(Owner owner) {
        Set<Pet> pets = owner.getPets();
        pets.forEach(pet -> {
            if (pet.getId() == null) {
                if (pet.getType() != null) {
                    if (pet.getType().getId() == null) {
                        pet.setType(petTypeService.save(pet.getType()));
                    }
                } else {
                    throw new RuntimeException("Pet must have Type");
                }
                Pet savedPet = petService.save(pet);
                pet.setId(savedPet.getId());
            }
        });
        return super.save(owner);
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
