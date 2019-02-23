package org.fasttrackit.bloodpressuremanager.mapper;

import org.fasttrackit.bloodpressuremanager.domain.User;
import org.fasttrackit.bloodpressuremanager.domain.UserDetails;
import org.fasttrackit.bloodpressuremanager.dto.UserDetailsDTO;
import org.springframework.stereotype.Component;


/**
 * Converters for user details
 */
@Component
public class UserDetailsConverter {


    public UserDetailsDTO convertToDTO(UserDetails userDetails) {
        //convert userDetails to userDetailsDto (set values for userDetails in userDetailsDto)
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO("userDetails", "dto");
        userDetailsDTO.setFirstNameDto(userDetails.getFirstName());
        userDetailsDTO.setSecondNameDto(userDetails.getSecondName());
        userDetailsDTO.setIdDetailsDto(userDetails.getIdDetails());
        userDetailsDTO.setAgeDto(userDetails.getAge());
        userDetailsDTO.setGenderDto(userDetails.getGender());
        userDetailsDTO.setNotesDto(userDetails.getNotes());
        return userDetailsDTO;
    }

    public UserDetails convertToObject(UserDetailsDTO userDetailsDTO, User userToSave) {
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(userDetailsDTO.getFirstNameDto());
        userDetails.setSecondName(userDetailsDTO.getSecondNameDto());
        userDetails.setIdDetails(userDetailsDTO.getIdDetailsDto());
        userDetails.setAge(userDetailsDTO.getAgeDto());
        userDetails.setGender(userDetailsDTO.getGenderDto());
        userDetails.setNotes(userDetailsDTO.getNotesDto());
        //set user id fk
        userDetails.setUser(userToSave);
        return userDetails;
    }

    public UserDetails convertToObjectWithoutUser(UserDetailsDTO userDetailsDTO) {
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(userDetailsDTO.getFirstNameDto());
        userDetails.setSecondName(userDetailsDTO.getSecondNameDto());
        userDetails.setIdDetails(userDetailsDTO.getIdDetailsDto());
        userDetails.setAge(userDetailsDTO.getAgeDto());
        userDetails.setGender(userDetailsDTO.getGenderDto());
        userDetails.setNotes(userDetailsDTO.getNotesDto());
        return userDetails;
    }
}
