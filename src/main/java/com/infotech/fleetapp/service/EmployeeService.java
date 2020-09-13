package com.infotech.fleetapp.service;

import com.infotech.fleetapp.model.Employee;
import com.infotech.fleetapp.model.User;
import com.infotech.fleetapp.repo.EmployeeRepository;
import com.infotech.fleetapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, UserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Integer id){
        return employeeRepository.findById(id);
    }

    public void addNewEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void removeEmployee(Integer id){
        employeeRepository.deleteById(id);
    }

    public Employee findByUsername(String username){
        return employeeRepository.findByUsername(username);
    }

    // Set the username of employee where firstName and lastName match
    public void assignUsername(Integer id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        User user = userRepository.findByFirstNameAndLastName(
                employee.getFirstName(), employee.getLastName());
        employee.setUsername(user.getUsername());
        employeeRepository.save(employee);
    }
}
