package net.ddns.ziehlke.eletopo.controller;

import lombok.AllArgsConstructor;
import net.ddns.ziehlke.eletopo.model.Vote;
import net.ddns.ziehlke.eletopo.service.RouteService;
import net.ddns.ziehlke.eletopo.service.UserService;
import net.ddns.ziehlke.eletopo.service.VoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@AllArgsConstructor
public class IndexController {
    private final RouteService routeService;
    private final VoteService voteService;
    private final UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("routes", routeService.findAllByActiveIsTrue());
        model.addAttribute("vote", new Vote());
        return "index";
    }


    @PostMapping("/")
    public String voteOnGrade(@Valid @ModelAttribute("vote") Vote vote, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            System.out.println("vote has error");
            return "index";
        }
        vote.setUserDto(userService.findByEmail(request.getUserPrincipal().getName()));
        voteService.save(vote);
        return "index";
    }


    @GetMapping("/archive")
    public String archive(Model model) {
        model.addAttribute("routes", routeService.findAllByActiveIsFalse());
        return "index";
    }
}


