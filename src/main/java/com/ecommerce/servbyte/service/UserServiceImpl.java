package com.ecommerce.servbyte.service;

import com.ecommerce.servbyte.data.models.User;
import com.ecommerce.servbyte.data.payload.response.MessageResponse;
import com.ecommerce.servbyte.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
    UserRepository userRepository;

    @Override
    public MessageResponse addUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())){
            return new MessageResponse("Error: Email is already used");
        }
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setAddress(user.getAddress());
        newUser.setPassword(user.getPassword());
        userRepository.save(newUser);

        return new MessageResponse("sucessfully created");
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public User editUser(User user, long id) {
        return null;
    }

    @Override
    public User findUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(long id) {
    userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String name) {
        Optional<User> users = userRepository.findByUsername(name);
        if (users.isPresent()) {
            User user = users.get();
            return user;
        }
        return null;
    }
}
