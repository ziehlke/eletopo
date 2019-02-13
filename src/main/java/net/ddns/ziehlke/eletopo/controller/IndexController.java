package net.ddns.ziehlke.eletopo.controller;

import lombok.AllArgsConstructor;
import net.ddns.ziehlke.eletopo.model.Route;
import net.ddns.ziehlke.eletopo.model.UserDto;
import net.ddns.ziehlke.eletopo.model.Vote;
import net.ddns.ziehlke.eletopo.service.RouteService;
import net.ddns.ziehlke.eletopo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class IndexController {
    private final RouteService routeService;
    private final UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("routes", routeService.findAllByActiveIsTrue());
        model.addAttribute("vote", new Vote());
        return "index";
    }

    @PostMapping(value = "/")
    public String voteOnGrade(Model model,
                              @Valid @ModelAttribute("vote") Vote vote,
                              BindingResult bindingResult,
                              HttpServletRequest request,
                              @RequestParam("routeId") UUID routeId) throws Exception {
        model.addAttribute("routes", routeService.findAllByActiveIsTrue());

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "index";
        }

        Route route = routeService.findById(routeId);
        UserDto userDto = userService.findByEmail(request.getUserPrincipal().getName());
        userService.map(userDto).addRouteVote(routeService.map(route), vote.getUserGrade());
        return "index";
    }


    @GetMapping("/archive")
    public String archive(Model model) {
        model.addAttribute("routes", routeService.findAllByActiveIsFalse());
        return "index";
    }
}