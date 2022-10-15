/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sessionbeans;

import com.entities.AttributeDetails;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thanh
 */
@Stateless
public class AttributeDetailsFacade extends AbstractFacade<AttributeDetails> implements AttributeDetailsFacadeLocal {

    @PersistenceContext(unitName = "AiPhoneHong-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AttributeDetailsFacade() {
        super(AttributeDetails.class);
    }
    
}
