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
        userDTO.setUserName(user.getUserName());
        userDTO.setIdUser(user.getIdUser());
        return userDTO;
    }
    public UserDTO convertUserToDTOWithPassword(User user) {
        //convert user to userDto (set values for user in userDto) (wit user's password)
        UserDTO userDTO = new UserDTO("UserDTO");
        userDTO.setIdUser(user.getIdUser());
        userDTO.setUserName(user.getUserName());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
    public User convertUserToObjectFull(UserDTO userDTO) {
        //convert a user to object (with user's password)
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setIdUser(userDTO.getIdUser());
        user.setPassword(userDTO.getPassword());
        return user;
    }

}
