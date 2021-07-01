package com.codeIt.pmtool.controller;

import com.codeIt.pmtool.model.Project;
import com.codeIt.pmtool.services.ProjectService;
import com.codeIt.pmtool.services.ValidationServiceError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ValidationServiceError validationServiceError;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
        //condition 1 (if error msg is not null, return the errorMsg of function from validationServiceError)
        ResponseEntity<?>errorMsg = validationServiceError.ValidationServiceError(result);
        if(errorMsg!=null)
            return errorMsg;
        //condition 2 (else, save or update the project)
        Project project1 = projectService.saveOrUpdate(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }
}
