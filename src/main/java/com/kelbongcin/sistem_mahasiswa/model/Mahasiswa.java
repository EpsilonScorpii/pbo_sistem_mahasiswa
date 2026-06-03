package com.kelbongcin.sistem_mahasiswa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mahasiswa")
public class Mahasiswa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nim;

    @Column(nullable = false)
    private String nama;

    private String email;
    private String jurusan;

    // --- CONSTRUCTOR ---
    public Mahasiswa() {}

    public Mahasiswa(String nim, String nama, String email, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.email = email;
        this.jurusan = jurusan;
    }

    // --- GETTER DAN SETTER ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getJurusan() { return jurusan; }
    public void setJurusan(String jurusan) { this.jurusan = jurusan; }
}