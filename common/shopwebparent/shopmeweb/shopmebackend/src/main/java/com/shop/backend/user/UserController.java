package com.shop.backend.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shop.backend.AdminMenuService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor 
public class UserController {

    private final UserService userService;
    private final AdminMenuService adminMenuService;

    @GetMapping("/users")
    public String listAll(Model model) {
        model.addAttribute("listUsers", userService.listAll());
        
        model.addAttribute(
            "adminMenu",
            adminMenuService.getAdminMenu()
        );

        return "users";
    }
    

}
