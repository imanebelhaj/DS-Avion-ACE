package ma.xproce.controlprep.dao.entities;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id_Avion;
    String model;
    String color;
    String matricul;
    float price;
}
