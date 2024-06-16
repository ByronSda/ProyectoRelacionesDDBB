package ec.edu.uce.Persistencia.service.Impl;

import ec.edu.uce.Persistencia.model.Sale;
import ec.edu.uce.Persistencia.repository.SaleRepository;
import ec.edu.uce.Persistencia.service.interfaces.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements ISaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Sale saveSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public Sale getSaleById(Long id) {
        Optional<Sale> sale = saleRepository.findById(id);
        return sale.orElse(null);
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public Sale updateSale(Long id, Sale sale) {
        if (saleRepository.existsById(id)) {
            sale.setId(id);
            return saleRepository.save(sale);
        }
        return null;
    }

    @Override
    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }
}