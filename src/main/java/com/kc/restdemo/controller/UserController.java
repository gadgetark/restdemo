package com.kc.restdemo.controller;

import com.kc.restdemo.dto.UserAccountSource;
import com.kc.restdemo.dto.UserFullInfo;
import com.kc.restdemo.service.UserLookupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserLookupService userLookupService;

    public UserController(UserLookupService userLookupService) {
        this.userLookupService = userLookupService;
    }

    @GetMapping("/{username}")
    public UserFullInfo getTransformedUserFullInfo(@PathVariable String username) {


        // It is okay to do data transformation in controller as there is no business logic
        UserAccountSource userAccountSource = userLookupService.getUserAccountInfo(username);

        return convertToDto(userAccountSource);
    }

    private UserFullInfo convertToDto(UserAccountSource userAccountSource) {

        UserFullInfo userFullInfo = new UserFullInfo();
        userFullInfo.setUser_name(userAccountSource.getLogin());

        return userFullInfo;
    }
}
