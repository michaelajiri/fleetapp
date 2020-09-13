package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.User;
import com.infotech.fleetapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userPage(Model model) {
        List<User> listOfUsers = userService.getAllUsers();
        model.addAttribute("listOfUsers", listOfUsers);
        return "user";
    }

    @ResponseBody
    @RequestMapping(value = "/oneUser", method = RequestMethod.GET)
    public Optional<User> getUserById(Integer id){
        return userService.getUserById(id);
    }

    //Modified method to Add a new user User
    @PostMapping(value = "/users/addNewUser")
    public RedirectView addNewUser(User user, RedirectAttributes redirectAttributes) {
        userService.addNewUser(user);
        RedirectView redirectView = new RedirectView("/login", true);
        redirectAttributes.addFlashAttribute("message", "Registration Successful! You can now login");
        return redirectView;
    }

    @RequestMapping(value = "/deleteUser", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String removeUser(Integer id){
        userService.removeUser(id);
        return "redirect:/users";
    }
}
