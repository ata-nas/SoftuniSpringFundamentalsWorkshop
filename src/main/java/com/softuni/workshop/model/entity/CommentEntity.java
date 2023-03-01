package com.softuni.workshop.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity {

    @Column
    private Boolean approved;

    @Column
    @PastOrPresent
    private LocalDateTime created;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private RouteEntity route;

}
