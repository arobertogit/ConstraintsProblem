package com.odiunu.models;

import javax.persistence.*;
import java.util.List;

/**
 * @author : Robert (ojoc@optymyze.com)
 */
@Entity
@Table(name = "LECTURER")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column
    private String name;
    @OneToMany
    private List<Student> studentsPreferences;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentsPreferences() {
        return studentsPreferences;
    }

    public void setStudentsPreferences(List<Student> studentsPreferences) {
        this.studentsPreferences = studentsPreferences;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
