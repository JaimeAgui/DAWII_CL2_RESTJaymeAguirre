package APIREST.DAWII_CL2_RESTJaymeAguirre.repository;


import APIREST.DAWII_CL2_RESTJaymeAguirre.model.db.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, String> {
}
