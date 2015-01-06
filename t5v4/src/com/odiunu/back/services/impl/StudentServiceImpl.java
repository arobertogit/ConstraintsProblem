package com.odiunu.back.services.impl;

import com.odiunu.back.exceptions.EntityExistsException;
import com.odiunu.back.exceptions.EntityNotFoundException;
import com.odiunu.back.services.StudentService;
import com.odiunu.models.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author : Robert (ojoc@optymyze.com)
 */
@Stateless
public class StudentServiceImpl implements StudentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String getStudentNames() {
//        entityManager.persist(new Student("John Doe", Lists.<Project>newArrayList()));
//        addStudent(new Student("123", Lists.<Project>newArrayList()));

        return ((Student) entityManager.createQuery("SELECT s FROM Student s").getResultList().get(0)).getName();
    }

    @Override
    public Student getStudent(String name) throws EntityNotFoundException {

        List result = entityManager.createQuery("SELECT s FROM Student s WHERE s.name = :name").setParameter("name", name).getResultList();
        if (result.size() > 0) {
            return (Student) result.get(0);
        } else {
            throw new EntityNotFoundException("Student: name: " + name);
        }
    }

    private boolean studentExists(String name) {
        return entityManager.createQuery("SELECT s FROM Student s WHERE s.name = :name").setParameter("name", name).getResultList().size() > 0;
    }

    @Override
    public void addStudent(Student student) throws EntityExistsException {
        if (student.getId() == null && !studentExists(student.getName())) {
            entityManager.persist(student);
        } else {
            throw new EntityExistsException("Student: name: " + student.getName());
        }

    }
}
