package com.shop.backend.admin.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.shop.backend.user.RoleRepository;
import com.shop.common.entity.Role;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoleRepositoryTest {

    @Autowired 
    private RoleRepository roleRepository;

    @Test
    public void testCreateFirstRole() {
        Role roleAdmin = new Role();
        roleAdmin.setName("Admin");
        roleAdmin.setDescription("Manage everything");
        
        Role savedRole = roleRepository.save(roleAdmin);
        
        assertThat(savedRole.getId()).isGreaterThan(0);
    }

}
