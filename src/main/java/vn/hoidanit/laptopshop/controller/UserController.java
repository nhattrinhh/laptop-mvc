package vn.hoidanit.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.service.UserService;

/*@controller là 1 annotation: trang trí một class của java, giúp "tăng thêm sức mạnh" tại sao lại tăng thêm sức mạnh
tại vì khi chạy nó sẽ đọc các annotation nó sẽ truyền thêm cái "metadata"
*/

// @Controller
// public class UserController {
//     // function ứng với từng view, để làm được thì sẽ làm 1 cái class/method
//     // để truy cập cái method/class này thì 1 cái annotation tiếp theo ra đời mà
//     // spring đã cấu hình sẵn chỉ việc lấy ra dùng
//     // annotation đó là @RequestMapping nó giống như yêu cầu lên server(java), chúng
//     // gửi từ đâu từ trình duyệt web
//     @RequestMapping("/")
//     public String getHomePage() {
//         return "Hello from Controller";
//     }
//     //chạy lỗi là do chạy theo mô hình mvc
// }

@RestController
public class UserController {
    // DI: dependency injection
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getHomePage() {
        return this.userService.handleHello();
    }
}