package com.codeIt.pmtool.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Project Name Required")
    private String projectName;

    @NotBlank(message="Project Identifier Required")
    @Size(min=4, max=5, message="User 4 to 5 characters only")
    @Column(updatable = false, unique = true)
    private String projectIdentifier;

    @NotBlank(message="Description Required")
    private String description;

    @JsonFormat(pattern="yyyy-mm-dd")
    private Date start_At;

    @JsonFormat(pattern="yyyy-mm-dd")
    private Date end_At;

    @JsonFormat(pattern="yyyy-mm-dd")
    private Date created_At;

    @JsonFormat(pattern="yyyy-mm-dd")
    private Date updated_At;

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_At() {
        return start_At;
    }

    public void setStart_At(Date start_At) {
        this.start_At = start_At;
    }

    public Date getEnd_At() {
        return end_At;
    }

    public void setEnd_At(Date end_At) {
        this.end_At = end_At;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }

    @PrePersist
    protected void created_At(){
        this.created_At = new Date();
    }

    @PreUpdate
    protected void updated_At(){
        this.updated_At = new Date();
    }
}
