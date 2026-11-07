package com.shop.backend.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.common.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
    }


}
