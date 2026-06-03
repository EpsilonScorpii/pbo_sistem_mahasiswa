package com.kelbongcin.sistem_mahasiswa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kelbongcin.sistem_mahasiswa.model.Mahasiswa;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {
    // JpaRepository sudah menyediakan fungsi bawaan seperti findAll(), save(), deleteById(), dll.
}