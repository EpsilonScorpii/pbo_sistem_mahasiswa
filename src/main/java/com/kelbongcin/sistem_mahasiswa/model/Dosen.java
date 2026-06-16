package com.kelbongcin.sistem_mahasiswa.model;

import jakarta.persistence.*;

@Entity
public class Dosen {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_dosen;


    private String nama_dosen;



    public Long getId_dosen(){
        return id_dosen;
    }


    public String getNama_dosen(){
        return nama_dosen;
    }


    public void setNama_dosen(String nama_dosen){
        this.nama_dosen = nama_dosen;
    }

}