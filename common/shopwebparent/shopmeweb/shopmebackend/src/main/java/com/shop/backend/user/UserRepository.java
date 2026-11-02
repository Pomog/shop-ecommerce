package com.shop.backend.user;

import org.springframework.data.repository.CrudRepository;

import com.shop.common.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
