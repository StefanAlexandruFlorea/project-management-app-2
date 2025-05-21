package com.stefan.pma.dao;

import com.stefan.pma.dto.EmployeeProject;
import com.stefan.pma.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Override
    public List<Employee> findAll();

    @Query(nativeQuery=true, value="select first_name as firstName, last_name as lastName, count(project_id) as projectCount " +
            "from employee e left join project_employee pe on e.employee_id=pe.employee_id " +
            "group by e.employee_id order by 3 desc ;")
    public List<EmployeeProject> employeeProjects();
}
