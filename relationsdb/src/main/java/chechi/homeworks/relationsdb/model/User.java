package chechi.homeworks.relationsdb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "relationsdb")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min = 2, message = "Enter your full first name")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(min = 2, message = "Enter your full surname")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Email
    @Column(name = "user_email", unique = true)
    private String email;

    @NotBlank
    @JsonIgnore
    @Size(min = 8, message = "Password must be atleast 8 characters")
    @Column(name = "user_password")
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Car> cars;

}
