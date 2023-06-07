package chechi.homeworks.relationsdb.controller;

import chechi.homeworks.relationsdb.model.User;
import chechi.homeworks.relationsdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<User> findAll () {

        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findOne(@PathVariable int id) {
        User user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }
    /* - If you want to return msg only
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    */
}
