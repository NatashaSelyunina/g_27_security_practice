package de.aittr.g_27_security_practice.controllers;

import de.aittr.g_27_security_practice.domain.Car;
import de.aittr.g_27_security_practice.services.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    // всем пользователям
    @GetMapping("/all")
    public List<Car> getAll() {
        return service.getAll();
    }

    // только для зарегистрированных
    @GetMapping("/by_id/{id}")
    public Car getById(@PathVariable int id) {
        return service.getById(id);
    }

    // только для админов
    @PostMapping("/save")
    public Car save(@RequestBody Car car) {
        return service.save(car);
    }
}