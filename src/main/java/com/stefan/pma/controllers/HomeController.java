package com.stefan.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stefan.pma.dto.EmployeeProject;
import com.stefan.pma.dto.ChartData;
import com.stefan.pma.entities.Project;
import com.stefan.pma.repository.EmployeeRepository;
import com.stefan.pma.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Value("${version}")
    private String ver;

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/")
    public String showProjects(Model model) throws JsonProcessingException {
        model.addAttribute("versionNumber", ver);

        List<Project> projectsList = proRepo.findAll();
        model.addAttribute("projectsList", projectsList);

        List<ChartData> projectData = proRepo.getProjectStatus();
        //convert projectData into json to use in javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
        model.addAttribute("projectStatusCnt", jsonString);

        List<EmployeeProject> employeesProjectsCnt = empRepo.employeeProjects();
        model.addAttribute("employeesProjectsCnt", employeesProjectsCnt);

        return "main/home";
    }
}
