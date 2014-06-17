/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.me.model.persistence;

/**
 * Used for Entities with compost primary key, or specifics types of PK
 * @author Wes
 * @param <T>
 * @param <PK>
 */
public interface DaoPk<T,PK> {
    
    public T getObjectByID(PK id);
}
