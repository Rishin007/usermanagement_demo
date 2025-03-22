package edu.userdemo.controller;

import edu.userdemo.entity.User;
import edu.userdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crud")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("create")
    public User createUserController(@RequestBody User user) {
        return userService.createUser(user);
    }
    @GetMapping("all")
    public List<User> findAllUsersController() {
        return userService.getAllUsers();
    }

    @GetMapping("all/{userid}")
    public User getUsersController(@PathVariable(name = "userid") Integer id) {
        return userService.getUserById(id);
    }
    @PutMapping("update/{id}")
    public User updateUserController(@PathVariable Integer id, @RequestBody User user) {
        return userService.updateUser(user, id);
    }
    @DeleteMapping("delete/{id}")
    public String  deleteUserController(@PathVariable(name = "id") Integer id) {
        return userService.deleteUser(id);
    }
}

