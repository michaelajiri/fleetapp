package com.infotech.fleetapp.service;

import com.infotech.fleetapp.model.Location;
import com.infotech.fleetapp.repo.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations() {
        return (List<Location>) locationRepository.findAll();
    }

    public Optional<Location> getLocationById(Integer id) {
        return locationRepository.findById(id);
    }

    public void addNewLocation(Location location) {
        locationRepository.save(location);
    }

    public void updateLocation(Location location) {
        locationRepository.save(location);
    }

    public void removeLocation(Integer id) {
        locationRepository.deleteById(id);
    }
}
