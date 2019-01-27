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
    public String index(Model model, Principal principal) {
        model.addAttribute("routes", routeService.findAll());
        String username;
        try {
            username = principal.getName();
        } catch (NullPointerException e)
        {
            username = "";
        }
        model.addAttribute("username", username);
        return "index";
    }
}


