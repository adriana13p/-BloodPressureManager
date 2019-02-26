package org.fasttrackit.bloodpressuremanager.service;

import org.fasttrackit.bloodpressuremanager.domain.User;
import org.fasttrackit.bloodpressuremanager.domain.UserDetails;
import org.fasttrackit.bloodpressuremanager.dto.UserDetailsDTO;
import org.fasttrackit.bloodpressuremanager.mapper.UserDetailsConverter;
import org.fasttrackit.bloodpressuremanager.persistence.UserDetailsRepository;
import org.fasttrackit.bloodpressuremanager.persistence.UserRepository;
import org.fasttrackit.bloodpressuremanager.util.CheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service for UserDetails
 */
@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsConverter userDetailsConverter;


    public void saveUserDetails(UserDetailsDTO userDetailsDTO) {
        //save user details in repository (first name and second name must not be null)
        //check first name
        CheckUtils.checkStringIsNotNull(userDetailsDTO.getFirstName(), "UserDetails's first name");

        //check second name
        CheckUtils.checkStringIsNotNull(userDetailsDTO.getSecondName(), "UserDetails's second name");

        User user = userRepository.findOne(userDetailsDTO.getIdUser());
        UserDetails userDetailsObject = userDetailsConverter.convertToObject(userDetailsDTO, user);

        try {
            userDetailsRepository.save(userDetailsObject);
        } catch (Exception e) {
            System.out.print("Error when saving user details " + e);
        }
    }

    public void deleteUserDetails(long idUserDetails) {
        //delete a userDetails from repository
        //check userDetails ID
        boolean userDetailsExists = checkUserDetailsIdExistInRepository(idUserDetails);
        if (userDetailsExists) {
            //if the userDetails id exists in repository, delete the user details
            UserDetailsDTO userDetailsDTO = getUserDetailsById(idUserDetails);
            //getUser
            User user = userRepository.findOne(idUserDetails);
            //convertTo object
            UserDetails userDetailsToDelete = userDetailsConverter.convertToObject(userDetailsDTO, user);
            //delete userDetails
            try {
                userDetailsRepository.delete(userDetailsToDelete);
            } catch (Exception e) {
                System.out.print("Error when deleting userDetails " + e);
            }
        } else {
            System.out.println("User details for id " + idUserDetails + "does not exist");
        }
    }

    public UserDetailsDTO getUserDetailsById(long idUserDetails) {
        //search userDetails by id in repository
        UserDetails userDetails = userDetailsRepository.findOne(idUserDetails);
        if (userDetails == null) {
            throw new IllegalArgumentException("The user details id is not valid.");
        }
        return userDetailsConverter.convertToDTO(userDetails);
    }

    public UserDetailsDTO updateUserDetails(long id, UserDetailsDTO dto) {
        //update a userDetails by id
        UserDetails userDetails = userDetailsRepository.findOne(id);
        userDetails.setFirstName(dto.getFirstName());
        userDetails.setSecondName(dto.getSecondName());
        userDetails.setIdDetails(dto.getIdDetails());
        userDetails.setAge(dto.getAge());
        userDetails.setGender(dto.getGender());
        userDetails.setNotes(dto.getNotes());

        UserDetails savedObject = userDetailsRepository.save(userDetails);
        return userDetailsConverter.convertToDTO(savedObject);
    }

    public boolean checkUserDetailsIdExistInRepository(long idUserDetails) {
        //heck if the userDetails id exists in repository
        boolean userDetailsExists = false;
        //find a userDetails in the repository by userName
        UserDetails userDetails = userDetailsRepository.findOne(idUserDetails);
        //check if the userDetails exists in repository
        if (userDetails != null) {
            //if the userDetails id exists in repository set the flag to true
            userDetailsExists = true;
        }
        return userDetailsExists;
    }
}
