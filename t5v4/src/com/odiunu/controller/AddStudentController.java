package com.odiunu.controller;

import com.google.common.collect.Lists;
import com.odiunu.back.exceptions.EntityExistsException;
import com.odiunu.back.services.StudentService;
import com.odiunu.models.Project;
import com.odiunu.models.Student;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * @author : Robert (ojoc@optymyze.com)
 */
@Stateless
@Path("as")
public class AddStudentController {

    @EJB
    private StudentService studentService;

    @GET
    @Produces("text/plain")
    public String getMain() {
        return "Protocol : ?studentName=\"Name\"";
    }

    @PUT
    @Path("{studentName}")
    public Response addStudentWithName(@PathParam("studentName") String studentName) {
        try {
            studentService.addStudent(new Student(studentName, Lists.<Project>newArrayList()));
        } catch (EntityExistsException e) {
            return Response.serverError().build();
        }
        return Response.ok().build();
    }
}
