package org.fasttrackit.bloodpressuremanager.service;

import org.fasttrackit.bloodpressuremanager.domain.UserDetails;
import org.fasttrackit.bloodpressuremanager.dto.UserDetailsDTO;
import org.fasttrackit.bloodpressuremanager.exception.NotFoundException;
import org.fasttrackit.bloodpressuremanager.persistence.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for UserDetails
 */
@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public UserDetails findOneUserDetails(long idUserDetails) {
        //find a userDetails in the repository by idPerson
        UserDetails userDetails = userDetailsRepository.findOne(idUserDetails);
        //check if the userDetails id exists in repository
        if (userDetails == null) {
            //if the id does not exist in repository, throw an exception
            throw new NotFoundException("" + idUserDetails);
        }
        return userDetails;
    }

    public void saveUserDetails(UserDetailsDTO userDetailsDTO) {
        //save user details in repository (first name and second name must not be null)
        //check first name
        if (userDetailsDTO.getFirstNameDto() == null) {
            //if first name is null throw an exception
            throw new IllegalArgumentException("UserDetails's first name can not be null");
        }

        //check second name
        if (userDetailsDTO.getSecondNameDto() == null) {
            //if second name is null throw an exception
            throw new IllegalArgumentException("UserDetails's second name can not be null");
        }
        UserDetails userDetailsObject = convertToObject(userDetailsDTO);

        try {
            userDetailsRepository.save(userDetailsObject);
        } catch (Exception e) {
            System.out.print("Error when saving user details " + e);
        }
    }

    public void deleteUserDetails(UserDetails userDetails) {
        //delete a userDetails from repository
        //check userDetails ID

        //TODO - ar trebui adaugata undeva o validare care sa verifica daca id-ul exista in repository?

        try {
            userDetailsRepository.delete(userDetails);
        } catch (Exception e) {
            System.out.print("Error when deleting userDetails " + e);
        }
    }

    public UserDetailsDTO getUserDetailsById(long id) {
        //search userDetails by id in repository
        UserDetails userDetails = userDetailsRepository.findOne(id);
        if (userDetails == null) {
            throw new IllegalArgumentException("The user details id is not valid.");
        }
        return convertToDTO(userDetails);
    }

    private UserDetailsDTO convertToDTO(UserDetails userDetails) {
        //convert userDetails to userDetailsDto (set values for userDetails in userDetailsDto)
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO("userDetails", "dto"); //TODO: why do send the name = "UserDto" ?
        userDetailsDTO.setFirstNameDto(userDetails.getFirstName());
        userDetailsDTO.setSecondNameDto(userDetails.getSecondName());
        userDetailsDTO.setIdDetailsDto(userDetails.getIdDetails());
        userDetailsDTO.setAgeDto(userDetails.getAge());
        userDetailsDTO.setGenderDto(userDetails.getGender());
        userDetailsDTO.setNotesDto(userDetails.getNotes());
        return userDetailsDTO;
    }

    private UserDetails convertToObject(UserDetailsDTO userDetailsDTO) {
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(userDetailsDTO.getFirstNameDto());
        userDetails.setSecondName(userDetailsDTO.getSecondNameDto());
        userDetails.setIdDetails(userDetailsDTO.getIdDetailsDto());
        userDetails.setAge(userDetailsDTO.getAgeDto());
        userDetails.setGender(userDetailsDTO.getGenderDto());
        userDetails.setNotes(userDetailsDTO.getNotesDto());
        return userDetails;
    }

    public UserDetailsDTO updateUserDetails(long id, UserDetailsDTO dto) {
        //update a userDetails by id
        UserDetails userDetails = userDetailsRepository.findOne(id);
        userDetails.setFirstName(dto.getFirstNameDto());
        userDetails.setSecondName(dto.getSecondNameDto());
        userDetails.setIdDetails(dto.getIdDetailsDto());
        userDetails.setAge(dto.getAgeDto());
        userDetails.setGender(dto.getGenderDto());
        userDetails.setNotes(dto.getNotesDto());

        UserDetails savedObject = userDetailsRepository.save(userDetails);
        return convertToDTO(savedObject);
    }

}
