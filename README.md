# ProyectoRelacionesDDBB

# Proyecto de Persistencia en Spring Boot

Este proyecto es una aplicación de ejemplo que gestiona clientes, vendedores, ventas, autos y direcciones utilizando Spring Boot y Spring Data JPA para la persistencia de datos.

## Tecnologías Utilizadas

- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL (o cualquier base de datos relacional)

## Estructura del Proyecto

- **Modelos (Entidades)**: Address, Car, Customer, Sale, Seller.
- **Repositorios**: AddressRepository, CarRepository, CustomerRepository, SaleRepository, SellerRepository.
- **Servicios**: AddressServiceImpl, CarServiceImpl, CustomerServiceImpl, SaleServiceImpl, SellerServiceImpl.
- **Interfaces de Servicios**: IAddressService, ICarService, ICustomerService, ISaleService, ISellerService.
- **Controlador**: CustomerController.
- **Aplicación Principal**: PersistenciaApplication.

## Relaciones entre Entidades

### OneToOne
- **Customer** tiene una relación uno a uno con **Address**.

### OneToMany
- **Seller** tiene una relación uno a muchos con **Sale**.

### ManyToOne
- **Sale** tiene una relación muchos a uno con **Seller** y **Customer**.

### ManyToMany
- **Car** tiene una relación muchos a muchos con **Sale**.

## Funcionalidad

### Gestión de Clientes
- Crear, leer, actualizar y eliminar clientes.

### Gestión de Vendedores
- Crear, leer, actualizar y eliminar vendedores.

### Gestión de Ventas
- Crear, leer, actualizar y eliminar ventas.

### Gestión de Autos
- Crear, leer, actualizar y eliminar autos.

## Ejecución del Proyecto

Para ejecutar el proyecto, se puede utilizar la clase `PersistenciaApplication`, que maneja la interacción del usuario a través de la consola.

```sh
mvn spring-boot:run

