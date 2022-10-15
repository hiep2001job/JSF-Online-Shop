/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sessionbeans;

import com.entities.Customers;
import com.entities.Slides;
import com.entities.Slides_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author thanh
 */
@Stateless
public class SlidesFacade extends AbstractFacade<Slides> implements SlidesFacadeLocal {

    @PersistenceContext(unitName = "AiPhoneHong-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SlidesFacade() {
        super(Slides.class);
    }

    @Override
    public List<Slides> findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cquery = cb.createQuery();
        Root root = cquery.from(Slides.class);
        cquery.where(cb.like(root.get(Slides_.name).as(String.class), "%"+name+"%"));
        Query query = em.createQuery(cquery);
        List<Slides> resultList = query.getResultList();
        return resultList;
    }

}
