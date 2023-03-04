package com.softuni.workshop.model.entity;

import com.softuni.workshop.model.enums.LevelEnum;

import jakarta.persistence.*;

import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;

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

    @Column(
            name = "gpx_coordinates",
            columnDefinition = "LONGTEXT"
    )
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

    @OneToMany(
            targetEntity = CommentEntity.class,
            mappedBy = "route",
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<CommentEntity> comments;

    @OneToMany(
            targetEntity = PictureEntity.class,
            mappedBy = "route",
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    @OrderBy
    private Set<PictureEntity> pictures;

    @ManyToMany
    private Set<CategoryEntity> categories;

}
