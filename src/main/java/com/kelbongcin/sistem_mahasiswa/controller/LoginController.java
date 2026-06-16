package com.kelbongcin.sistem_mahasiswa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.kelbongcin.sistem_mahasiswa.model.User;
import com.kelbongcin.sistem_mahasiswa.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password) {

        User user = service.login(email, password);
        System.out.println("Login attempt: " + email + " / " + password);
        if (user == null) {
            return "redirect:/login?error";
        }

        if ("Admin".equals(user.getRoles())) {
            return "redirect:/admin";
        }

        if ("Mahasiswa".equals(user.getRoles())) {
            return "redirect:/mahasiswa";
        }
        
        if ("Dosen".equals(user.getRoles())) {
            return "redirect:/dosen";
        }

        return "redirect:/login";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "adminPage/dashboard";
    }

    @GetMapping("/dosen")
    public String dosenPage() {
        return "dosenPage/dashboard";
    }

    @GetMapping("/mahasiswa")
    public String mahasiswaPage() {
        return "mahasiswaPage/Dashboard";
    }
}