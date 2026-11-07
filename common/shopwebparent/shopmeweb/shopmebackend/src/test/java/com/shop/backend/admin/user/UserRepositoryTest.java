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
    public void testCreateNewUserWithOneRole() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setFirstName("William");
        user.addRole(entityManager.find(Role.class, 10L));
        
        userRepository.save(user);

        assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    @Rollback(value = true)
    public void testCreateNewUserWithTwoRoles() {
        User user = new User();
        user.setEmail("test2@example.com");
        user.setPassword("password");
        user.setFirstName("William2");
        user.addRole(entityManager.find(Role.class, 10L));
        user.addRole(entityManager.find(Role.class, 11L));

        User savedUser = userRepository.save(user);

        assertThat(savedUser.getId()).isEqualTo(user.getId());
    }

    @Test
    public void testListAllUsers() {
        Iterable<User> listUsers = userRepository.findAll();
        listUsers.forEach(user -> System.out.println(user));
        assertThat(listUsers).hasSizeGreaterThan(0);
    }

    @Test 
    public void testGetUserById() {
        User user = userRepository.findById(1L).get();
        System.out.println(user);
        assertThat(user).isNotNull();
    }

    @Test
    @Rollback(value = true)
    public void testUpdateUserDetails() {
        String newEmail = "test_updated@example.com";
        User user = userRepository.findById(1L).get();
        user.setEnabled(true);
        user.setEmail(newEmail);
        User savedUser = userRepository.save(user);
        assertThat(savedUser.getEmail()).isEqualTo(newEmail);
    }

    @Test
    @Rollback (value = true)
    public void testUpdateUserRoles() {
        User user = userRepository.findById(1L).get();
        Role roleSalesperson = entityManager.find(Role.class, 12L);
        
        assertThat(user.getRoles()).doesNotContain(roleSalesperson);
        user.addRole(roleSalesperson);
        
        User savedUser = userRepository.save(user);
        assertThat(savedUser.getRoles()).contains(roleSalesperson);
    }

    @Test
    @Rollback (value = true)
    public void testDeleteUser() {
        Long userId = 1L;
        userRepository.deleteById(userId);
        assertThat(userRepository.findById(userId)).isEmpty();
    }
}