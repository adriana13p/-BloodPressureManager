package org.fasttrackit.bloodpressuremanager.web;

import org.fasttrackit.bloodpressuremanager.dto.UserDTO;
import org.fasttrackit.bloodpressuremanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public UserDTO geUserById(@PathVariable("id") long id) {
        //get a user by id
        return userService.getUserById(id);
    }


    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public void saveUser(@RequestBody UserDTO user) {
        LOGGER.info("user >> {}", user.getUserNameDto());
        //save a user
        userService.saveUser(user);

    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.PUT)
    public UserDTO updateUser(@PathVariable long id, @RequestBody UserDTO dto) {
        //update a user
        return userService.updateUser(id, dto);

    }
}
