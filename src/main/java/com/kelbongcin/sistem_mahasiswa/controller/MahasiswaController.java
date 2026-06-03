package com.kelbongcin.sistem_mahasiswa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kelbongcin.sistem_mahasiswa.model.Mahasiswa;
import com.kelbongcin.sistem_mahasiswa.service.MahasiswaService;

@Controller
@RequestMapping("/mahasiswa")
public class MahasiswaController {

    @Autowired
    private MahasiswaService service;

    // 1. Menampilkan Halaman Daftar Mahasiswa
    @GetMapping
    public String listMahasiswa(Model model) {
        model.addAttribute("listMahasiswa", service.getAllMahasiswa());
        return "mahasiswa/list"; // Mengarah ke templates/mahasiswa/list.html
    }

    // 2. Menampilkan Form Tambah Mahasiswa
    @GetMapping("/tambah")
    public String formTambah(Model model) {
        model.addAttribute("mahasiswa", new Mahasiswa());
        return "mahasiswa/form"; // Mengarah ke templates/mahasiswa/form.html
    }

    // 3. Proses Simpan Data (Tambah & Edit)
    @PostMapping("/simpan")
    public String simpanMahasiswa(@ModelAttribute("mahasiswa") Mahasiswa mhs) {
        service.saveMahasiswa(mhs);
        return "redirect:/mahasiswa"; // Redirect kembali ke halaman utama daftar mahasiswa
    }

    // 4. Menampilkan Form Edit
    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable("id") Long id, Model model) {
        Mahasiswa mhs = service.getMahasiswaById(id);
        model.addAttribute("mahasiswa", mhs);
        return "mahasiswa/form";
    }

    // 5. Proses Hapus Data
    @GetMapping("/hapus/{id}")
    public String hapusMahasiswa(@PathVariable("id") Long id) {
        service.deleteMahasiswa(id);
        return "redirect:/mahasiswa";
    }
}