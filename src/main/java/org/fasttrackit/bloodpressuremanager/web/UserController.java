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


    @RequestMapping(path = "/getUserById/{id}", method = RequestMethod.GET)
    public UserDTO geUserById(@PathVariable("id") long id) {
        //get a user by id
        return userService.getUserById(id);
    }
    @RequestMapping(path = "/getUserByIdWithPass/{id}", method = RequestMethod.GET)
    public UserDTO geUserByIdWithPass(@PathVariable("id") long id) {
        //get a user by id
        return userService.getUserWithPasswordById(id);
    }
    @RequestMapping(path = "/getUserByName/{userName}", method = RequestMethod.GET)
    public UserDTO geUserByUserName(@PathVariable("userName") String userName) {
        //get a user by id
        return userService.getUserByUserName(userName);
    }

    @RequestMapping(path = "/saveUser", method = RequestMethod.POST)
    public void saveUser(@RequestBody UserDTO user) throws Exception {
        LOGGER.info("user >> {}", user.getUserName());
        //save a user
        userService.saveUser(user);

    }

    @RequestMapping(path = "/updateUser/{id}", method = RequestMethod.PUT)
    public UserDTO updateUser(@PathVariable long id, @RequestBody UserDTO dto) {
        //update a user
        return userService.updateUser(id, dto);

    }

    @RequestMapping(path = "/deleteUserWithDetailsAndBP/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable long id) throws Exception {
        //delete a user
        userService.deleteUserWithDetailsAndBP(id);
    }
}
