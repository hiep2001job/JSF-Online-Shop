/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sessionbeans;

import com.entities.Products;
import com.entities.Products_;
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
public class ProductsFacade extends AbstractFacade<Products> implements ProductsFacadeLocal {

    @PersistenceContext(unitName = "AiPhoneHong-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductsFacade() {
        super(Products.class);
    }

    @Override
    public List<Products> searchByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Products> cquery = cb.createQuery(Products.class);
        Root root = cquery.from(Products.class);
        cquery.where(
                cb.like(
                        root.get(Products_.name).as(String.class), "%"+name+"%"
                )
        );
        Query query = em.createQuery(cquery);
        List<Products> res = query.getResultList();
        
        return res;
    }

    @Override
    public List<Products> findHomeProducts() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Products> cquery = cb.createQuery(Products.class);
        Root root = cquery.from(Products.class);
        cquery.where(
               cb.equal(root.get(Products_.homeFlag).as(Boolean.class), Boolean.TRUE)
        );
        Query query = em.createQuery(cquery);
        List<Products> res = query.getResultList();
        
        return res;
    }

}
