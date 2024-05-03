package ru.itis.dis205.lab2_12.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.dis205.lab2_12.web.model.User;
import ru.itis.dis205.lab2_12.web.model.transport.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
