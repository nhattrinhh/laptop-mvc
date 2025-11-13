package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;
import vn.hoidanit.laptopshop.service.UserService;

@Controller
public class UserController {
    // dependency injection
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<User> arrUsers = this.userService.getAllUsers();
        List<User> arrUsersByEmail = this.userService.getAllUserByEmail("thanh@gmail.com");
        System.out.println("All user from database(mysql)");
        System.out.println(arrUsers);
        System.out.println("search user by email");
        System.out.println(arrUsersByEmail);
        String test = this.userService.handleHello();
        model.addAttribute("nhat", test);
        model.addAttribute("nhattrinh", "from controller with model");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String getUserCreate(Model model, @ModelAttribute("newUser") User nhat) {
        // System.out.println("run here in terminal" + nhat);
        this.userService.handleSaveUser(nhat);
        return "hello";
    }
}