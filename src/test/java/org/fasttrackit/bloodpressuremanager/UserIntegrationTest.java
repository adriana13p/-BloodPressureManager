package org.fasttrackit.bloodpressuremanager;

import org.fasttrackit.bloodpressuremanager.domain.User;
import org.fasttrackit.bloodpressuremanager.dto.UserDTO;
import org.fasttrackit.bloodpressuremanager.service.UserService;
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

    @Test
    public void testSaveUser() {

        //TODO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //TODO -- this test is failing with:
        //TODO:  java.lang.IllegalStateException: Failed to load ApplicationContext

        //save a user
        UserDTO userToSave = new UserDTO();
        userToSave.setUserNameDto("David13");
        userToSave.setPasswordDTO("David13");
        userService.saveUser(userToSave);
    }

    @Test
    public void testFindUser() {
        //find a user
        User userOne = userService.findOneUser(1L);
        Assert.assertNotNull(userOne);
    }
}
