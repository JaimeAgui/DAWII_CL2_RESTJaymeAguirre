package APIREST.DAWII_CL2_RESTJaymeAguirre.model.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Alumno")
@Getter
@Setter
@NoArgsConstructor
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idalumno;
    @Column(name = "apealumno")
    private String apealumno;
    @Column(name = "nomalumno")
    private String nomalumno;

}
