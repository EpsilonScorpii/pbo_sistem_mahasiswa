package com.kelbongcin.sistem_mahasiswa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/mahasiswa")
public class MahasiswaController {
   @GetMapping("/dashboard")
    public String dashboard() {
        return "mahasiswaPage/Dashboard";
   } 
}
