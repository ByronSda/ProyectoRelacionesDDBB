package ec.edu.uce.Persistencia.repository;

import ec.edu.uce.Persistencia.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
