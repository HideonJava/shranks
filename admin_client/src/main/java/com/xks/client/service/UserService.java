package com.xks.client.service;

import com.xks.client.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
    User findByUserName(String userName);
}
