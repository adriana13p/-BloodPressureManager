package org.fasttrackit.bloodpressuremanager;

import org.fasttrackit.bloodpressuremanager.dto.UserDetailsDTO;
import org.fasttrackit.bloodpressuremanager.service.UserDetailsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests for persons
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BloodPressureManagerApplication.class,
        loader = SpringApplicationContextLoader.class,
        initializers = ConfigFileApplicationContextInitializer.class)
public class UserDetailsIntegrationTest {

    @Autowired
    private UserDetailsService userDetailsService;


    @Test
    public void testSaveUserDetails() {
        //save a userDetails with all fields filled
        UserDetailsDTO userDetailsDto = new UserDetailsDTO();
        userDetailsDto.setIdUser(1);
        userDetailsDto.setFirstName("Precup");
        userDetailsDto.setSecondName("Adriana");
        userDetailsDto.setAge(33);
        userDetailsDto.setGender('F');
        userDetailsDto.setNotes("no medication");
        userDetailsService.saveUserDetails(userDetailsDto);
    }

    @Test
    public void testFindUserDetails() {
        //find user details
        UserDetailsDTO userDetailsDTO = userDetailsService.getUserDetailsById(1L);
        Assert.assertNotNull(userDetailsDTO);
    }

    @Test
    public void testDeleteUserDetails() {
        //delete user details
        userDetailsService.deleteUserDetails(8);
        System.out.println("User Details was deleted");

    }
}
