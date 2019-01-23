package net.ddns.ziehlke.eletopo.controller;

import lombok.RequiredArgsConstructor;
import net.ddns.ziehlke.eletopo.model.Route;
import net.ddns.ziehlke.eletopo.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/route")
public class AddRoute {
    private final RouteService routeService;

    @GetMapping("/add")
    public String addRouteGet(@ModelAttribute("route") Route route, Model model) {
        return "route";
    }


    @PostMapping
    public String addRoutePost(@ModelAttribute("route") Route route, Model model) {
        routeService.save(route);
        return "route";
    }
}
