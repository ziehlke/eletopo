package net.ddns.ziehlke.eletopo.controller;

import lombok.AllArgsConstructor;
import net.ddns.ziehlke.eletopo.model.Grade;
import net.ddns.ziehlke.eletopo.service.RouteService;
import net.ddns.ziehlke.eletopo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class IndexController {
    private final RouteService routeService;
    private final UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("routes", routeService.findAllByActiveIsTrue());
        return "index";
    }

    @PostMapping(value = "/")
    public String voteOnGrade(Model model,
                              HttpServletRequest request,
                              @RequestParam("routeId") UUID routeId,
                              @RequestParam("userGrade") Grade userGrade) throws Exception {
        model.addAttribute("routes", routeService.findAllByActiveIsTrue());

        userService.addVote(
                request.getUserPrincipal().getName(),
                routeService.findById(routeId),
                userGrade);
        return "index";
    }


    @GetMapping("/archive")
    public String archive(Model model) {
        model.addAttribute("routes", routeService.findAllByActiveIsFalse());
        return "index";
    }
}