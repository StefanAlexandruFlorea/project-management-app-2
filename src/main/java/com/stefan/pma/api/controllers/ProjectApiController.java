package com.stefan.pma.api.controllers;

import com.stefan.pma.dao.ProjectRepository;
import com.stefan.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app-api/projects")
public class ProjectApiController {

    @Autowired
    ProjectRepository proRepo;

    @GetMapping
    public List<Project> getProjects() {
        return proRepo.findAll();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable("id") Long id) {
        return proRepo.findById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(@RequestBody Project project) {
        return proRepo.save(project);
    }

    @PutMapping
    public Project updateProject(@RequestBody Project project) {
        return proRepo.save(project);
    }

    @PatchMapping("/{id}")
    public Project partialUpdate(@PathVariable("id") Long id, @RequestBody Project patchedProject){
        Project pro = proRepo.findById(id).get();

        if(patchedProject.getName() != null){
            pro.setName(patchedProject.getName());
        }
        if(patchedProject.getDescription() != null){
            pro.setDescription(patchedProject.getDescription());
        }
        if(patchedProject.getStage() != null){
            pro.setStage(patchedProject.getStage());
        }

        return proRepo.save(pro);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProjectById(@PathVariable("id") Long id){
        proRepo.deleteById(id);
    }


}
