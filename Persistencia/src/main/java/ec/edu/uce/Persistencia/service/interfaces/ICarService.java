package ec.edu.uce.Persistencia.service.interfaces;

import ec.edu.uce.Persistencia.model.Car;

import java.util.List;

public interface ICarService {

    Car saveCar(Car car);

    Car getCarById(Long id);

    List<Car> getAllCars();

    Car updateCar(Long id, Car car);

    void deleteCar(Long id);
}
