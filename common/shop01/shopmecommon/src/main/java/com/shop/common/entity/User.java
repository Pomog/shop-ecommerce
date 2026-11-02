package com.shop.common.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128, name = "email", nullable = false, unique = false)
    @NonNull
    private String email;

    @NonNull
    @Column(length = 64, name = "password", nullable = false)
    private String password;

    @Column (length = 45, name = "first_name", nullable = true)
    private String firstName;

    @Column(length = 45, name = "last_name", nullable = true)
    private String lastName;

    @Column (length = 128, name = "photos", nullable = true)
    private String photo;

    @Column (name = "enabled", nullable = true)
    private boolean enabled;

    @ManyToMany
    @JoinTable(
        name = "users_roles",
        joinColumns = @jakarta.persistence.JoinColumn(name = "user_id"),
        inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "role_id")
        )
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        this.roles.add(role);
    }

}
