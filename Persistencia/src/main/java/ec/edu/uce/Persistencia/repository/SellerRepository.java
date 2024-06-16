package ec.edu.uce.Persistencia.repository;

import ec.edu.uce.Persistencia.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
