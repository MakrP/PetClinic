package guru.spring.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Id;

public class PetType extends BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
