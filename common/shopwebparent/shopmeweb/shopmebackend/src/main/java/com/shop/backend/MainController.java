package com.shop.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;


@Controller
@RequiredArgsConstructor
public class MainController {
    private final AdminMenuService adminMenuService;
    

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute(
            "adminMenu",
            adminMenuService.getAdminMenu()
        );

        return "index";
    }
    

}
