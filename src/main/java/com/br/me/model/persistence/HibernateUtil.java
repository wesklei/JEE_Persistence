/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.me.model.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * A Factory to create connection with Persistence Unit
 * @author Wes
 */
public class HibernateUtil {

    private static final EntityManagerFactory entityManagerFactory;

    /**
     *  initialize a new connection
     */
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("mePU");
    }

    /**
     * Return the EntityManager to use in project
     * @return a new EntityManager every time
     */
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

}
