package com.stefan.pma.controllers;


import com.stefan.pma.entities.Employee;
import com.stefan.pma.entities.Project;
import com.stefan.pma.dao.EmployeeRepository;
import com.stefan.pma.dao.ProjectRepository;
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
    ProjectRepository proRepo;
    @Autowired
    EmployeeRepository empRepo;

    @GetMapping
    public String displayProjects(Model model){
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projectsList", projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject = new Project();
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("project", aProject);
        model.addAttribute("allEmployees", employees);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model){
        proRepo.save(project);
        return "redirect:/projects";
    }
}
