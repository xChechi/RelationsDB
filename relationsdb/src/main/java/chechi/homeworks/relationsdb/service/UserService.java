package chechi.homeworks.relationsdb.service;

import chechi.homeworks.relationsdb.component.UserBuilder;
import chechi.homeworks.relationsdb.dto.UserRequest;
import chechi.homeworks.relationsdb.exception.UserNotFoundException;
import chechi.homeworks.relationsdb.model.User;
import chechi.homeworks.relationsdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {

    private UserRepository userRepository;
    private UserBuilder userBuilder;


    @Autowired
    public UserService(UserRepository userRepository, UserBuilder userBuilder) {
        this.userRepository = userRepository;
        this.userBuilder = userBuilder;
    }

    public List<User> findAllUsers () {

        return userRepository.findAll();
    }

    public User findUserById (Integer id) {

        return userRepository.findById(id).orElseThrow(() -> { throw new UserNotFoundException( "User with ID " + id + " not found."); });
    }

    public void deleteUser (Integer id) {

        userRepository.deleteById(id);
    }


    public User createUser(UserRequest request) {

        User user = userBuilder.buildUser(request);
        return userRepository.save(user);
    }

    public User updateUser (User user) {

        return userRepository.save(user);
    }

}
