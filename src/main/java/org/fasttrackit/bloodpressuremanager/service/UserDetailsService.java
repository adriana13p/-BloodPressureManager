package org.fasttrackit.bloodpressuremanager.service;

import org.fasttrackit.bloodpressuremanager.domain.User;
import org.fasttrackit.bloodpressuremanager.domain.UserDetails;
import org.fasttrackit.bloodpressuremanager.dto.UserDetailsDTO;
import org.fasttrackit.bloodpressuremanager.exception.NotFoundException;
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
        CheckUtils.checkStringIsNotNull(userDetailsDTO.getFirstNameDto(), "UserDetails's first name");

        //check second name
        CheckUtils.checkStringIsNotNull(userDetailsDTO.getSecondNameDto(), "UserDetails's second name");

        User user = userRepository.findOne(userDetailsDTO.getIdUserDto());
        UserDetails userDetailsObject = userDetailsConverter.convertToObject(userDetailsDTO, user);

        try {
            userDetailsRepository.save(userDetailsObject);
        } catch (Exception e) {
            System.out.print("Error when saving user details " + e);
        }
    }

    public void deleteUserDetails(UserDetails userDetails) {
        //delete a userDetails from repository
        //check userDetails ID
        boolean userDetailsExists = checkUserDetailsIdExistInRepository(userDetails.getIdDetails());
        if (userDetailsExists == true) {
            //if the userDetails id exists in repository, delete the user details
            try {
                userDetailsRepository.delete(userDetails);
            } catch (Exception e) {
                System.out.print("Error when deleting userDetails " + e);
            }
        } else {
            System.out.println("User details for id " + userDetails.getIdDetails() + "does not exist");
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
        userDetails.setFirstName(dto.getFirstNameDto());
        userDetails.setSecondName(dto.getSecondNameDto());
        userDetails.setIdDetails(dto.getIdDetailsDto());
        userDetails.setAge(dto.getAgeDto());
        userDetails.setGender(dto.getGenderDto());
        userDetails.setNotes(dto.getNotesDto());

        UserDetails savedObject = userDetailsRepository.save(userDetails);
        return userDetailsConverter.convertToDTO(savedObject);
    }

    public boolean checkUserDetailsIdExistInRepository(long idUserDetails) {
        //heck if the userDetails id exists in repository
        boolean userDetailsExists = false;
        //find a userDetails in the repository by userName
        UserDetails userDetails = userDetailsRepository.findOne(idUserDetails);
        //check if the userDetails exists in repository
        if (!(userDetails == null)) {
            //if the userDetails id exists in repository set the flag to true
            userDetailsExists = true;
        }
        return userDetailsExists;
    }
}
