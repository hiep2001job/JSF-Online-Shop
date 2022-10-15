/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.controllers;

import com.entities.Products;
import com.sessionbeans.ProductsFacadeLocal;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author thanh
 */
@Named(value = "homeShowProductDetail")
@RequestScoped
public class HomeShowProductDetail {

    @EJB
    private ProductsFacadeLocal productsFacade;

    private Products product = new Products();

    /**
     * Creates a new instance of HomeShowProductDetail
     */
    public HomeShowProductDetail() {

    }

    @PostConstruct
    public void showProductDetail() {
        
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                    .getRequest();

            String id = request.getParameter("productID");
            int productID = Integer.valueOf(id);
            product = productsFacade.find(productID);

        } catch (Exception e) {
            System.out.println("errrrr");

        }

    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

}
