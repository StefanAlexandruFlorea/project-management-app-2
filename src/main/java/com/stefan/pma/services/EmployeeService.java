package com.stefan.pma.services;

import com.stefan.pma.dao.EmployeeRepository;
import com.stefan.pma.dto.EmployeeProject;
import com.stefan.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository empRepo;

    public Employee save(Employee employee){
        return empRepo.save(employee);
    }

    public List<Employee> getAll(){
        return empRepo.findAll();
    }

    public List<EmployeeProject> employeeProjects(){
        return empRepo.employeeProjects();
    }


}
