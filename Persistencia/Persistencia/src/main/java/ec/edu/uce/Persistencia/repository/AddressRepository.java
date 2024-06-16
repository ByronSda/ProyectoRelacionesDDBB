package ec.edu.uce.Persistencia.repository;

import ec.edu.uce.Persistencia.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
