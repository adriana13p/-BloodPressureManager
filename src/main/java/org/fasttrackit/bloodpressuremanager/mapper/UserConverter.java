package org.fasttrackit.bloodpressuremanager.mapper;

import org.fasttrackit.bloodpressuremanager.domain.User;
import org.fasttrackit.bloodpressuremanager.dto.UserDTO;
import org.springframework.stereotype.Component;

/**
 * Converters for user
 */
@Component
public class UserConverter {


    public UserDTO convertUserToDTOWithoutPassword(User user) {
        //convert user to userDto (set values for user in userDto) (without user's password)
        UserDTO userDTO = new UserDTO("UserDTO");
        userDTO.setUserNameDto(user.getUserName());
        userDTO.setIdUserDto(user.getIdUser());
        return userDTO;
    }
    public UserDTO convertUserToDTOWithPassword(User user) {
        //convert user to userDto (set values for user in userDto) (wit user's password)
        UserDTO userDTO = new UserDTO("UserDTO");
        userDTO.setIdUserDto(user.getIdUser());
        userDTO.setUserNameDto(user.getUserName());
        userDTO.setPasswordDto(user.getPassword());
        return userDTO;
    }
    public User convertUserToObjectFull(UserDTO userDTO) {
        //convert a user to object (with user's password)
        User user = new User();
        user.setUserName(userDTO.getUserNameDto());
        user.setIdUser(userDTO.getIdUserDto());
        user.setPassword(userDTO.getPasswordDto());
        return user;
    }

}
