package com.domain.user.Controller;

import com.domain.user.entity.User;
import com.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dimboy on 1/10/2017.
 */
@RestController
@RequestMapping("user")
public class UserLoginController {

    @Autowired
    UserRepository ur;

    @RequestMapping("login")
    @ResponseBody
    public User findByName(String username, String password) {
        User u = ur.findByUsername(username);
        if (password == null || password.trim().equals("")) {

            return u;
        } else {
            return null;
        }
    }
}
