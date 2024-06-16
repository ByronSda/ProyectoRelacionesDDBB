package ec.edu.uce.Persistencia.repository;

import ec.edu.uce.Persistencia.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
