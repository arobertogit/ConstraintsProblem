package com.odiunu.back.services;

import com.odiunu.back.exceptions.EntityExistsException;
import com.odiunu.back.exceptions.EntityNotFoundException;
import com.odiunu.models.Student;

/**
 * @author : Robert (ojoc@optymyze.com)
 */
public interface StudentService {
    String getStudentNames();

    Student getStudent(String name) throws EntityNotFoundException;

    void addStudent(Student student) throws EntityExistsException;

    boolean studentExists(String name);
}
