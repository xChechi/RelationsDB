package chechi.homeworks.relationsdb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(min = 3)
    @Column(name = "car_make")
    private String make;

    @NotBlank
    @Size(min = 3)
    @Column(name = "car_model")
    private String model;

    @NotBlank
    @Size(min = 12)
    @Column(name = "car_vin")
    private String vin;

    @NotBlank
    @Column(name = "car_plate")
    private String plate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

}
