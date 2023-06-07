package chechi.homeworks.relationsdb.service;

import chechi.homeworks.relationsdb.exceptions.UserNotFoundException;
import chechi.homeworks.relationsdb.model.User;
import chechi.homeworks.relationsdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers () {

        return userRepository.findAll();
    }

    public User findUserById (int id) {

        return userRepository.findById(id).orElseThrow(() -> { throw new UserNotFoundException( "User with ID " + id + " not found."); });
    }
}
