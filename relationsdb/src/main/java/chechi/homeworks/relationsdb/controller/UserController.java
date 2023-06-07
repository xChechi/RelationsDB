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
    public ResponseEntity<User> deleteUser (@PathVariable Integer id) {
        User user = userService.deleteUser(id);
        return ResponseEntity.ok(user);

    }

    @PostMapping("/users")
    public void createUser (@Valid @RequestBody UserRequest request) {

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

       userService.createUser(user);
    }
}
