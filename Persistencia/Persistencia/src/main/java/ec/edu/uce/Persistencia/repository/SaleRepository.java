package ec.edu.uce.Persistencia.repository;

import ec.edu.uce.Persistencia.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
