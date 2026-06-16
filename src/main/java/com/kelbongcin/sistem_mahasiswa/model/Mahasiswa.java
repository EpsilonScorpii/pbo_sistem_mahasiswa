package com.kelbongcin.sistem_mahasiswa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mahasiswa")
public class Mahasiswa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_users;

    private String nim;
    private String nama_mahasiswa;
    private String jurusan;
    private String email;



    @OneToOne
    @MapsId
    @JoinColumn(name="id_users")
    private User user;

    @ManyToOne
    @JoinColumn(name="id_dosen")
    private Dosen dosen;

    public Mahasiswa() {}

    public Long getId() {
        return id_users;
    }

    public void setId_users(Long id_users){
    this.id_users = id_users;
}


    public Dosen getDosen(){
    return dosen;
    }

    public void setDosen(Dosen dosen){
    this.dosen = dosen;
    }

    public void setId(Long id_users) {
        this.id_users = id_users;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama_mahasiswa;
    }

    public void setNama(String nama_mahasiswa) {
        this.nama_mahasiswa = nama_mahasiswa;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}