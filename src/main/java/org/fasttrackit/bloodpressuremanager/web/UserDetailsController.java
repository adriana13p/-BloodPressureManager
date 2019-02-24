package org.fasttrackit.bloodpressuremanager.web;

import org.fasttrackit.bloodpressuremanager.dto.UserDetailsDTO;
import org.fasttrackit.bloodpressuremanager.service.UserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserDetailsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsController.class);


    @Autowired
    private UserDetailsService userDetailsService;


    @RequestMapping(path = "/getUserDetails/{id}", method = RequestMethod.GET)
    public UserDetailsDTO getUserDetailsById(@PathVariable("id") long id) {
        //get a user details by id
        return userDetailsService.getUserDetailsById(id);
    }


    @RequestMapping(path = "/saveUserDetails", method = RequestMethod.POST)
    public void saveUserDetails(@RequestBody UserDetailsDTO userDetailsDTO) {
        //save user details
        userDetailsService.saveUserDetails(userDetailsDTO);

    }

    @RequestMapping(path = "/updateUserDetails/{id}", method = RequestMethod.PUT)
    public UserDetailsDTO updateUserDetails(@PathVariable long id, @RequestBody UserDetailsDTO dto) {
        //update user details
        return userDetailsService.updateUserDetails(id, dto);

    }

    @RequestMapping(path = "/deleteUserDetails/{id}", method = RequestMethod.DELETE)
    public void deleteUserDetails(@PathVariable long id) throws Exception {
        //delete a user details
        userDetailsService.deleteUserDetails(id);
    }
}
