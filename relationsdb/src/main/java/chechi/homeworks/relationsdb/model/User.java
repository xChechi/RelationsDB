package chechi.homeworks.relationsdb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @NotEmpty
    @NotNull
    @Size(min = 2, message = "Enter your full first name")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @NotNull
    @Size(min = 2, message = "Enter your full surname")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
    @NotNull
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "It's not valid email format")
    @Column(name = "user_email", unique = true)
    private String email;

    @NotEmpty
    @NotNull
    @JsonIgnore
    @Size(min = 8, message = "Password must be minimum 8 characters")
    @Column(name = "user_password")
    private String password;
}
