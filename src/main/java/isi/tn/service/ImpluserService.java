package isi.tn.service;

import isi.tn.entities.User;
import isi.tn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ImpluserService implements IuserService {

    private final UserRepository userRepository;

    @Autowired
    public ImpluserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User updateUser(Long userId, User user) {

        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));


        existingUser.setEmail(user.getEmail());
        existingUser.setPwd(user.getPwd());
        existingUser.setFname(user.getFname());
        existingUser.setLname(user.getLname());


        return userRepository.save(existingUser);
    }
    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    @Override
    public User patchUser(Long userId, User user) {
        // Retrieve the existing user
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        // Update only the provided fields
        if (user.getEmail() != null) {
            existingUser.setEmail(user.getEmail());
        }
        if (user.getPwd() != null) {
            existingUser.setPwd(user.getPwd());
        }
        if (user.getFname() != null) {
            existingUser.setFname(user.getFname());
        }
        if (user.getLname() != null) {
            existingUser.setLname(user.getLname());
        }

        // Save the updated user
        return userRepository.save(existingUser);
    }


}
