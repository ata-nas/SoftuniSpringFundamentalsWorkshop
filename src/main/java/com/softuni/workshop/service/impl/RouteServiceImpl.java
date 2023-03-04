package com.softuni.workshop.service.impl;

import com.softuni.workshop.model.entity.RouteEntity;
import com.softuni.workshop.repository.RouteRepository;
import com.softuni.workshop.service.RouteService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    @Override
    public RouteEntity getMostCommented() {
        return routeRepository.getMostCommented().orElseThrow(NoSuchElementException::new);
    }

}
