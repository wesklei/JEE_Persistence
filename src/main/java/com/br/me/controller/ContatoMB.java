/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.me.controller;

import com.br.me.business.Bo;
import com.br.me.model.Contato;
import com.br.me.model.factory.Factory;
import com.br.me.model.persistence.ContatoDAO;
import com.br.me.model.persistence.HibernateUtil;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author wes
 */
@Named
@RequestScoped
public class ContatoMB {
    private Contato contato;
   // private The

    public ContatoMB(){
        Bo<Contato,ContatoDAO> contatoBo = Factory.getBoInstace(HibernateUtil.getEntityManager(), (Class) Contato.class);
        contato = contatoBo.getObjectByID(1L);
        System.out.println("contato eh=> " + contato.getNome());
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
    
    

}
