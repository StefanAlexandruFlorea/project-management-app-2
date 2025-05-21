package com.stefan.pma.services;

import com.stefan.pma.repository.EmployeeRepository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    //Field dependency injection
//    @Autowired
//    IStaffRepository staffRepo;

    //Constructor injection
//    public EmployeeService(IStaffRepository staffRepo){
//        this.staffRepo=staffRepo;
//    }

    //Setter injection
//    @Autowired
//    public void setEmpRepo(@Qualifier("IStaffRepositoryImpl1") IStaffRepository staffRepo){
//        this.staffRepo=staffRepo;
//    }
}
