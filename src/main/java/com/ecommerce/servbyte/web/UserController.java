package com.ecommerce.servbyte.web;

import com.ecommerce.servbyte.data.models.User;
import com.ecommerce.servbyte.data.payload.response.MessageResponse;
import com.ecommerce.servbyte.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    MessageResponse addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/admin/findAllUsers")
    List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @PutMapping("/editUser/{id}")
    User editUser(@RequestBody User user, @PathVariable long id) {
        return userService.editUser(user, id);
    }

    @GetMapping("/findUserById/{id}")
    User findUserById(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/findByUsername/{username}")
    User findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
