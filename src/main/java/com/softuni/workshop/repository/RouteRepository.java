package com.softuni.workshop.repository;

import com.softuni.workshop.model.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long> {

    @Query(
            "SELECT r FROM RouteEntity r " +
            "ORDER BY size(r.comments) DESC " +
            "LIMIT 1"
    )
    Optional<RouteEntity> getMostCommented();

}
