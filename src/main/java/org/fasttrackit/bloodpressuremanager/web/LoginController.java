package org.fasttrackit.bloodpressuremanager.web;

import org.fasttrackit.bloodpressuremanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public boolean loginUser(@RequestParam(value = "userName", required = true) String userName,
                             @RequestParam(value = "userPass", required = true) String userPass) {
        //check login in repo
        // (find user in repo by userName, if user name and pass match return true, else return false )
        return userService.checkUserNameAndPass(userName, userPass);
    }
}
