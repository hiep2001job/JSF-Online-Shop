/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sessionbeans;

import com.entities.Customers;
import com.entities.Customers_;
import com.entities.Orders;
import com.entities.Orders_;
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
public class OrdersFacade extends AbstractFacade<Orders> implements OrdersFacadeLocal {

    @PersistenceContext(unitName = "AiPhoneHong-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdersFacade() {
        super(Orders.class);
    }

    @Override
    public List<Orders> findByCustomer(String name) {
         CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cquery = cb.createQuery();
        Root root = cquery.from(Orders.class);
        cquery.where(cb.like(root.get(Orders_.customerID.getName()), "%"+name+"%"));
        cquery.orderBy(cb.desc(root.get(Orders_.id)));
        Query query = em.createQuery(cquery);
        return query.getResultList();
    }

    @Override
    public List<Orders> findAllDescDate() {
         CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cquery = cb.createQuery();
        Root root = cquery.from(Orders.class);
        
        cquery.orderBy(cb.desc(root.get(Orders_.id)));
        Query query = em.createQuery(cquery);
        return query.getResultList();
    }
    
}
