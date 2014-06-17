package com.br.me.business;

import com.br.me.model.factory.Factory;
import com.br.me.model.persistence.Dao;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author wes
 * @param <T>
 * @param <DAO>
 */
public class Bo<T extends Serializable, DAO extends Dao> {

    private final Dao daoInstance;

    /**
     * Use IoC in constructor and create a new daoInstance to use
     *
     * @param entityManager
     * @param persistentClass
     */
    public Bo(EntityManager entityManager, Class<T> persistentClass) {
        daoInstance = Factory.getDaoInstace(entityManager, persistentClass);
    }

    /**
     * Insert a new instance of T
     *
     * @param t
     * @return the t with new ID
     */
    public T insert(T t) {
        return (T) daoInstance.insert(t);
    }

    /**
     * Update t with new data
     *
     * @param t
     * @return the t updated
     */
    public T update(T t) {
        return (T) daoInstance.update(t);
    }

    /**
     * Delete an Entity Delete T
     *
     * @param t
     */
    public void delete(T t) {
        daoInstance.delete(t);
    }

    /**
     * Get an Entity by primary key
     *
     * @param id
     * @return the Entity
     */
    public T getObjectByID(Long id) {
        return (T) daoInstance.getObjectByID(id);
    }

    /**
     * Get all table of the Entity in a List
     *
     * @return all Entity in a table as List
     */
    public List<T> getAllAsList() {
        return daoInstance.getAllAsList();
    }

    /**
     * Remove a set of Entities
     *
     * @param tAll
     */
    public void removeAll(Collection<T> tAll) {
        daoInstance.deleteAll(tAll);
    }
}
