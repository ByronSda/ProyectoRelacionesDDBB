package ec.edu.uce.Persistencia.service.Impl;

import ec.edu.uce.Persistencia.model.Seller;
import ec.edu.uce.Persistencia.repository.SellerRepository;
import ec.edu.uce.Persistencia.service.interfaces.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SellerServiceImpl implements ISellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public Seller saveSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public Seller getSellerById(Long id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        return seller.orElse(null);
    }

    @Override
    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    @Override
    public Seller updateSeller(Long id, Seller seller) {
        if (sellerRepository.existsById(id)) {
            seller.setId(id);
            return sellerRepository.save(seller);
        }
        return null;
    }

    @Override
    public void deleteSeller(Long id) {
        sellerRepository.deleteById(id);
    }
}
