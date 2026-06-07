package com.kelbongcin.sistem_mahasiswa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/dosen")
public class DosenController {
   @GetMapping("/dashboard")
    public String dashboard() {
        return "dosenPage/Dashboard";
   } 
}
