package net.ddns.ziehlke.eletopo.controller;

import lombok.RequiredArgsConstructor;
import net.ddns.ziehlke.eletopo.model.UserDto;
import net.ddns.ziehlke.eletopo.service.UserService;
import net.ddns.ziehlke.eletopo.validation.EmailExistsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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
    public String registerUserAccount(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {return "/register";}

        try {
            userService.save(userDto);
        } catch (EmailExistsException e) {
            bindingResult.rejectValue("email", "error.user", e.getMessage());
            return "register";
        }
        return "redirect:/";
    }

}