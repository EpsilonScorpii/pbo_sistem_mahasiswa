package com.kelbongcin.sistem_mahasiswa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.regex.Pattern;

import com.kelbongcin.sistem_mahasiswa.model.User;
import com.kelbongcin.sistem_mahasiswa.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService service;
    String GmailPattern =  "^[A-Za-z0-9._%+-]+@gmail\\.com$";
    

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password, Model model) {

        User user = service.login(email, password);
        boolean isEmailValid = Pattern.matches(GmailPattern, email);

        if (!isEmailValid) {
        model.addAttribute(
            "emailError",
            "Format email tidak valid");
        return "login";
    }


        if (!isEmailValid) {
            return "redirect:/login?error";
        }

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

    @GetMapping("/mahasiswa-page")
    public String mahasiswaPage() {
        return "mahasiswaPage/Dashboard";
    }
}