package com.kc.restdemo.service;

import com.kc.restdemo.dto.UserAccountSource;

public interface UserLookupService {

    UserAccountSource getUserAccountInfo(String username);
}
