package com.kelbongcin.sistem_mahasiswa.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kelbongcin.sistem_mahasiswa.model.User;

public interface UserRepository
        extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}