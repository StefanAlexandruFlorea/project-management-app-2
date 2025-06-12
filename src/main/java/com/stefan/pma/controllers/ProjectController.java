package com.stefan.pma.controllers;


import com.stefan.pma.entities.Employee;
import com.stefan.pma.entities.Project;
import com.stefan.pma.dao.EmployeeRepository;
import com.stefan.pma.dao.ProjectRepository;
import com.stefan.pma.services.EmployeeService;
import com.stefan.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String displayProjects(Model model){
        List<Project> projects = projectService.getAll();
        model.addAttribute("projectsList", projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject = new Project();
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model){
        projectService.save(project);
        return "redirect:/projects";
    }
}
