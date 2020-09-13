package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.Client;
import com.infotech.fleetapp.model.Country;
import com.infotech.fleetapp.service.ClientService;
import com.infotech.fleetapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    private final ClientService clientService;
    private final CountryService countryService;

    @Autowired
    public ClientController(ClientService clientService, CountryService countryService) {
        this.clientService = clientService;
        this.countryService = countryService;
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String clientPage(Model model) {
        List<Client> listOfClients = clientService.getAllClients();
        model.addAttribute("listOfClients", listOfClients);
        List<Country> listOfCountries = countryService.getAllCountries();
        model.addAttribute("listOfCountries", listOfCountries);
        return "client";
    }

    @ResponseBody
    @RequestMapping(value = "/oneClient", method = RequestMethod.GET)
    public Optional<Client> getClientById(Integer id){
        return clientService.getClientById(id);
    }

    @RequestMapping(value = "/addNewClient", method = RequestMethod.POST)
    public String addNewClient(Client client){
        clientService.addNewClient(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/editClient", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String updateClient(Client client){
        clientService.updateClient(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "/deleteClient", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String removeClient(Integer id){
        clientService.removeClient(id);
        return "redirect:/clients";
    }
}
