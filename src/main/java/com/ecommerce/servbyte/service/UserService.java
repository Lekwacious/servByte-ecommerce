package com.ecommerce.servbyte.service;

import com.ecommerce.servbyte.data.models.User;
import com.ecommerce.servbyte.data.payload.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    MessageResponse addUser(User user);

    List<User> findAllUsers();

    User editUser(User user, long id);

    User findUserById(long id);

    void deleteUser(long id);

    User findByUsername(String name);
}
