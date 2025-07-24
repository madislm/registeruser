package com.madislm.registeruser.controller;

import com.madislm.registeruser.model.User;
import com.madislm.registeruser.service.SectorService;
import com.madislm.registeruser.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class RegisterUserController {

    private final SectorService sectorService;
    private final UserService userService;

    @GetMapping("/")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("sectors", sectorService.findAllAndGroup());
        return "index";
    }

    @PostMapping("/processRegisterForm")
    public String processRegisterForm(
            @Valid @ModelAttribute("user") User user,
            BindingResult bindingResult,
            Model model
    ) {
        model.addAttribute("sectors", sectorService.findAllAndGroup());
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "index";
        }

        if (user.getId() == null || userService.findById(user.getId()) == null) {
            userService.save(user);
        } else
            userService.update(user);

        model.addAttribute("user", user);
        return "index";
    }
}
