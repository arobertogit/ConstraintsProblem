package com.odiunu.back.services.impl;

import com.odiunu.back.services.LecturerService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author : Robert (ojoc@optymyze.com)
 */
@Stateless
public class LecturerServiceImpl implements LecturerService {
    @PersistenceContext
    private EntityManager entityManager;
}
