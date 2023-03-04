package com.softuni.workshop.web;

import com.softuni.workshop.model.entity.RouteEntity;
import com.softuni.workshop.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {

    private final RouteService routeService;

    @GetMapping("")
    public String home(Model model) {
        RouteEntity route = routeService.getMostCommented();

        model.addAttribute("mostCommented", route);
        return "index";
    }

}

