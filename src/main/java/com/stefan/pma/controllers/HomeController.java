package com.stefan.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stefan.pma.dto.EmployeeProject;
import com.stefan.pma.dto.ChartData;
import com.stefan.pma.entities.Project;
import com.stefan.pma.dao.EmployeeRepository;
import com.stefan.pma.dao.ProjectRepository;
import com.stefan.pma.services.EmployeeService;
import com.stefan.pma.services.ProjectService;
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
    ProjectService projectService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public String showProjects(Model model) throws JsonProcessingException {
        model.addAttribute("versionNumber", ver);

        List<Project> projectsList = projectService.getAll();
        model.addAttribute("projectsList", projectsList);

        List<ChartData> projectData = projectService.getProjectStatus();
        //convert projectData into json to use in javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
        model.addAttribute("projectStatusCnt", jsonString);

        List<EmployeeProject> employeesProjectsCnt = employeeService.employeeProjects();
        model.addAttribute("employeesProjectsCnt", employeesProjectsCnt);

        return "main/home";
    }
}
