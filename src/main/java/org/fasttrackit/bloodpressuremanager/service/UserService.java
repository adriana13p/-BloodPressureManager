package org.fasttrackit.bloodpressuremanager.service;

import org.fasttrackit.bloodpressuremanager.domain.User;
import org.fasttrackit.bloodpressuremanager.dto.UserDTO;
import org.fasttrackit.bloodpressuremanager.exception.NotFoundException;
import org.fasttrackit.bloodpressuremanager.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service for User
 */
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findOneUser(Long idUser) {
        //find a user in the repository by idUser
        User user = userRepository.findOne(idUser);
        //check if the user id exists in repository
        if (user == null) {
            //if the id does not exist in repository, throw an exception
            throw new NotFoundException("" + idUser);
        }
        return user;
    }

    public void saveUser(UserDTO user) {
        //save a user in repository (only user name and must not be null)
        //check user's name
        if (user.getUserNameDto() == null) {
            //if name is null throw an exception
            throw new IllegalArgumentException("User's name can not be null");
        }

        User userObject = convertToObject(user);

        //TODO - check if the user name already exists in the repository

        try {
            userRepository.save(userObject);
        } catch (Exception e) {
            System.out.print("Error when saving user " + e);
        }
    }


    public UserDTO getUserById(long id) {
        //search user by id in repository
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new IllegalArgumentException("The id is not valid.");
        }
        return convertToDTO(user);
    }

    private UserDTO convertToDTO(User user) {
        //convert user to userDto (set values for user in userDto)
        UserDTO userDTO = new UserDTO("UserDTO"); //TODO: why do send the name = "UserDto" ?
        userDTO.setUserNameDto(user.getUserName());
        userDTO.setIdUserDto(user.getIdUser());
        return userDTO;
    }

    private User convertToObject(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserNameDto());
        user.setIdUser(userDTO.getIdUserDto());
        return user;
    }

    public UserDTO updateUser(long id, UserDTO dto) {
        //update a user by id
        User user = userRepository.findOne(id);
        user.setUserName(dto.getUserNameDto());

        User savedObject = userRepository.save(user);
        return convertToDTO(savedObject);
    }
}
