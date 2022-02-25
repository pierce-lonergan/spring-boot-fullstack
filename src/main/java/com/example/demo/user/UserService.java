package com.example.demo.user;
// anything that ends with the postfix Service contains
// the business logic

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllStudents() { //ideally we would want to get pagination
        return userRepository.findAll();

    }

    public void addStudent(User user) {
        userRepository.save(user);
    }


    public void deleteUser(Integer userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists) {
            throw new IllegalStateException("student with id " + userId + " does not exit");
        }
        userRepository.deleteById(userId);

    }


    @Transactional // this annotation allows us to not use Querys to update
    public void updateUser(Integer userId, String email) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exit"));

        /*Here we must check the same conditions as above before preceding.
         */
        if(email != null && email.length() > 0 && !Objects.equals(user.getEmail(),email)) {
            Optional<User> studentOptional = userRepository.findBy
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("The email " + email + " is taken already, pick a different one. studentOptional: " + studentOptional);
            }
            user.setEmail(email); //updated student email
        }
    }
}
