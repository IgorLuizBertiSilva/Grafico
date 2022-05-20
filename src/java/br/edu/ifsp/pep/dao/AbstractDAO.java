/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.pep.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author aluno
 */
public abstract class AbstractDAO<T> {

    @PersistenceUnit(unitName = "")
    private EntityManager em;

    public void create(T entity) {

        em.persist(entity);

    }

    public void remove(T entity) {

        em.remove(em.merge(entity));

    }

    public void edit(T entity) {

        em.merge(entity);

    }

}
