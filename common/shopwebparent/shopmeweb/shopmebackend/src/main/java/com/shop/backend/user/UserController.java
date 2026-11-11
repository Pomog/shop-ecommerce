package com.shop.backend.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.backend.AdminMenuService;

import lombok.RequiredArgsConstructor;




@Controller
@RequestMapping("/users")
@RequiredArgsConstructor 
public class UserController {

    private final UserService userService;
    private final AdminMenuService adminMenuService;

    @GetMapping({"", "/"})
    public String listAll(Model model) {
        model.addAttribute("listUsers", userService.listAll());
        
        model.addAttribute(
            "adminMenu",
            adminMenuService.getAdminMenu()
        );

        return "users";
    }

    @GetMapping("/new")
    public String newUser (Model model) {
        model.addAttribute(
            "adminMenu",
            adminMenuService.getAdminMenu()
        );

        return "user_form";
    }

}
