package com.odiunu.back.services.impl;

import com.odiunu.back.services.ProjectService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author : Robert (ojoc@optymyze.com)
 */
@Stateless
public class ProjectServiceImpl implements ProjectService {
    @PersistenceContext
    private EntityManager entityManager;
}
