package dev.aman.taskmanagementsystem.Services;

import dev.aman.taskmanagementsystem.Exceptions.UserAlreadyExistException;
import dev.aman.taskmanagementsystem.Models.User;
import dev.aman.taskmanagementsystem.Repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String userName, String password) throws UserAlreadyExistException {
        if (userRepository.findByUserName(userName).isPresent()) {
            throw new UserAlreadyExistException("Username: " + userName + " already exist.");
        }

        User user = new User();
        user.setUserName(userName);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }


}
