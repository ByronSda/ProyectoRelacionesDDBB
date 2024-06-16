package ec.edu.uce.Persistencia.service.interfaces;

import ec.edu.uce.Persistencia.model.Sale;

import java.util.List;

public interface ISaleService {

    Sale saveSale(Sale sale);

    Sale getSaleById(Long id);

    List<Sale> getAllSales();

    Sale updateSale(Long id, Sale sale);

    void deleteSale(Long id);
}
