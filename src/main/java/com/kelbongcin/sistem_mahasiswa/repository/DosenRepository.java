package com.kelbongcin.sistem_mahasiswa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kelbongcin.sistem_mahasiswa.model.Dosen;

public interface DosenRepository 
        extends JpaRepository<Dosen, Long> {

}