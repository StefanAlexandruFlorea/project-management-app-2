package com.stefan.pma.repository;

import com.stefan.pma.dto.ChartData;
import com.stefan.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
    @Override
    public List<Project> findAll();

    @Query(nativeQuery=true, value="select stage as label, count(*) as \"value\" from project group by stage order by 2 desc;")
    public List<ChartData> getProjectStatus();
}
