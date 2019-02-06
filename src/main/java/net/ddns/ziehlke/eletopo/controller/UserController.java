package net.ddns.ziehlke.eletopo.controller;

import lombok.RequiredArgsConstructor;
import net.ddns.ziehlke.eletopo.model.UserDto;
import net.ddns.ziehlke.eletopo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }


    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("user") UserDto userDto) {
        System.out.println("------ regiter POST received -----------");
        try {
            userService.save(userDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

}