package chechi.homeworks.relationsdb.component;

import chechi.homeworks.relationsdb.dto.UserRequest;
import chechi.homeworks.relationsdb.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserBuilder {

    public User buildUser (UserRequest request) {

        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();

    }
}
