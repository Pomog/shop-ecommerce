package com.shop.backend.admin.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;

import com.shop.backend.user.RoleRepository;
import com.shop.common.entity.Role;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

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

    @Test
    @Rollback (value = false)
    public void testCreateRestRoles() {
        Role roleSalesperson = new Role("Salesperson", 
                            "Manage product price, customers, shipping, orders and sales report");
        Role roleEditor = new Role("Editor", 
                            "Manage categories, brands, products, articles and menus");
        Role roleShipper = new Role("Shipper", 
                            "View products, view orders and update order status");
        Role roleAssistant = new Role("Assistant", 
                            "Manage questions and reviews");
        List<Role> roles = List.of(roleSalesperson, roleEditor, roleShipper, roleAssistant);
        
        roleRepository.saveAll(roles);

        assertThat(roleRepository.count()).isEqualTo(4);
    }

}
