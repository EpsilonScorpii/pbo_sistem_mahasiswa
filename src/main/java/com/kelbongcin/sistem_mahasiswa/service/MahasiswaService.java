package com.kelbongcin.sistem_mahasiswa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kelbongcin.sistem_mahasiswa.model.Mahasiswa;
import com.kelbongcin.sistem_mahasiswa.repository.MahasiswaRepository;

@Service
public class MahasiswaService {

    @Autowired
    private MahasiswaRepository repo;

    public List<Mahasiswa> getAllMahasiswa() {
        return repo.findAll();
    }

    public void saveMahasiswa(Mahasiswa mhs) {
        repo.save(mhs);
    }

    public Mahasiswa getMahasiswaById(Long id_users) {
        return repo.findById(id_users).orElse(null);
    }

    // Hapus data
    public void deleteMahasiswa(Long id_users) {
        repo.deleteById(id_users);
    }
}