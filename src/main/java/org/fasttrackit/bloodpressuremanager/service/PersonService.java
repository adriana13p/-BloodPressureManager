package org.fasttrackit.bloodpressuremanager.service;

import org.fasttrackit.bloodpressuremanager.domain.Person;
import org.fasttrackit.bloodpressuremanager.dto.PersonDTO;
import org.fasttrackit.bloodpressuremanager.exception.NotFoundException;
import org.fasttrackit.bloodpressuremanager.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service for Person
 */
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person findOnePerson(Long idPerson) {
        //find a person in the repository by idPerson
        Person person = personRepository.findOne(idPerson);
        //check if the person id exists in repository
        if (person == null) {
            //if the id does not exist in repository, throw an exception
            throw new NotFoundException("" + idPerson);
        }
        return person;
    }

    public void savePerson(PersonDTO person) {
        //save a person in repository (person first name and second name must not be null)
        //check person first name
        if (person.getPersonFirstNameDto() == null) {
            //if first name is null throw an exception
            throw new IllegalArgumentException("Person's first name can not be null");
        }

        //check person second name
        if (person.getPersonSecondNameDto() == null) {
            //if second name is null throw an exception
            throw new IllegalArgumentException("Person's second name can not be null");
        }
        Person personObject = convertToObject(person);

        try {
            personRepository.save(personObject);
        } catch (Exception e) {
            System.out.print("Error when saving person " + e);
        }
    }

    public void deletePerson(Person person) {
        //delete a person from repository
        //check person ID

        //TODO - ar trebui adaugata undeva o validare care sa verifica daca id-ul exista in repository?

        try {
            personRepository.delete(person);
        } catch (Exception e) {
            System.out.print("Error when deleting person " + e);
        }
    }

    public PersonDTO getPersonById(long id) {
        //search person by id in repository
        Person person = personRepository.findOne(id);
        if (person == null) {
            throw new IllegalArgumentException("The id is not valid.");
        }
        return convertToDTO(person);
    }

    private PersonDTO convertToDTO(Person person) {
        //convert person to personDto (set values for person in personDto)
        PersonDTO personDTO = new PersonDTO("person", "dto"); //TODO: why do send the name = "UserDto" ?
        personDTO.setPersonFirstNameDto(person.getPersonFirstName());
        personDTO.setPersonSecondNameDto(person.getPersonSecondName());
        personDTO.setIdPersonDto(person.getIdPerson());
        personDTO.setAgeDto(person.getAge());
        personDTO.setGenderDto(person.getGender());
        personDTO.setNotesDto(person.getNotes());
        return personDTO;
    }

    private Person convertToObject(PersonDTO personDTO) {
        Person person = new Person();
        person.setPersonFirstName(personDTO.getPersonFirstNameDto());
        person.setPersonSecondName(personDTO.getPersonSecondNameDto());
        person.setIdPerson(personDTO.getIdPersonDto());
        person.setAge(personDTO.getAgeDto());
        person.setGender(personDTO.getGenderDto());
        person.setNotes(personDTO.getNotesDto());
        return person;
    }

    public PersonDTO updatePerson(long id, PersonDTO dto) {
        //update a person by id
        Person person = personRepository.findOne(id);
        person.setPersonFirstName(dto.getPersonFirstNameDto());
        person.setPersonSecondName(dto.getPersonSecondNameDto());
        person.setIdPerson(dto.getIdPersonDto());
        person.setAge(dto.getAgeDto());
        person.setGender(dto.getGenderDto());
        person.setNotes(dto.getNotesDto());

        Person savedObject = personRepository.save(person);
        return convertToDTO(savedObject);
    }

}
