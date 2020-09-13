package com.infotech.fleetapp.service;

import com.infotech.fleetapp.model.EmployeeType;
import com.infotech.fleetapp.repo.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {

    private final EmployeeTypeRepository employeeTypeRepository;

    @Autowired
    public EmployeeTypeService(EmployeeTypeRepository employeeTypeRepository) {
        this.employeeTypeRepository = employeeTypeRepository;
    }

    public List<EmployeeType> getAllEmployeeTypes() {
        return employeeTypeRepository.findAll();
    }

    public Optional<EmployeeType> getEmployeeTypeById(Integer id) {
        return employeeTypeRepository.findById(id);
    }

    public void addNewEmployeeType(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

    public void updateEmployeeType(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

    public void removeEmployeeType(Integer id) {
        employeeTypeRepository.deleteById(id);
    }
}
