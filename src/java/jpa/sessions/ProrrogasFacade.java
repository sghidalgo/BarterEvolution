/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Prorrogas;

/**
 *
 * @author Cristian Delgadillo
 */
@Stateless
public class ProrrogasFacade extends AbstractFacade<Prorrogas> {

    @PersistenceContext(unitName = "BarterEvolutionFinalPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProrrogasFacade() {
        super(Prorrogas.class);
    }
    
}
