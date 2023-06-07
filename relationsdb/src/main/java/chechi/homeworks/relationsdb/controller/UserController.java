package chechi.homeworks.relationsdb.controller;

import chechi.homeworks.relationsdb.dto.UserRequest;
import chechi.homeworks.relationsdb.model.User;
import chechi.homeworks.relationsdb.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<User> findAll () {

        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findOne(@PathVariable Integer id) {
        User user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser (@PathVariable Integer id) {

        userService.deleteUser(id);
    }

    @PostMapping("/users")
    public void createUser (@Valid @RequestBody UserRequest request) {

       userService.createUser(request);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Integer id, @Valid @RequestBody User user) {

        User existingUser = userService.findUserById(id);

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());

        return userService.updateUser(existingUser);
    }
}
