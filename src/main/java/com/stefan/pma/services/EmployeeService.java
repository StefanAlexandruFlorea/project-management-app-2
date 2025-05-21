package com.stefan.pma.services;

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
