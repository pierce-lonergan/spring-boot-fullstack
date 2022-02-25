package com.example.demo.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getAllStudents() {
        List<User> allUsers = userService.getAllStudents();
        return allUsers;
    }

    @PostMapping
    public void addStudent(@RequestBody User user){
        userService.addStudent(user);
    }

    /**
     * DELETE /delete --> delete a Student from the database.
     */
    @DeleteMapping(path="{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId) {
        userService.deleteUser(userId);
    }

    /**
     * PUT /update --> update a particular Students name or email within the database.
     */
    @PutMapping(path="{userId}")
    public void updateStudent(@PathVariable("userId") Integer userId,
                              @RequestParam(required = false) String email){
        userService.updateUser(userId, email );

    }

}
