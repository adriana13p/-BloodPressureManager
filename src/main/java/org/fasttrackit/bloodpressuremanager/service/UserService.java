package org.fasttrackit.bloodpressuremanager.service;

import org.fasttrackit.bloodpressuremanager.domain.BloodPressure;
import org.fasttrackit.bloodpressuremanager.domain.User;
import org.fasttrackit.bloodpressuremanager.domain.UserDetails;
import org.fasttrackit.bloodpressuremanager.dto.BloodPressureDTO;
import org.fasttrackit.bloodpressuremanager.dto.UserDTO;
import org.fasttrackit.bloodpressuremanager.exception.NotFoundException;
import org.fasttrackit.bloodpressuremanager.mapper.BloodPressureConverter;
import org.fasttrackit.bloodpressuremanager.mapper.UserConverter;
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

    public void saveUser(UserDTO userToSaveDto) throws Exception {
        //save a user in repository (user name and password must not be null)
        //check user's name is not null
        CheckUtils.checkStringIsNotNull(userToSaveDto.getUserNameDto(), "User name");

        //check password is not null
        CheckUtils.checkStringIsNotNull(userToSaveDto.getPasswordDto(), "Password");

        //check if the user name exists in repository
        boolean userExists = checkUserNameExistInRepository(userToSaveDto.getUserNameDto());
        if (userExists == false) {
            //save user
            User userObject = userConverter.convertUserToObjectFull(userToSaveDto);
            try {
                userRepository.save(userObject);
            } catch (Exception e) {
                System.out.print("Error when saving user " + e);
            }
        } else {
            System.out.println("A user with " + userToSaveDto.getUserNameDto() + "already exists");

            throw new Exception("A user with " + userToSaveDto.getUserNameDto() + " already exists");
        }
    }

    public void saveUserWithDetails(UserDTO userToSaveDto, UserDetails userDetails) throws Exception {
        //save a user with user details in repository (user name and password must not be null)
        //check user's name is not null
        CheckUtils.checkStringIsNotNull(userToSaveDto.getUserNameDto(), "User name");

        //check password is not null
        CheckUtils.checkStringIsNotNull(userToSaveDto.getPasswordDto(), "Password");

        //TODO intrebare: e ok cum am facut verificarea daca userul exista deja in baza de date?
        // sau ar trebui sa o fac in alt mod verificarea?
        // e ok cum arunc exceptia in cazul in care exista deja userul sau ar trebui sa schimb ceva?
        //check if the user name exists in repository
        boolean userExists = checkUserNameExistInRepository(userToSaveDto.getUserNameDto());
        if (userExists == false) {
            //if userName does not exist save user with details
            User userObject = userConverter.convertUserToObjectFull(userToSaveDto);
            userObject.setUserDetails(userDetails);
            userDetails.setUser(userObject);
            try {
                userRepository.save(userObject);
            } catch (Exception e) {
                System.out.print("Error when saving user " + e);
            }
        } else {
            //if userName already exists throw an exception
            System.out.println("A user with " + userToSaveDto.getUserNameDto() + "already exists");

            throw new Exception("A user with " + userToSaveDto.getUserNameDto() + " already exists");
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


    public UserDTO updateUser(long id, UserDTO dto) {
        //update a user by id
        User user = userRepository.findOne(id);
        user.setUserName(dto.getUserNameDto());
        user.setPassword(dto.getPasswordDto());

        User savedObject = userRepository.save(user);
        return userConverter.convertUserToDTOWithoutPassword(savedObject);
    }

    public boolean checkUserNameExistInRepository(String userName) {
        //heck if the user name exists in repository
        boolean userExists = false;
        //find a user in the repository by userName
        User user = userRepository.findByUserName(userName);
        //check if the user exists in repository
        if (!(user == null)) {
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
        if (userExists == true) {
            //if the user id exists in repository, delete the user
            //get the user object from repository
            UserDTO userDTO = getUserById(idUser);
            //get user, userDetails and BloodPressures list
            User userToDelete = userConverter.convertUserToObjectFull(userDTO);
            UserDetails userDetails = userToDelete.getUserDetails();
            List<BloodPressureDTO> userBPList = bloodPressureService.getBloodPressureListByUserId(idUser);
            //delete bloodPressures
            //TODO intrebare: testul trece dar nu sterge din tabelul blood_pressures => nu sterge nici userul
            // pt ca: delete on table "users" violates foreign key constraint "fk_j2dgywb2kn6pnpbj52v8q9gj8" on table "blood_pressures"
            try {
                for (int i=0; i<userBPList.size();i++){
                    long bpToDeleteId = userBPList.get(i).getIdBPDto();
                    bloodPressureService.deleteBloodPressureById(bpToDeleteId);
                }
            } catch (Exception e) {
                System.out.print("Error when deleting bloodPressure " + e);
            }
           //delete user
            try {
                userRepository.delete(userToDelete);
            } catch (Exception e) {
                System.out.print("Error when deleting user " + e);
            }
           //delete userDetails
            try {
                userDetailsRepository.delete(userDetails.getIdDetails());
            } catch (Exception e) {
                System.out.print("Error when deleting userDetails " + e);
            }
        } else {
            System.out.println("User for id " + idUser + "does not exist");
        }
    }
}
