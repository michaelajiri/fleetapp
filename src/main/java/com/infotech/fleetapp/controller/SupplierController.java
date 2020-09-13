package com.infotech.fleetapp.controller;

import com.infotech.fleetapp.model.Country;
import com.infotech.fleetapp.model.Supplier;
import com.infotech.fleetapp.service.CountryService;
import com.infotech.fleetapp.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class SupplierController {

    private final SupplierService supplierService;
    private final CountryService countryService;

    @Autowired
    public SupplierController(SupplierService supplierService, CountryService countryService) {
        this.supplierService = supplierService;
        this.countryService = countryService;
    }

    @RequestMapping(value = "/suppliers", method = RequestMethod.GET)
    public String supplierPage(Model model) {
        List<Supplier> listOfSuppliers = supplierService.getAllSuppliers();
        model.addAttribute("listOfSuppliers", listOfSuppliers);
        List<Country> listOfCountries = countryService.getAllCountries();
        model.addAttribute("listOfCountries", listOfCountries);
        return "supplier";
    }

    @ResponseBody
    @RequestMapping(value = "/oneSupplier", method = RequestMethod.GET)
    public Optional<Supplier> getSupplierById(Integer id, Model model) {
        return supplierService.getSupplierById(id);
    }

    @RequestMapping(value = "/addNewSupplier", method = RequestMethod.POST)
    public String addNewSupplier(Supplier supplier) {
        supplierService.addNewSupplier(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "/editSupplier", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    public String updateSupplier(Supplier supplier) {
        supplierService.updateSupplier(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "/deleteSupplier", method = {RequestMethod.GET, RequestMethod.DELETE})
    public String removeSupplier(Integer id) {
        supplierService.removeSupplier(id);
        return "redirect:/suppliers";
    }
}
