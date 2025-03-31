package ru.kata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.model.User;
import ru.kata.service.UserService;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAll(ModelMap m) {
        m.addAttribute("users", userService.users());
        return "user/index";
    }

    @GetMapping("/new")
    public String newUser(ModelMap m) {
        m.addAttribute("user", new User());
        return "user/new";
    }

    @PostMapping("/new") // Создание нового пользователя
    public String createUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(ModelMap m, @RequestParam("id") int id) {
        m.addAttribute("user", userService.showUser(id));
        return "user/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        userService.update(id, user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        userService.remove(id);
        return "redirect:/";
    }
}

//@Controller
//public class UserController {
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/")
//    public String showAll(ModelMap m) {
//        m.addAttribute("users", userService.users());
//        return "user/index";
//    }
//
//    @GetMapping("/new")
//    public String newUser(ModelMap m) {
//        m.addAttribute("user", new User());
//        return "user/new";
//    }
//
//    @PostMapping("/new") // Убедитесь, что путь соответствует вашему маршруту
//    public String createUser(@ModelAttribute("user") User user) {
//        userService.add(user);
//        return "redirect:/";
//    }
//
//    @GetMapping("/edit")
//    public String edit(ModelMap m, @RequestParam("id") int id) {
//        m.addAttribute("user", userService.showUser(id));
//        return "user/edit";
//    }
//
//    @PatchMapping("/update")
//    public String update(@ModelAttribute("user") User user, @RequestParam("id") int id) {
//        userService.update(id, user);
//        return "redirect:/";
//    }
//
//    @DeleteMapping("/delete")
//    public String delete(@RequestParam("id") int id) {
//        userService.remove(id);
//        return "redirect:/";
//    }
//}