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
        userDetailsDTO.setFirstName(userDetails.getFirstName());
        userDetailsDTO.setSecondName(userDetails.getSecondName());
        userDetailsDTO.setIdDetails(userDetails.getIdDetails());
        userDetailsDTO.setAge(userDetails.getAge());
        userDetailsDTO.setGender(userDetails.getGender());
        userDetailsDTO.setNotes(userDetails.getNotes());
        return userDetailsDTO;
    }

    public UserDetails convertToObject(UserDetailsDTO userDetailsDTO, User userToSave) {
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(userDetailsDTO.getFirstName());
        userDetails.setSecondName(userDetailsDTO.getSecondName());
        userDetails.setIdDetails(userDetailsDTO.getIdDetails());
        userDetails.setAge(userDetailsDTO.getAge());
        userDetails.setGender(userDetailsDTO.getGender());
        userDetails.setNotes(userDetailsDTO.getNotes());
        //set user id fk
        userDetails.setUser(userToSave);
        return userDetails;
    }

    public UserDetails convertToObjectWithoutUser(UserDetailsDTO userDetailsDTO) {
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(userDetailsDTO.getFirstName());
        userDetails.setSecondName(userDetailsDTO.getSecondName());
        userDetails.setIdDetails(userDetailsDTO.getIdDetails());
        userDetails.setAge(userDetailsDTO.getAge());
        userDetails.setGender(userDetailsDTO.getGender());
        userDetails.setNotes(userDetailsDTO.getNotes());
        return userDetails;
    }
}
