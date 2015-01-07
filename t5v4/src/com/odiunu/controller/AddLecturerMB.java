package com.odiunu.controller;

import com.odiunu.back.services.LecturerService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @author : Robert (ojoc@optymyze.com)
 */
@Stateless
public class AddLecturerMB implements MBWithMessage {
    @EJB
    private LecturerService lecturerService;

    public void addLecturer(String lecturerName) {
        lecturerService.addLecturer(lecturerName);

    }

    public void setLecturerService(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }
}
