package org.fasttrackit.bloodpressuremanager.mapper;

import org.fasttrackit.bloodpressuremanager.domain.User;
import org.fasttrackit.bloodpressuremanager.domain.UserDetails;
import org.fasttrackit.bloodpressuremanager.dto.UserWithDetailsDTO;
import org.springframework.stereotype.Component;

@Component
public class UserWithDetailsConverter {

    public UserWithDetailsDTO convertUserWithDetails(User user, UserDetails userDetails) {
        //convert user and userDetails to UserWithDetailsDTO
        UserWithDetailsDTO userWithDetailsDTO = new UserWithDetailsDTO("UserWithDetailsDTO");
        userWithDetailsDTO.setIdUser(user.getIdUser());
        userWithDetailsDTO.setUserName(user.getUserName());
        userWithDetailsDTO.setPassword(user.getPassword());
        userWithDetailsDTO.setIdDetails(userDetails.getIdDetails());
        userWithDetailsDTO.setFirstName(userDetails.getFirstName());
        userWithDetailsDTO.setSecondName(userDetails.getSecondName());
        userWithDetailsDTO.setAge(userDetails.getAge());
        userWithDetailsDTO.setGender(userDetails.getGender());
        userWithDetailsDTO.setNotes(userDetails.getNotes());
        return userWithDetailsDTO;
    }
}
