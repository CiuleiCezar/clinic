package com.medicalplatform.dtos.builders;

import com.medicalplatform.dtos.PersonDTO;
import com.medicalplatform.dtos.PersonDetailsDTO;
import com.medicalplatform.entities.Person;

public class PersonBuilder {

    private PersonBuilder() {
    }

    public static PersonDTO toPersonDTO(Person person) {
        return new PersonDTO(person.getId(), person.getName(), person.getAge());
    }

    public static Person toEntity(PersonDetailsDTO personDetailsDTO) {
            return new Person(personDetailsDTO.getName(),
                    personDetailsDTO.getAddress(),
                    personDetailsDTO.getAge());
    }
}
