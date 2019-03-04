package org.fasttrackit.bloodpressuremanager.service;

import org.fasttrackit.bloodpressuremanager.domain.User;
import org.fasttrackit.bloodpressuremanager.domain.UserDetails;
import org.fasttrackit.bloodpressuremanager.dto.BloodPressureDTO;
import org.fasttrackit.bloodpressuremanager.dto.UserDTO;
import org.fasttrackit.bloodpressuremanager.dto.UserWithDetailsDTO;
import org.fasttrackit.bloodpressuremanager.exception.NotFoundException;
import org.fasttrackit.bloodpressuremanager.mapper.BloodPressureConverter;
import org.fasttrackit.bloodpressuremanager.mapper.UserConverter;
import org.fasttrackit.bloodpressuremanager.mapper.UserWithDetailsConverter;
import org.fasttrackit.bloodpressuremanager.persistence.UserDetailsRepository;
import org.fasttrackit.bloodpressuremanager.persistence.UserRepository;
import org.fasttrackit.bloodpressuremanager.util.CheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for User
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private BloodPressureService bloodPressureService;
    @Autowired
    private BloodPressureConverter bloodPressureConverter;
    @Autowired
    private UserWithDetailsConverter userWithDetailsConverter;

    public boolean saveUser(UserDTO userToSaveDto) throws Exception {
        //save a user in repository (user name and password must not be null)
        //check user's name is not null
        CheckUtils.checkStringIsNotNull(userToSaveDto.getUserName(), "User name");

        //check password is not null
        CheckUtils.checkStringIsNotNull(userToSaveDto.getPassword(), "Password");
        //set a variable to check if the user vas saved
        boolean userSaved = false;
        //check if the user name exists in repository
        boolean userExists = checkUserNameExistInRepository(userToSaveDto.getUserName());
        if (!userExists) {
            //save user
            User userObject = userConverter.convertUserToObjectFull(userToSaveDto);
            try {
                userRepository.save(userObject);
                userSaved = true;
            } catch (Exception e) {
                System.out.print("Error when saving user " + e);
            }
        } else {
            System.out.println("A user with " + userToSaveDto.getUserName() + "already exists");

            //throw new Exception("A user with " + userToSaveDto.getUserName() + " already exists");
        }
        return userSaved;
    }

    public void saveUserWithDetails(UserDTO userToSaveDto, UserDetails userDetails) throws Exception {
        //save a user with user details in repository (user name and password must not be null)
        //check user's name is not null
        CheckUtils.checkStringIsNotNull(userToSaveDto.getUserName(), "User name");

        //check password is not null
        CheckUtils.checkStringIsNotNull(userToSaveDto.getPassword(), "Password");

        //if userName does not exist save user with details
        User userObject = userConverter.convertUserToObjectFull(userToSaveDto);
        userObject.setUserDetails(userDetails);
        userDetails.setUser(userObject);
        try {
            userRepository.save(userObject);
        } catch (Exception e) {
            System.out.print("Error when saving user " + e);
            throw new Exception("A user with " + userToSaveDto.getUserName() + " already exists");
        }
    }

    public UserDTO getUserById(long id) {
        //search user by id in repository
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new IllegalArgumentException("The id is not valid.");
        }
        //convert user to dto
        UserDTO userDto = userConverter.convertUserToDTOWithoutPassword(user);
        return userDto;
    }

    public UserWithDetailsDTO UserWithDetailsDTO(long id) {
        //get a user with userDetails
        //search user by id in repository
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new IllegalArgumentException("The id is not valid.");
        }

        //search userDetails by id in repository
        UserDetails userDetails = userDetailsRepository.findOne(user.getUserDetails().getIdDetails());
        if (userDetails == null) {
            throw new IllegalArgumentException("The user details id is not valid.");
        }

        return userWithDetailsConverter.convertUserWithDetails(user, userDetails);
    }

    public UserDTO getUserWithPasswordById(long id) {
        //search user by id in repository
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new IllegalArgumentException("The id is not valid.");
        }
        //convert user to dto
        UserDTO userDto = userConverter.convertUserToDTOWithPassword(user);
        return userDto;
    }

    public UserDTO getUserByUserName(String userName) {
        //find a user in the repository by userName
        User user = userRepository.findByUserName(userName);
        //check if the user exists in repository
        if (user == null) {
            //if the id does not exist in repository, throw an exception
            throw new NotFoundException("" + userName);
        }
        //convert user to dto
        UserDTO userDto = userConverter.convertUserToDTOWithoutPassword(user);
        return userDto;
    }

    public boolean checkUserNameAndPass(String userName, String userPass) {
        //check login in repo
        boolean loginAccepted = false;
        //find a user in the repository by userName
        User user = userRepository.findByUserName(userName);
        //check if the user exists in repository
        if (user == null) {
            //if the id does not exist in repository, throw an exception
            //throw new NotFoundException("" + userName);
            return false;
        }
        //check password
        if (userPass.equals(user.getPassword())) {
            loginAccepted = true;
        }
        return loginAccepted;
    }

    public UserDTO updateUser(long id, UserDTO dto) {
        //update a user by id
        User user = userRepository.findOne(id);
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());

        User savedObject = userRepository.save(user);
        return userConverter.convertUserToDTOWithPassword(savedObject);
    }

    public boolean checkUserNameExistInRepository(String userName) {
        //heck if the user name exists in repository
        boolean userExists = false;
        //find a user in the repository by userName
        User user = userRepository.findByUserName(userName);
        //check if the user exists in repository
        if (user != null) {
            //if the user name exists in repository set the flag to true
            userExists = true;
        }
        return userExists;
    }

    public boolean checkUerIdExistInRepository(long idUser) {
        //check if the user id exists in repository
        boolean userExists = false;
        //find a user in the repository by userName
        User user = userRepository.findOne(idUser);
        //check if the user exists in repository
        if (user == null) {
            //if the user id exists in repository set the flag to true
            userExists = false;
        } else {
            userExists = true;
        }
        return userExists;
    }

    public void deleteUserWithDetailsAndBP(long idUser) {
        //delete a user from repository
        //check user ID
        boolean userExists = checkUerIdExistInRepository(idUser);
        if (userExists) {
            //if the user id exists in repository, delete the user
            //get the user object from repository
            UserDTO userDTO = getUserById(idUser);
            //get user and BloodPressures list
            User userToDelete = userConverter.convertUserToObjectFull(userDTO);
            List<BloodPressureDTO> userBPList = bloodPressureService.getBloodPressureListByUserId(idUser);
            //delete bloodPressures
            try {
                for (int i = 0; i < userBPList.size(); i++) {
                    long bpToDeleteId = userBPList.get(i).getIdBP();
                    bloodPressureService.deleteBloodPressureById(bpToDeleteId);
                }
            } catch (Exception e) {
                System.out.print("Error when deleting bloodPressure " + e);
            }
            //delete user (user details are deleted when the user is deleted)
            try {
                userRepository.delete(userToDelete);
            } catch (Exception e) {
                System.out.print("Error when deleting user " + e);
            }

        } else {
            System.out.println("User for id " + idUser + "does not exist");
        }
    }

    public void deleteUserByName(String userName) {
        //delete a user from repository
        //check user ID
        boolean userExists = checkUserNameExistInRepository(userName);
        if (userExists) {
            //if the user id exists in repository, delete the user
            //get the user object from repository
            UserDTO userDTO = getUserByUserName(userName);
            //get user, userDetails and BloodPressures list
            User userToDelete = userConverter.convertUserToObjectFull(userDTO);

            //delete user
            try {
                userRepository.delete(userToDelete);
            } catch (Exception e) {
                System.out.print("Error when deleting user " + e);
            }

        } else {
            System.out.println("User for user " + userName + "does not exist");
        }
    }
}
