package org.fasttrackit.bloodpressuremanager.service;

import org.fasttrackit.bloodpressuremanager.domain.User;
import org.fasttrackit.bloodpressuremanager.dto.UserDTO;
import org.fasttrackit.bloodpressuremanager.exception.NotFoundException;
import org.fasttrackit.bloodpressuremanager.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for User
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findOneUser(long idUser) {
        //find a user in the repository by idUser
        User user = userRepository.findOne(idUser);
        //check if the user id exists in repository
        if (user == null) {
            //if the id does not exist in repository, throw an exception
            throw new NotFoundException("" + idUser);
        }

        //TODO - return only the user name and id (without password)
        return user;
    }

    public void saveUser(UserDTO user) {
        //save a user in repository (user name and password must not be null)
        //check user's name
        if (user.getUserNameDto() == null) {
            //if name is null throw an exception
            throw new IllegalArgumentException("User's name can NOT be null");
        }

        //check password
        if (user.getPasswordDto() == null) {
            //if password is null throw an exception
            throw new IllegalArgumentException("Password can NOT be null");
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
        //convert user to userDto (set values for user in userDto) (without user's password)
        UserDTO userDTO = new UserDTO("UserDTO"); //TODO: why do we send the name = "UserDto" ?
        userDTO.setUserNameDto(user.getUserName());
        userDTO.setIdUserDto(user.getIdUser());
        return userDTO;
    }

    private User convertToObject(UserDTO userDTO) {
        //convert a user to object (with user's password)
        User user = new User();
        user.setUserName(userDTO.getUserNameDto());
        user.setIdUser(userDTO.getIdUserDto());
        user.setPassword(userDTO.getPasswordDto());
        return user;
    }

    public UserDTO updateUser(long id, UserDTO dto) {
        //update a user by id
        User user = userRepository.findOne(id);
        user.setUserName(dto.getUserNameDto());
        user.setPassword(dto.getPasswordDto());

        User savedObject = userRepository.save(user);
        return convertToDTO(savedObject);
    }
}
