package com.softuni.workshop.model.entity;

import com.softuni.workshop.model.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

}
