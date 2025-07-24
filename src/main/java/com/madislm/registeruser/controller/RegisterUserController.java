package com.madislm.registeruser.controller;

import com.madislm.registeruser.service.SectorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class RegisterUserController {

    private final SectorService sectorService;

    @GetMapping("/")
    public String showRegisterForm(Model model) {
        model.addAttribute("sectors", sectorService.findAllAndGroup());
        return "index";
    }
}
