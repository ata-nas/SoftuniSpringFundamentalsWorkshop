package com.softuni.workshop.model.entity;

import com.softuni.workshop.model.enums.LevelEnum;
import jakarta.persistence.*;
import lombok.*;

import javax.xml.stream.events.Comment;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "routes",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"name", "author_id"})
        }
)
public class RouteEntity extends BaseEntity {

    @Column(columnDefinition = "LONGTEXT")
    private String coordinates;

    @Column
    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    @Column
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private UserEntity author;

    @Column(name = "video_url")
    private String videoURL;

    @OneToMany(targetEntity = CommentEntity.class, mappedBy = "route", orphanRemoval = true)
    private Set<Comment> comments;

    @OneToMany(
            targetEntity = PictureEntity.class,
            mappedBy = "route", orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<Comment> pictures;

    @ManyToMany
    private Set<CategoryEntity> categories;

}
