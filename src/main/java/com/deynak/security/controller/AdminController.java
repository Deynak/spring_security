package com.deynak.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.deynak.security.model.User;
import com.deynak.security.service.RoleService;
import com.deynak.security.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/all")
    public String allUsers(ModelMap modelMap) {
        modelMap.addAttribute("users", userService.getAllUsers());
        return "allUsersPage";
    }

    @GetMapping(value = "/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping(value = "/add")
    public String saveUser(@ModelAttribute("user") User user,
                           @RequestParam(required = false) String roleAdmin,
                           @RequestParam(required = false) String roleUser) {
        userService.assignRolesAndSaveUser(user, roleAdmin, roleUser);
        return "redirect:/admin/all";
    }

    @GetMapping(value = "/edit")
    public String editUser(ModelMap modelMap, @RequestParam("id") int id) {
        User user = userService.getUser(id);
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("allRoles", roleService.getAllRoles());
        userService.addRoleAttributes(modelMap, user);
        return "editUser";
    }

    @PostMapping(value = "/edit")
    public String postEditUser(@ModelAttribute("user") User user,
                               @RequestParam(required = false) String roleAdmin,
                               @RequestParam(required = false) String roleUser) {
        userService.assignRolesAndSaveUser(user, roleAdmin, roleUser);
        return "redirect:/admin/all";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin/all";
    }
}
