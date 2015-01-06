package com.odiunu.controller;

import com.google.common.collect.Lists;
import com.odiunu.back.exceptions.EntityExistsException;
import com.odiunu.back.services.StudentService;
import com.odiunu.models.Project;
import com.odiunu.models.Student;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author : Robert (ojoc@optymyze.com)
 */
@ManagedBean
@ViewScoped
public class AddStudentMB {

    @EJB
    private StudentService studentService;

    public AddStudentMB() {
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent() throws EntityExistsException {
        if (name != null) {
            studentService.addStudent(new Student(name, Lists.<Project>newArrayList()));
        }
    }
}
