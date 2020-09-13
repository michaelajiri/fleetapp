package com.infotech.fleetapp.repo;

import com.infotech.fleetapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public Employee findByUsername(String username);

}
