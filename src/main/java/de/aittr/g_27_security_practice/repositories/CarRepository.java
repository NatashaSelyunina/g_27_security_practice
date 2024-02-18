package de.aittr.g_27_security_practice.repositories;

import de.aittr.g_27_security_practice.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}