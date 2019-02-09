package net.ddns.ziehlke.eletopo.controller;

import lombok.AllArgsConstructor;
import net.ddns.ziehlke.eletopo.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class IndexController {
    private final RouteService routeService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("routes", routeService.findAllByActiveIsTrue());
        return "index";
    }

    @GetMapping("/archive")
    public String archive(Model model) {
        model.addAttribute("routes", routeService.findAllByActiveIsFalse());
        return "index";
    }
}


