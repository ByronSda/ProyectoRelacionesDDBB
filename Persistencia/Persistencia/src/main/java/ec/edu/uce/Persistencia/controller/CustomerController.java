package ec.edu.uce.Persistencia.controller;

import ec.edu.uce.Persistencia.model.Address;
import ec.edu.uce.Persistencia.model.Customer;
import ec.edu.uce.Persistencia.model.Seller;
import ec.edu.uce.Persistencia.model.Sale;
import ec.edu.uce.Persistencia.model.Car;
import ec.edu.uce.Persistencia.service.Impl.CarServiceImpl;
import ec.edu.uce.Persistencia.service.Impl.CustomerServiceImpl;
import ec.edu.uce.Persistencia.service.Impl.SaleServiceImpl;
import ec.edu.uce.Persistencia.service.Impl.SellerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private SellerServiceImpl sellerService;

    @Autowired
    private SaleServiceImpl saleService;

    @Autowired
    private CarServiceImpl carService;

    public void crearCliente(Scanner scanner) {
        System.out.println("Nombre del Cliente:");
        String nombreCliente = scanner.nextLine();
        System.out.println("Calle de la dirección:");
        String calle = scanner.nextLine();
        System.out.println("Ciudad de la dirección:");
        String ciudad = scanner.nextLine();
        Address direccion = new Address(calle, ciudad);
        Customer cliente = new Customer(nombreCliente, direccion);

        customerService.saveCustomer(cliente);
        System.out.println("Cliente creado con éxito!");
    }

    public void leerCliente(Scanner scanner) {
        System.out.println("ID del Cliente:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Customer cliente = customerService.getCustomerById(id);
        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void actualizarCliente(Scanner scanner) {
        System.out.println("ID del Cliente:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Customer cliente = customerService.getCustomerById(id);
        if (cliente != null) {
            System.out.println("Nuevo nombre del Cliente:");
            String nombreCliente = scanner.nextLine();
            System.out.println("Nueva calle de la dirección:");
            String calle = scanner.nextLine();
            System.out.println("Nueva ciudad de la dirección:");
            String ciudad = scanner.nextLine();
            Address direccion = cliente.getAddress();
            direccion.setStreet(calle);
            direccion.setCity(ciudad);
            cliente.setName(nombreCliente);
            cliente.setAddress(direccion);

            customerService.saveCustomer(cliente);
            System.out.println("Cliente actualizado con éxito!");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void eliminarCliente(Scanner scanner) {
        System.out.println("ID del Cliente:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        customerService.deleteCustomer(id);
        System.out.println("Cliente eliminado con éxito!");
    }

    public void crearVendedor(Scanner scanner) {
        System.out.println("Nombre del Vendedor:");
        String nombreVendedor = scanner.nextLine();
        Seller vendedor = new Seller(nombreVendedor);
        sellerService.saveSeller(vendedor);
        System.out.println("Vendedor creado con éxito!");
    }

    public void leerVendedor(Scanner scanner) {
        System.out.println("ID del Vendedor:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Seller vendedor = sellerService.getSellerById(id);
        if (vendedor != null) {
            System.out.println(vendedor);
        } else {
            System.out.println("Vendedor no encontrado.");
        }
    }

    public void actualizarVendedor(Scanner scanner) {
        System.out.println("ID del Vendedor:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Seller vendedor = sellerService.getSellerById(id);
        if (vendedor != null) {
            System.out.println("Nuevo nombre del Vendedor:");
            String nombreVendedor = scanner.nextLine();
            vendedor.setName(nombreVendedor);
            sellerService.saveSeller(vendedor);
            System.out.println("Vendedor actualizado con éxito!");
        } else {
            System.out.println("Vendedor no encontrado.");
        }
    }

    public void eliminarVendedor(Scanner scanner) {
        System.out.println("ID del Vendedor:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        sellerService.deleteSeller(id);
        System.out.println("Vendedor eliminado con éxito!");
    }

    public void crearVenta(Scanner scanner) {
        System.out.println("ID del Vendedor:");
        Long vendedorId = scanner.nextLong();
        scanner.nextLine();
        Seller vendedor = sellerService.getSellerById(vendedorId);

        System.out.println("ID del Cliente:");
        Long clienteId = scanner.nextLong();
        scanner.nextLine();
        Customer cliente = customerService.getCustomerById(clienteId);

        if (vendedor != null && cliente != null) {
            Sale venta = new Sale(new java.util.Date(), vendedor, cliente);
            saleService.saveSale(venta);
            System.out.println("Venta creada con éxito!");
        } else {
            System.out.println("Vendedor o Cliente no encontrados.");
        }
    }

    public void leerVenta(Scanner scanner) {
        System.out.println("ID de la Venta:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Sale venta = saleService.getSaleById(id);
        if (venta != null) {
            System.out.println(venta);
        } else {
            System.out.println("Venta no encontrada.");
        }
    }

    public void actualizarVenta(Scanner scanner) {
        System.out.println("ID de la Venta:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Sale venta = saleService.getSaleById(id);
        if (venta != null) {
            System.out.println("Nueva fecha de la Venta (yyyy-MM-dd):");
            String fecha = scanner.nextLine();
            System.out.println("ID del nuevo Vendedor:");
            Long vendedorId = scanner.nextLong();
            scanner.nextLine();
            Seller vendedor = sellerService.getSellerById(vendedorId);

            System.out.println("ID del nuevo Cliente:");
            Long clienteId = scanner.nextLong();
            scanner.nextLine();
            Customer cliente = customerService.getCustomerById(clienteId);

            if (vendedor != null && cliente != null) {
                venta.setDate(java.sql.Date.valueOf(fecha));
                venta.setSeller(vendedor);
                venta.setCustomer(cliente);
                saleService.saveSale(venta);
                System.out.println("Venta actualizada con éxito!");
            } else {
                System.out.println("Vendedor o Cliente no encontrados.");
            }
        } else {
            System.out.println("Venta no encontrada.");
        }
    }

    public void eliminarVenta(Scanner scanner) {
        System.out.println("ID de la Venta:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        saleService.deleteSale(id);
        System.out.println("Venta eliminada con éxito!");
    }

    public void crearAuto(Scanner scanner) {
        System.out.println("Marca del Auto:");
        String marca = scanner.nextLine();
        System.out.println("Modelo del Auto:");
        String modelo = scanner.nextLine();
        Car auto = new Car(marca, modelo);
        carService.saveCar(auto);
        System.out.println("Auto creado con éxito!");
    }

    public void leerAuto(Scanner scanner) {
        System.out.println("ID del Auto:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Car auto = carService.getCarById(id);
        if (auto != null) {
            System.out.println(auto);
        } else {
            System.out.println("Auto no encontrado.");
        }
    }

    public void actualizarAuto(Scanner scanner) {
        System.out.println("ID del Auto:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Car auto = carService.getCarById(id);
        if (auto != null) {
            System.out.println("Nueva marca del Auto:");
            String marca = scanner.nextLine();
            System.out.println("Nuevo modelo del Auto:");
            String modelo = scanner.nextLine();
            auto.setModel(modelo);
            auto.setBrand(marca);
            carService.saveCar(auto);
            System.out.println("Auto actualizado con éxito!");
        } else {
            System.out.println("Auto no encontrado.");
        }
    }

    public void eliminarAuto(Scanner scanner) {
        System.out.println("ID del Auto:");
        Long id = scanner.nextLong();
        scanner.nextLine();
        carService.deleteCar(id);
        System.out.println("Auto eliminado con éxito!");
    }
}
