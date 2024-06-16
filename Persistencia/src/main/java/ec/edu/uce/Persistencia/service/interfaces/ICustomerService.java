package ec.edu.uce.Persistencia.service.interfaces;

import ec.edu.uce.Persistencia.model.Customer;

import java.util.List;

public interface ICustomerService {

    Customer saveCustomer(Customer customer);

    Customer getCustomerById(Long id);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);

}


