package org.fasttrackit.bloodpressuremanager;

import org.fasttrackit.bloodpressuremanager.dto.UserDTO;
import org.fasttrackit.bloodpressuremanager.dto.UserDetailsDTO;
import org.fasttrackit.bloodpressuremanager.mapper.UserDetailsConverter;
import org.fasttrackit.bloodpressuremanager.service.BloodPressureService;
import org.fasttrackit.bloodpressuremanager.service.UserService;
import org.fasttrackit.bloodpressuremanager.util.PrintUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests for users
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BloodPressureManagerApplication.class,
        loader = SpringApplicationContextLoader.class,
        initializers = ConfigFileApplicationContextInitializer.class)

public class UserIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private BloodPressureService bloodPressureService;

    @Autowired
    private UserDetailsConverter userDetailsConverter;

    @Test
    public void testSaveUser() throws Exception {

        //save a user
        UserDTO userToSave = new UserDTO();
        userToSave.setUserNameDto("David13");
        userToSave.setPasswordDto("David13");
        userService.saveUser(userToSave);
    }

    @Test
    public void testSaveUserWithDetails() throws Exception {

        //save a user with userDetails
        UserDTO userToSave = new UserDTO();
        userToSave.setUserNameDto("Cris36");
        userToSave.setPasswordDto("Cris36");

        //save a userDetails with all fields filled
        UserDetailsDTO userDetailsDto = new UserDetailsDTO();
        userDetailsDto.setFirstNameDto("Avram");
        userDetailsDto.setSecondNameDto("Cristian");
        userDetailsDto.setAgeDto(36);
        userDetailsDto.setGenderDto('M');
        userDetailsDto.setNotesDto("treatment with Prestarium 5mg");
        //save the user with the user details
        userService.saveUserWithDetails(userToSave, userDetailsConverter.convertToObjectWithoutUser(userDetailsDto));
    }

    @Test
    public void testFindUserById() {
        //find a user by Id
        UserDTO userToFind = userService.getUserById(7L);
        Assert.assertNotNull(userToFind);
        //print user Name and Id
        PrintUtils.printUserNameAndId(userToFind);
    }

    @Test
    public void testFindUserByUserName() {
        //find a user by Id
        UserDTO userToFind = userService.getUserByUserName("Cris35");
        Assert.assertNotNull(userToFind);
        //print user Name and Id
        PrintUtils.printUserNameAndId(userToFind);
    }

    @Test
    public void updateAUser(){
        //update a user
        UserDTO userToUpdate = new UserDTO();
        userToUpdate.setUserNameDto("Laura");
        userToUpdate.setPasswordDto("Laura");
        userService.updateUser(5, userToUpdate);
        System.out.println("User was updated");
    }
}
