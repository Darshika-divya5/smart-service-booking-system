package com.project.servicebooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.servicebooking.entity.User;
import com.project.servicebooking.repository.UserRepository;
import com.project.servicebooking.dto.UserDTO;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User saveUser(User user) {
        return repo.save(user);
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = repo.findAll();

        return users.stream()
                .map(user -> new UserDTO(
                        user.getId(),
                        user.getName(),   // ✅ works now
                        user.getEmail()
                ))
                .toList();
    }

    public User updateUser(Long id, User user) {
        User existingUser = repo.findById(id).orElse(null);

        if (existingUser != null) {
            existingUser.setName(user.getName());  // ✅ works
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setRole(user.getRole());

            return repo.save(existingUser);
        }

        return null;
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}