package net.ddns.ziehlke.eletopo.controller;

import lombok.RequiredArgsConstructor;
import net.ddns.ziehlke.eletopo.model.Route;
import net.ddns.ziehlke.eletopo.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class RouteController {
    private final RouteService routeService;

    @GetMapping("/add")
    public String addRouteGet(@ModelAttribute("route") Route route, Model model) {
        model.addAttribute("localDate", LocalDate.now());
        return "add";
    }


    @PostMapping("/add")
    public String addRoutePost(@Valid @ModelAttribute("route") Route route, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add";
        }
        routeService.save(route);
        return "add";
    }
}
