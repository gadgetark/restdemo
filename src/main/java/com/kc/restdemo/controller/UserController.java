package com.kc.restdemo.controller;

import com.kc.restdemo.dto.OneUserRepo;
import com.kc.restdemo.dto.UserAccountSource;
import com.kc.restdemo.dto.UserFullInfo;
import com.kc.restdemo.model.UserRepo;
import com.kc.restdemo.service.UserLookupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        List<OneUserRepo> userRepoSource = userLookupService.getUserRepoInfo(username);

        return convertToDto(userAccountSource, userRepoSource);
    }

    private UserFullInfo convertToDto(UserAccountSource userAccountSource, List<OneUserRepo> userRepoSource) {

        UserFullInfo userFullInfo = new UserFullInfo();
        userFullInfo.setUser_name(userAccountSource.getLogin());

        userFullInfo.setRepos(convertOneUserRepoToUserRepos(userRepoSource));

        return userFullInfo;
    }

    private List<UserRepo> convertOneUserRepoToUserRepos(List<OneUserRepo> userRepoSource) {
        return Optional.ofNullable(userRepoSource).orElse(Collections.emptyList()).stream()
                .map(resource -> convertOneResource(resource))
                .collect(Collectors.toList());
    }

    private UserRepo convertOneResource(OneUserRepo oneUserRepo) {
        UserRepo userRepo = new UserRepo();
        userRepo.setName(oneUserRepo.getName());
        userRepo.setUrl(oneUserRepo.getHtml_url());
        return userRepo;
    }
}
