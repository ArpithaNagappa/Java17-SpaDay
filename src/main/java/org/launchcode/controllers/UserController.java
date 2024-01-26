package org.launchcode.controllers;

import org.launchcode.data.UserData;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("user")
public class UserController {
    private UserData userData = new UserData();

    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping()
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
// add form submission handling code here
        model.addAttribute("user",user);
        model.addAttribute("verify",verify);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        if (user.getPassword().equals(verify)) {
            userData.add(user);
            model.addAttribute(this.userData.getAll());
            return "user/index";
        } else {
            model.addAttribute("error", "Make sure those passwords match!");

            return "user/add";
        }
    }

    @GetMapping("/{id/details}")
    public String getUserDetails(Model model, @RequestParam int id) {
        User user = this.userData.getById(id);
        if (user == null) {
            User fakeuser = new User();
            fakeuser.setUsername("id");
            fakeuser.setEmail("FAKE");
            model.addAttribute("user", fakeuser);
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date(System.currentTimeMillis());
            String formattedDate = formatter.format(date);
            System.out.println(formattedDate);
            model.addAttribute("user", user);
            model.addAttribute("date");
        }
        return "user/details";

    }
}
