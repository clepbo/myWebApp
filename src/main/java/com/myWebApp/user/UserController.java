package com.myWebApp.user;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired private UserService service;

    @GetMapping("/users")
    public String showUserList(Model model){
        List<Users> usersList = service.listAll();
        model.addAttribute("usersList", usersList);
        return "users";
    }

    @GetMapping("/users/new")
    public String addNewUser(Model model){
        model.addAttribute("user", new Users());
        model.addAttribute("pageTitle", "Add New User");
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveUser(Users users, RedirectAttributes ra){
        service.save(users);
        ra.addFlashAttribute("message", "The User has been saved successfully!");
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try{
            Users user = service.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User {ID:} " + id);
            return "user_form";
        }catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/users";
        }
    }

    @GetMapping("users/delete/{id}")
    public String delteUser (@PathVariable("id") Integer id, RedirectAttributes ra) throws UserNotFoundException {
        try {
            service.deleteUser(id);
            ra.addFlashAttribute("message", "User Id" + id + "has been deleted successfully");
        }catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/users";
    }
}
