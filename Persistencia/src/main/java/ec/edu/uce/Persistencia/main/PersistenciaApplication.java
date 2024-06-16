package ec.edu.uce.Persistencia.main;

/**
 * @author: Byron Flores
 * @Theme: Anotaciones de relaciones de entidades
 */

import ec.edu.uce.Persistencia.controller.CustomerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = "ec.edu.uce.Persistencia")
@EnableJpaRepositories(basePackages = "ec.edu.uce.Persistencia.repository")
@EntityScan(basePackages = "ec.edu.uce.Persistencia.model")
public class PersistenciaApplication implements CommandLineRunner {

    @Autowired
    private CustomerController customerController;

    public static void main(String[] args) {
        SpringApplication.run(PersistenciaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Leer Cliente");
            System.out.println("3. Actualizar Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("5. Crear Vendedor");
            System.out.println("6. Leer Vendedor");
            System.out.println("7. Actualizar Vendedor");
            System.out.println("8. Eliminar Vendedor");
            System.out.println("9. Crear Venta");
            System.out.println("10. Leer Venta");
            System.out.println("11. Actualizar Venta");
            System.out.println("12. Eliminar Venta");
            System.out.println("13. Crear Auto");
            System.out.println("14. Leer Auto");
            System.out.println("15. Actualizar Auto");
            System.out.println("16. Eliminar Auto");
            System.out.println("0. Salir");

            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    customerController.crearCliente(scanner);
                    break;
                case 2:
                    customerController.leerCliente(scanner);
                    break;
                case 3:
                    customerController.actualizarCliente(scanner);
                    break;
                case 4:
                    customerController.eliminarCliente(scanner);
                    break;
                case 5:
                    customerController.crearVendedor(scanner);
                    break;
                case 6:
                    customerController.leerVendedor(scanner);
                    break;
                case 7:
                    customerController.actualizarVendedor(scanner);
                    break;
                case 8:
                    customerController.eliminarVendedor(scanner);
                    break;
                case 9:
                    customerController.crearVenta(scanner);
                    break;
                case 10:
                    customerController.leerVenta(scanner);
                    break;
                case 11:
                    customerController.actualizarVenta(scanner);
                    break;
                case 12:
                    customerController.eliminarVenta(scanner);
                    break;
                case 13:
                    customerController.crearAuto(scanner);
                    break;
                case 14:
                    customerController.leerAuto(scanner);
                    break;
                case 15:
                    customerController.actualizarAuto(scanner);
                    break;
                case 16:
                    customerController.eliminarAuto(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 0);
        scanner.close();
    }
}
