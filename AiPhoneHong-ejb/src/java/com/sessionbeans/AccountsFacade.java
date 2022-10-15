/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sessionbeans;

import com.entities.Accounts;
import com.entities.Accounts_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author thanh
 */
@Stateless
public class AccountsFacade extends AbstractFacade<Accounts> implements AccountsFacadeLocal {

    @PersistenceContext(unitName = "AiPhoneHong-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Accounts login(String email, String pass) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<Accounts> root = cq.from(Accounts.class);
        cq.select(root);
        Predicate pre = cb.and(
                cb.equal(root.get(Accounts_.email), email),
                cb.equal(root.get(Accounts_.password), pass)
        );
        
        cq.where(pre);
        Query query = em.createQuery(cq);
        List<Accounts> resultList = query.getResultList();
        
        if (!resultList.isEmpty()) {
            return resultList.get(0);
        } else {
            return null;
        }

    }

    public AccountsFacade() {
        super(Accounts.class);
    }

}
