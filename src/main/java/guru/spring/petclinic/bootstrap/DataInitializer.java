package guru.spring.petclinic.bootstrap;

import guru.spring.petclinic.model.Owner;
import guru.spring.petclinic.model.Pet;
import guru.spring.petclinic.model.Vet;
import guru.spring.petclinic.service.OwnerService;
import guru.spring.petclinic.service.PetService;
import guru.spring.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final PetService petService;
    private final VetService vetService;

    public DataInitializer(OwnerService ownerService, PetService petService, VetService vetService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Owner FN1");
        owner1.setLastName("Owner LN1");

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Owner FN2");
        owner2.setLastName("Owner LN2");

        Owner owner3 = new Owner();
        owner3.setId(3L);
        owner3.setFirstName("Owner FN3");
        owner3.setLastName("Owner LN3");

        ownerService.save(owner1);
        ownerService.save(owner2);
        ownerService.save(owner3);

        Pet pet1 = new Pet();
        pet1.setId(1L);
        pet1.setName("Pet name1");

        Pet pet2 = new Pet();
        pet1.setId(2L);
        pet1.setName("Pet name2");

        Pet pet3 = new Pet();
        pet1.setId(3L);
        pet1.setName("Pet name3");

        petService.save(pet1);
        petService.save(pet2);
        petService.save(pet3);

        System.out.println("Init ends");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Vet FN 1");
        vet1.setLastName("Vet LN 1");

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Vet FN 2");
        vet2.setLastName("Vet LN 2");

        Vet vet3 = new Vet();
        vet3.setId(3L);
        vet3.setFirstName("Vet FN 3");
        vet3.setLastName("Vet LN 3");

    }
}
