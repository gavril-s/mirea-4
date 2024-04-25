package com.example.task14;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private List<User> users = new ArrayList<>();

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        users.add(user);
        return user;
    }

    @DeleteMapping("/{index}")
    public void deleteUser(@PathVariable int index) {
        if (index >= 0 && index < users.size()) {
            users.remove(index);
        }
    }
}
