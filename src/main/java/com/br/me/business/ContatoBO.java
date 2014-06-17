/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.me.business;

import com.br.me.model.Contato;
import com.br.me.model.persistence.ContatoDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author wes
 */
public class ContatoBO extends Bo<Contato,ContatoDAO>{

    public ContatoBO(EntityManager entityManager, Class<Contato> persistentClass) {
        super(entityManager, persistentClass);
    }

    
}
