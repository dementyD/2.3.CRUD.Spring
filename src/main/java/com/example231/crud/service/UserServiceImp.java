package com.example231.crud.service;

import com.example231.crud.model.User;
import com.example231.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Long id, User user) {
        User userUpdate = getUserById(id);
        userUpdate.setName(user.getName());
        userUpdate.setAge(user.getAge());
        userUpdate.setEmail(user.getEmail());
        userRepository.save(userUpdate);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }
}
