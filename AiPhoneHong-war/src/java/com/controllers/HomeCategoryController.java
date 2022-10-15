/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.controllers;

import com.entities.Products;
import com.sessionbeans.CategoriesFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author thanh
 */
@Named(value = "homeCategoryController")
@RequestScoped
public class HomeCategoryController {

    @EJB
    private CategoriesFacadeLocal categoriesFacade;
    private List<Products> productList = new ArrayList<>();

    /**
     * Creates a new instance of HomeCategoryController
     */
    public HomeCategoryController() {
    }

    public String showProductByCate(int cateID) {
        productList = (List<Products>) categoriesFacade.find(cateID).getProductsCollection();
        return "category";
    }

    public List<Products> getProductList() {
        return productList;
    }

    public void setProductList(List<Products> productList) {
        this.productList = productList;
    }

}
