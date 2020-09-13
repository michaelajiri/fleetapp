package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.Country;
import com.infotech.fleetapp.model.Location;
import com.infotech.fleetapp.service.CountryService;
import com.infotech.fleetapp.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {

    private final LocationService locationService;
    private final CountryService countryService;

    @Autowired
    public LocationController(LocationService locationService,
                              CountryService countryService) {
        this.locationService = locationService;
        this.countryService = countryService;
    }

    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public String locationPage(Model model){
        List<Location> listOfLocations = locationService.getAllLocations();
        model.addAttribute("listOfLocations", listOfLocations);
        List<Country> listOfCountries = countryService.getAllCountries();
        model.addAttribute("listOfCountries", listOfCountries);
        return "location";
    }

    @ResponseBody
    @RequestMapping(value = "/oneLocation", method = RequestMethod.GET)
    public Optional<Location> getLocationById(Integer id, Model model){
        return locationService.getLocationById(id);
    }

    @RequestMapping(value = "/addNewLocation", method = RequestMethod.POST)
    public String addNewLocation(Location location){
        locationService.addNewLocation(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/editLocation", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String updateLocation(Location location){
        locationService.updateLocation(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/deleteLocation", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String removeLocation(Integer id){
        locationService.removeLocation(id);
        return "redirect:/locations";
    }
}