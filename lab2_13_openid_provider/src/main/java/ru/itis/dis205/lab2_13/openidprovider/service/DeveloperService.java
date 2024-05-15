package ru.itis.dis205.lab2_13.openidprovider.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dis205.lab2_13.openidprovider.model.Developer;
import ru.itis.dis205.lab2_13.openidprovider.repository.DeveloperRepository;

import java.util.Optional;

@Service
public class DeveloperService {

    private DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository userRepository) {
        this.developerRepository = userRepository;
    }

    @Transactional
    public Developer save(Developer developer) {
        return developerRepository.save(developer);
    }

    public Developer findByCallbackurl(String callbackurl) {
        return developerRepository.findByCallbackurl(callbackurl);
    }

    public Optional<Developer> findById(Long id) {
        return developerRepository.findById(id);
    }
}
