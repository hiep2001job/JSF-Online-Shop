/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sessionbeans;

import com.entities.Customers;
import com.entities.Customers_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author thanh
 */
@Stateless
public class CustomersFacade extends AbstractFacade<Customers> implements CustomersFacadeLocal {

    @PersistenceContext(unitName = "AiPhoneHong-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Boolean checkUniqueCustomerEmail(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cquery = cb.createQuery();
        Root root = cquery.from(Customers.class);
        cquery.where(cb.equal(root.get(Customers_.email), email));
        Query query = em.createQuery(cquery);
        return query.getResultList().isEmpty();
    }

    @Override
    public Customers login(String email, String pass) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cquery = cb.createQuery();
        Root root = cquery.from(Customers.class);
        cquery.where(
                cb.and(
                        cb.equal(root.get(Customers_.email).as(String.class), email),
                        cb.equal(root.get(Customers_.password).as(String.class), pass)
                )
        );
        Query query = em.createQuery(cquery);
        List<Customers> resultList = query.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        return resultList.get(0);
    }

    public CustomersFacade() {
        super(Customers.class);
    }

    @Override
    public List<Customers> findAllDesc() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cquery = cb.createQuery();
        Root root = cquery.from(Customers.class);
        cquery.orderBy(cb.desc(root.get(Customers_.id)));
        Query query = em.createQuery(cquery);
        List<Customers> resultList = query.getResultList();

        return resultList;
    }

    @Override
    public List<Customers> findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cquery = cb.createQuery();
        Root root = cquery.from(Customers.class);
        cquery.where(cb.like(root.get(Customers_.fullname).as(String.class),
                "%" + name + "%"));
        Query query = em.createQuery(cquery);
        List<Customers> resultList = query.getResultList();

        return resultList;
    }

}
