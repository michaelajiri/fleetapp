package com.infotech.fleetapp.service;

import com.infotech.fleetapp.model.Country;
import com.infotech.fleetapp.repo.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    public void addNewCountry(Country country) {
        countryRepository.save(country);
    }

    public void updateCountry(Country country) {
        countryRepository.save(country);
    }

    public Optional<Country> getCountryById(Integer id) {
        return countryRepository.findById(id);
    }

    public void removeCountry(Integer id) {
        countryRepository.deleteById(id);
    }
}
