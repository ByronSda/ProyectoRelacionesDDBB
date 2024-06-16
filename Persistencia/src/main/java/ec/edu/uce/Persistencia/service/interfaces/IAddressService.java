package ec.edu.uce.Persistencia.service.interfaces;

import ec.edu.uce.Persistencia.model.Address;

import java.util.List;

public interface IAddressService {

    Address saveAddress(Address address);

    Address getAddressById(Long id);

    List<Address> getAllAddresses();

    Address updateAddress(Long id, Address address);

    void deleteAddress(Long id);
}
