package ru.itis.dis205.lab2_12.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dis205.lab2_12.web.dto.UserDto;
import ru.itis.dis205.lab2_12.web.model.transport.Vehicle;
import ru.itis.dis205.lab2_12.web.repositories.UserRepository;
import ru.itis.dis205.lab2_12.web.security.detail.UserDetailsImpl;
import ru.itis.dis205.lab2_12.web.service.VehicleService;

import java.util.List;

@RestController
public class VehicleConroller {

    @Autowired
    private VehicleService vehicleService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin/vehicles")
    public ResponseEntity<List<Vehicle>> findAllVehicle() {
       return ResponseEntity.ok(vehicleService.findAll());
    }

}
