package com.java.pagination.angularapp.service.implementation;

import com.java.pagination.angularapp.domain.User;
import com.java.pagination.angularapp.repository.UserRepository;
import com.java.pagination.angularapp.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import static org.springframework.data.domain.PageRequest.of;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public Page<User> getUsers(String name, int page, int size) {
        log.info("Fetching Users from page {} and size{} ",page, size);
        return userRepository.findByNameContaining(name, of(page, size));
    }
}
