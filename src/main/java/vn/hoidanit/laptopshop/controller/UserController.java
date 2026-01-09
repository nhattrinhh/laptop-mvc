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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = userService.handleHello();
        model.addAttribute("eric", test);
        model.addAttribute("nhat", "Hello Nhat dep trai");

        List<User> allUsers = this.userService.getAllUsers();
        System.out.println("ALL USER: " + allUsers);

        List<User> userByEmail = this.userService.getUserByEmail("trinhthanhnhat123@gmail.com");
        System.out.println("USER BY EMAIL" + userByEmail);
        return "hello";
    }
    
    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUsers();
        System.out.println("CHECK USERS:" + users);
        model.addAttribute("users", users);
        return "admin/user/table-user";
    }

    @GetMapping("/admin/user/detail/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        System.out.println("CHECK PATH ID: " + id);
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/show";
    }

    @RequestMapping("/admin/user/create")
    public String getUserCreatePage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping( value = "/admin/user/create1", method = RequestMethod.POST)
    public String postUserCreate(Model model, @ModelAttribute("newUser") User hoidanit) {
        System.out.println("click btn Create user" + hoidanit);
        userService.handleSaveUser(hoidanit);
        return "redirect:/admin/user";
    }
    
    @RequestMapping("/admin/user/update/{id}")
    public String getUserUpdatePage(Model model, @PathVariable long id) {
        System.out.println("CHECK PATH ID: " + id);
        User user = this.userService.getUserById(id);
        model.addAttribute("updateUser", user);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String postUserUpdate(Model model, @ModelAttribute("updateUser") User nhat) {
        User user = this.userService.getUserById(nhat.getId());
        System.out.println("Check user: " + user);
        if (user != null) {
            user.setFullName(nhat.getFullName());
            user.setAddress(nhat.getAddress());
            user.setPhone(nhat.getPhone());
            this.userService.handleSaveUser(user);
        } else
            System.out.println("Nguoi dung khong ton tai");

        return "redirect:/admin/user";
    }
    
    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        User user = new User();
        user.setId(id);
        model.addAttribute("deleteUser", user);
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String postDeleteUser(Model model, @ModelAttribute("deleteUser") User user) {
        this.userService.handleDeleteUser(user.getId());
        return "redirect:/admin/user";
    }
}
