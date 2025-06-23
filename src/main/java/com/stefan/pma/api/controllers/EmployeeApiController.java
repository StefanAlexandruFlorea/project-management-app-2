package com.stefan.pma.api.controllers;

import com.stefan.pma.dao.EmployeeRepository;
import com.stefan.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping
    public List<Employee> getEmployee(){
        return empRepo.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id){
        return empRepo.findById(id).get();
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee){
        return empRepo.save(employee);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Employee update(@RequestBody Employee employee){
        return empRepo.save(employee);
    }

    @PatchMapping("{id}")
    public Employee partialUpdate(@PathVariable("id") Long id,
                                  @RequestBody Employee patchEmployee){
        Employee emp = empRepo.findById(id).get();

        if(patchEmployee.getFirstName() != null){
            emp.setFirstName(patchEmployee.getFirstName());
        }
        if(patchEmployee.getLastName() != null){
            emp.setLastName(patchEmployee.getLastName());
        }
        if(patchEmployee.getEmail() != null){
            emp.setEmail(patchEmployee.getEmail());
        }

        return empRepo.save(emp);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        empRepo.deleteById(id);
    }



}
