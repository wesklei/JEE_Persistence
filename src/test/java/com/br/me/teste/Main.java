/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.me.teste;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wes
 */
public class Main {

    public static void main(String... args) {
        try {
            /* EntityManager entityManager = HibernateUtil.getEntityManager();
            Bo contatoBO = Factory.getBoInstace(entityManager, Contato.class);
            
            Contato c = new Contato();
            c.setCelular("123");
            c.setEmail("email@mail.com");
            c.setNome("nome contato");
            c.setTelefone("555");
            c.setEndereco("Rua dos testes");
            
            c = (Contato) contatoBO.insert(c);
            
            Contato c2 = (Contato) contatoBO.getObjectByID(c.getId());
            
            System.out.println("c2 tem id => " + c2.getId() + " nome=> " + c2.getNome());
            */
            Calendar c = Calendar.getInstance();
            Date data = c.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String dataformadata= sdf.format(data);
            Date datanova = new Date(sdf.parse(dataformadata).getTime());
            
            System.out.println("Daata = > " + datanova + " // " + dataformadata);
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
