package com.softuni.workshop.model.entity;

import com.softuni.workshop.model.enums.LevelEnum;

import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import lombok.*;

import java.util.Collections;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Size(min = 2)
    private String username;

    @Column(name = "full_name")
    private String fullName;

    @Column
    @Positive
    private Integer age;

    @Column(nullable = false)
    @Size(min = 2)
    private String password;

    @Column(nullable = true, unique = true)
    @Email
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<RoleEntity> roles;

    @Column
    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    public Set<RoleEntity> getRoles() {
        return Collections.unmodifiableSet(roles);
    }

}
