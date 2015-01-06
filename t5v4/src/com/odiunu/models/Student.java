package com.odiunu.models;

import javax.persistence.*;
import java.util.List;

/**
 * @author : Robert (ojoc@optymyze.com)
 */
@Entity
@Table(name = "STUDENT")
public class Student {
    public Student(String name, List<Project> projectPreference) {
        this.name = name;
        this.projectPreference = projectPreference;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column
    private String name;
    @OneToMany
    private List<Project> projectPreference;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjectPreference() {
        return projectPreference;
    }

    public void setProjectPreference(List<Project> projectPreference) {
        this.projectPreference = projectPreference;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
