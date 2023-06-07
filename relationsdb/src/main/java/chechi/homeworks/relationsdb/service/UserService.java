package chechi.homeworks.relationsdb.service;

import chechi.homeworks.relationsdb.exception.UserNotFoundException;
import chechi.homeworks.relationsdb.model.User;
import chechi.homeworks.relationsdb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {

    private UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers () {

        return userRepository.findAll();
    }

    public User findUserById (Integer id) {

        return userRepository.findById(id).orElseThrow(() -> { throw new UserNotFoundException( "User with ID " + id + " not found."); });
    }

    public User deleteUser (Integer id) {

        List<User> userList = userRepository.findAll();

        User user = userList.stream()
                    .filter(u -> u.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new UserNotFoundException("Can not delete. User with ID " + id + " not exist."));

            userList.remove(user);
            return user;
    }


    public User createUser(User user) {

        return userRepository.save(user);
    }
}
