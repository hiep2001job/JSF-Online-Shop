/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sessionbeans;

import com.entities.Categories;
import com.entities.Categories_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author thanh
 */
@Stateless
public class CategoriesFacade extends AbstractFacade<Categories> implements CategoriesFacadeLocal {

    @PersistenceContext(unitName = "AiPhoneHong-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriesFacade() {
        super(Categories.class);
    }

    @Override
    public boolean checkUniqueCategoryAlias(String alias) {
        CriteriaBuilder cqbuilder = em.getCriteriaBuilder();
        CriteriaQuery query = cqbuilder.createQuery();
        Root root = query.from(Categories.class);
        query.select(root.get(Categories_.alias));
        query.where(cqbuilder.equal(root.get(Categories_.alias), alias.trim()));
        return em.createQuery(query).getResultList().isEmpty();
    }

    @Override
    public List<Categories> findByPublished(Boolean published) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Categories> cquery = cb.createQuery(Categories.class);
        Root root = cquery.from(Categories.class);
        cquery.where(
                cb.equal(
                        root.get(Categories_.published), published
                )
        );
        Query query = em.createQuery(cquery);
        return query.getResultList();
    }

    @Override
    public List<Categories> findByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Categories> cquery = cb.createQuery(Categories.class);
        Root root = cquery.from(Categories.class);
        Predicate pd = cb.like(
                root.get(Categories_.name), "%"+name+"%"
        );
        cquery.where(pd);
        Query query=em.createQuery(cquery);
        return query.getResultList();
    }

}
