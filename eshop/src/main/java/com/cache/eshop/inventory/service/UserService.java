package com.cache.eshop.inventory.service;

import com.cache.eshop.inventory.model.User;

public interface UserService {
    public User findUserInfo();
    public User getCachedUserInfo() ;
}
