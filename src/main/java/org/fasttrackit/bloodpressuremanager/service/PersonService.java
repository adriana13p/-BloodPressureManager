package org.fasttrackit.bloodpressuremanager.service;

import org.fasttrackit.bloodpressuremanager.domain.UserDetails;
import org.fasttrackit.bloodpressuremanager.dto.PersonDTO;
import org.fasttrackit.bloodpressuremanager.exception.NotFoundException;
import org.fasttrackit.bloodpressuremanager.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service for UserDetails
 */
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public UserDetails findOnePerson(Long idPerson) {
        //find a userDetails in the repository by idPerson
        UserDetails userDetails = personRepository.findOne(idPerson);
        //check if the userDetails id exists in repository
        if (userDetails == null) {
            //if the id does not exist in repository, throw an exception
            throw new NotFoundException("" + idPerson);
        }
        return userDetails;
    }

    public void savePerson(PersonDTO person) {
        //save a person in repository (person first name and second name must not be null)
        //check person first name
        if (person.getPersonFirstNameDto() == null) {
            //if first name is null throw an exception
            throw new IllegalArgumentException("UserDetails's first name can not be null");
        }

        //check person second name
        if (person.getPersonSecondNameDto() == null) {
            //if second name is null throw an exception
            throw new IllegalArgumentException("UserDetails's second name can not be null");
        }
        UserDetails userDetailsObject = convertToObject(person);

        try {
            personRepository.save(userDetailsObject);
        } catch (Exception e) {
            System.out.print("Error when saving person " + e);
        }
    }

    public void deletePerson(UserDetails userDetails) {
        //delete a userDetails from repository
        //check userDetails ID

        //TODO - ar trebui adaugata undeva o validare care sa verifica daca id-ul exista in repository?

        try {
            personRepository.delete(userDetails);
        } catch (Exception e) {
            System.out.print("Error when deleting userDetails " + e);
        }
    }

    public PersonDTO getPersonById(long id) {
        //search userDetails by id in repository
        UserDetails userDetails = personRepository.findOne(id);
        if (userDetails == null) {
            throw new IllegalArgumentException("The id is not valid.");
        }
        return convertToDTO(userDetails);
    }

    private PersonDTO convertToDTO(UserDetails userDetails) {
        //convert userDetails to personDto (set values for userDetails in personDto)
        PersonDTO personDTO = new PersonDTO("userDetails", "dto"); //TODO: why do send the name = "UserDto" ?
        personDTO.setPersonFirstNameDto(userDetails.getFirstName());
        personDTO.setPersonSecondNameDto(userDetails.getSecondName());
        personDTO.setIdPersonDto(userDetails.getIdDetails());
        personDTO.setAgeDto(userDetails.getAge());
        personDTO.setGenderDto(userDetails.getGender());
        personDTO.setNotesDto(userDetails.getNotes());
        return personDTO;
    }

    private UserDetails convertToObject(PersonDTO personDTO) {
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(personDTO.getPersonFirstNameDto());
        userDetails.setSecondName(personDTO.getPersonSecondNameDto());
        userDetails.setIdDetails(personDTO.getIdPersonDto());
        userDetails.setAge(personDTO.getAgeDto());
        userDetails.setGender(personDTO.getGenderDto());
        userDetails.setNotes(personDTO.getNotesDto());
        return userDetails;
    }

    public PersonDTO updatePerson(long id, PersonDTO dto) {
        //update a userDetails by id
        UserDetails userDetails = personRepository.findOne(id);
        userDetails.setFirstName(dto.getPersonFirstNameDto());
        userDetails.setSecondName(dto.getPersonSecondNameDto());
        userDetails.setIdDetails(dto.getIdPersonDto());
        userDetails.setAge(dto.getAgeDto());
        userDetails.setGender(dto.getGenderDto());
        userDetails.setNotes(dto.getNotesDto());

        UserDetails savedObject = personRepository.save(userDetails);
        return convertToDTO(savedObject);
    }

}
