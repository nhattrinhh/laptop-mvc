package vn.hoidanit.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.hoidanit.laptopshop.domain.User;
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
    public String getTableUserPage(Model model) {
        List<User> users = this.userService.getAllUsers();
        System.out.println("check user in terminal: " + users);
        model.addAttribute("users1", users);
        return "admin/user/table-user";
    }

    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        System.out.println("check path id = " + id);
        model.addAttribute("id", id);
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/show";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("updateUser", currentUser);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String postUpdateUser(Model model, @ModelAttribute("updateUser") User nhat) {
        User currentUser = this.userService.getUserById(nhat.getId());
        if(currentUser != null){
            currentUser.setEmail(nhat.getEmail());
            currentUser.setAddress(nhat.getAddress());
            currentUser.setFullName(nhat.getFullName());
            currentUser.setPhone(nhat.getPhone());
        }
        this.userService.handleSaveUser(currentUser);
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user/create")
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String getUserCreate(Model model, @ModelAttribute("newUser") User nhat) {
        // System.out.println("run here in terminal" + nhat);
        this.userService.handleSaveUser(nhat);
        return "redirect:/admin/user";
    }
}