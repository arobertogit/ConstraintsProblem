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
public class AddStudentMB implements MBWithMessage {

    @EJB
    private StudentService studentService;
    private String message;
    private String name;

    public AddStudentMB() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent() {

        if (name == null || name.trim().isEmpty()) {
            message = "Insert name";
        } else if (studentService.studentExists(name)) {
            message = "Student with name \"" + name + "\" exists";
        } else {
            try {
                studentService.addStudent(new Student(name, Lists.<Project>newArrayList()));
            } catch (EntityExistsException e) {
                message = e.getMessage();
            }
            message = "Student with name \"" + name + "\" was added";
        }
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
