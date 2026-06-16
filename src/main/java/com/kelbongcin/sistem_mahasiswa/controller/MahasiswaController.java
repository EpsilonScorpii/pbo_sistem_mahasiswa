package com.kelbongcin.sistem_mahasiswa.controller;

import com.kelbongcin.sistem_mahasiswa.model.Mahasiswa;
import com.kelbongcin.sistem_mahasiswa.repository.DosenRepository;
import com.kelbongcin.sistem_mahasiswa.repository.MahasiswaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MahasiswaController {


    @Autowired
    private MahasiswaRepository repo;


    @Autowired
    private DosenRepository dosenRepo;



    @GetMapping("/mahasiswa")
    public String dashboard(Model model){

        System.out.println("MASUK DASHBOARD");

        model.addAttribute(
            "listMahasiswa",
            repo.findAll()
        );

        return "mahasiswaPage/Dashboard";
    }



    @GetMapping("/mahasiswa/tambah")
    public String formTambah(Model model){


        model.addAttribute(
            "mahasiswa",
            new Mahasiswa()
        );


        model.addAttribute(
            "listDosen",
            dosenRepo.findAll()
        );


        return "mahasiswaPage/TambahData";
    }



    @PostMapping("/mahasiswa/simpan")
    public String simpan(
            @ModelAttribute Mahasiswa mahasiswa){


        repo.save(mahasiswa);


        return "redirect:/mahasiswa";
    }



    @GetMapping("/mahasiswa/edit/{id_users}")
    public String formEdit(
            @PathVariable Long id_users,
            Model model){


        Mahasiswa mahasiswa =
                repo.findById(id_users)
                .orElse(null);


        model.addAttribute(
                "mahasiswa",
                mahasiswa
        );


        model.addAttribute(
                "listDosen",
                dosenRepo.findAll()
        );


        return "mahasiswaPage/EditData";
    }



    @PostMapping("/mahasiswa/update")
    public String update(
            @ModelAttribute Mahasiswa mahasiswa){


        repo.save(mahasiswa);


        return "redirect:/mahasiswa";
    }



    @GetMapping("/mahasiswa/hapus/{id_users}")
    public String hapus(
            @PathVariable Long id_users){


        repo.deleteById(id_users);


        return "redirect:/mahasiswa";
    }

}