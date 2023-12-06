package com.java.pagination.angularapp.service;

import com.java.pagination.angularapp.domain.User;
import org.springframework.data.domain.Page;

public interface UserService {
    Page<User> getUsers(String name, int page, int size);
}
