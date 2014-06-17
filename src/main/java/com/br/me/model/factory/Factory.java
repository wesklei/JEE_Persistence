/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.me.model.factory;

import com.br.me.business.Bo;
import com.br.me.model.persistence.Dao;
import java.io.Serializable;
import javax.persistence.EntityManager;

/**
 *
 * @author Wes
 */
public class Factory {

    /**
     * Get a correct instance of Bo using generics
     *
     * @param <T> Entity
     * @param <DAO>
     * @param entityManager IoC of entityManager
     * @param persistentClass The Model Class to be used
     * @return a new instance of Bo with the correct construction
     */
    public static <T extends Serializable, DAO extends Dao> Bo getBoInstace(EntityManager entityManager, Class<T> persistentClass) {
        return new Bo<T, DAO>(entityManager, persistentClass);
    }

    /**
     * Get a correct instance of Dao using generics
     *
     * @param <T> Entity
     * @param entityManager IoC of entityManager
     * @param persistentClass The Model Class to be used
     * @return a new instance of Dao with the correct construction
     */
    public static <T extends Serializable> Dao getDaoInstace(EntityManager entityManager, Class<T> persistentClass) {
        return new Dao<T>(entityManager, persistentClass);
    }
}
