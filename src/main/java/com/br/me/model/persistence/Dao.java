/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.me.model.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 * A generic Dao to reduced amount of unnecessary code
 *
 * @author Wes
 * @param <T> Entity
 */
public class Dao<T extends Serializable> {

    private final Logger logger = Logger.getLogger(Dao.class);
    
    private Class persistentClass;
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    /**
     * Use IoC in constructor
     *
     * @param entityManager
     * @param persistentClass
     */
    public Dao(EntityManager entityManager, Class<T> persistentClass) {
        this.entityManager = entityManager;
        this.persistentClass = persistentClass;
    }

    /**
     * Start transaction in hibernate way
     */
    private void beginTransaction() {
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
    }

    /**
     * End transaction in hibernate way
     */
    private void endTrasaction() {
        try {
            entityTransaction.commit();
        } catch (RuntimeException rx) {
            logger.error("Couldn’t performe this operacion, tring a rollback", rx);
            try {
                //try a roollback
                entityTransaction.rollback();
                logger.info("A rollback was performed");
            } catch (RuntimeException rbe) {
                logger.error("Couldn’t roll back transaction", rbe);
            }
        }

    }

    /**
     * Insert a new instance of T
     *
     * @param t
     * @return the t with new ID
     */
    public T insert(T t) {

        beginTransaction();
        entityManager.persist(t);
        endTrasaction();
        return t;
    }

    /**
     * Update t with new data
     *
     * @param t
     * @return the t updated
     */
    public T update(T t) {

        beginTransaction();
        entityManager.merge(t);
        endTrasaction();
        return t;
    }

    /**
     * Delete an Entity Delete T
     *
     * @param t
     */
    public void delete(T t) {

        beginTransaction();
        entityManager.remove(t);
        endTrasaction();
    }

    /**
     * Get an Entity by primary key
     *
     * @param id
     * @return the Entity
     */
    public T getObjectByID(Long id) {
        return (T) entityManager.find(persistentClass, id);
    }

    /**
     * Get all table of the Entity in a List
     *
     * @return all Entity in a table as List
     */
    public List<T> getAllAsList() {

        beginTransaction();
        Query query = entityManager.createQuery("from " + persistentClass.getName());
        List<T> allAsList = query.getResultList();
        endTrasaction();
        return allAsList;
    }

    /**
     * Remove a set of Entities
     *
     * @param tAll
     */
    public void deleteAll(Collection<T> tAll) {

        beginTransaction();
        for (T t : tAll) {
            entityManager.remove(t);
        }
        endTrasaction();
    }

    public EntityTransaction getEntityTransaction() {
        return entityTransaction;
    }

    public void setEntityTransaction(EntityTransaction entityTransaction) {
        this.entityTransaction = entityTransaction;
    }

    public Class getPersistentClass() {
        return persistentClass;
    }

    public void setPersistentClass(Class persistentClass) {
        this.persistentClass = persistentClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
