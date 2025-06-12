package com.stefan.pma.services;

import com.stefan.pma.dao.ProjectRepository;
import com.stefan.pma.dto.ChartData;
import com.stefan.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository proRepo;

    public Project save(Project project) {
        return proRepo.save(project);
    }

    public List<Project> getAll() {
        return proRepo.findAll();
    }

    public List<ChartData> getProjectStatus(){
        return proRepo.getProjectStatus();
    }
}
