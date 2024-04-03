package ru.itis.dis205.lab2_8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dis205.lab2_8.model.Address;
import ru.itis.dis205.lab2_8.repository.AddressRepository;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    public List<Address> findAddressByName(String name, Integer page) {
        return addressRepository.findAddressByName(name, page);
    }
}
