package com.shop.backend.user;

import org.springframework.data.repository.CrudRepository;
import com.shop.common.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

}
