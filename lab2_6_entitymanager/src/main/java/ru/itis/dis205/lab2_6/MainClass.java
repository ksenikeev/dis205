package ru.itis.dis205.lab2_6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.dis205.lab2_6.model.Client;
import ru.itis.dis205.lab2_6.model.Driver;
import ru.itis.dis205.lab2_6.model.Trip;
import ru.itis.dis205.lab2_6.repository.ClientRepository;
import ru.itis.dis205.lab2_6.repository.DriverRepository;
import ru.itis.dis205.lab2_6.repository.TripRepository;

@Component
public class MainClass implements Runnable {

    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run() {
        Driver driver = new Driver();
        driver.setName("Водитель 1");
        driver.setExperience(30);
        //driverRepository.save(driver);

        Client client = new Client();
        client.setName("Клиент 1");
        client.setPhone("1111111");
        //clientRepository.save(client);

        Trip trip = new Trip();
        trip.setDriver(driver);
        trip.setStartPoint("Казань");

        tripRepository.save(trip);
    }
}
