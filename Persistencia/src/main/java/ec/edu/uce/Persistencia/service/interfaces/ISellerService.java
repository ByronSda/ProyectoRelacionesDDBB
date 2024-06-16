package ec.edu.uce.Persistencia.service.interfaces;

import ec.edu.uce.Persistencia.model.Seller;

import java.util.List;

public interface ISellerService {

    Seller saveSeller(Seller seller);

    Seller getSellerById(Long id);

    List<Seller> getAllSellers();

    Seller updateSeller(Long id, Seller seller);

    void deleteSeller(Long id);
}
