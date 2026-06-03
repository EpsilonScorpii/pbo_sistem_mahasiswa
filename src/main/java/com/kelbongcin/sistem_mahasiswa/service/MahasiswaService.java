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

    // Ambil semua data
    public List<Mahasiswa> getAllMahasiswa() {
        return repo.findAll();
    }

    // Simpan atau Update data
    public void saveMahasiswa(Mahasiswa mhs) {
        repo.save(mhs);
    }

    // Ambil data berdasarkan ID (untuk edit)
    public Mahasiswa getMahasiswaById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // Hapus data
    public void deleteMahasiswa(Long id) {
        repo.deleteById(id);
    }
}