package com.kc.restdemo.service;

import com.kc.restdemo.dto.OneUserRepo;
import com.kc.restdemo.dto.UserAccountSource;

import java.util.List;

public interface UserLookupService {

    UserAccountSource getUserAccountInfo(String username);

    List<OneUserRepo> getUserRepoInfo(String username);
}
