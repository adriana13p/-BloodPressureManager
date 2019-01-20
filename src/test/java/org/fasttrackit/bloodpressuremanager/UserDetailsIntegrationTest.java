package org.fasttrackit.bloodpressuremanager;

import org.fasttrackit.bloodpressuremanager.domain.UserDetails;
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
@ContextConfiguration(classes = BloodPressureManagerApplication.class, loader = SpringApplicationContextLoader.class, initializers = ConfigFileApplicationContextInitializer.class)
public class UserDetailsIntegrationTest {

    @Autowired
    private UserDetailsService userDetailsService;


    @Test
    public void testSaveUserDetails() {
        //save a person with all fields filled
        UserDetailsDTO userDetailsDto = new UserDetailsDTO();
        userDetailsDto.setFirstNameDto("Precup");
        userDetailsDto.setSecondNameDto("Adriana");
        userDetailsDto.setAgeDto(33);
        userDetailsDto.setGenderDto('F');
        userDetailsDto.setNotesDto("no medication");
        userDetailsService.saveUserDetails(userDetailsDto);
    }

    @Test
    public void testFindUserDetails() {
        //find user details
        UserDetails userDetailsOne = userDetailsService.findOneUserDetails(1L);
        Assert.assertNotNull(userDetailsOne);
    }
}
