package com.kelbongcin.sistem_mahasiswa.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kelbongcin.sistem_mahasiswa.model.User;
import com.kelbongcin.sistem_mahasiswa.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User login(String email, String password) {

        Optional<User> userOpt =
                repository.findByEmail(email);

        if (userOpt.isPresent()) {

            User user = userOpt.get();

            if (user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }
}