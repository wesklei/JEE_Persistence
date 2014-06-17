package com.br.me.model.persistence;

import com.br.me.model.Contato;
import javax.persistence.EntityManager;

/**
 *
 * @author wes
 */
public class ContatoDAO extends Dao<Contato>{

    public ContatoDAO(EntityManager entityManager, Class persistentClass) {
        super(entityManager, persistentClass);
    }

}