package com.codeIt.pmtool.services;

import com.codeIt.pmtool.model.Project;
import com.codeIt.pmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project){
        return projectRepository.save(project);
    }
}
