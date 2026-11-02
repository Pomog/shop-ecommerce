package com.shop.backend.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shop.backend.user.UserRepository;
import com.shop.common.entity.Role;
import com.shop.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired 
    private UserRepository userRepository;

    @Autowired 
    private TestEntityManager entityManager;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setFirstName("William");
        user.addRole(entityManager.find(Role.class, 10L));
        
        userRepository.save(user);

        assertThat(user.getId()).isGreaterThan(0);
    }
}
