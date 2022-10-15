/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.controllers;

import com.entities.Categories;
import com.entities.Products;
import com.sessionbeans.CategoriesFacadeLocal;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author thanh
 */
@Named(value = "showProductByCart")
@ViewScoped
public class ShowProductByCart implements Serializable {

    @EJB
    private CategoriesFacadeLocal categoriesFacade;
    private ArrayList<Products> productList;

    /**
     * Creates a new instance of ShowProductByCart
     */
    public ShowProductByCart() {
    }

    @PostConstruct
    public void init() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                    .getRequest();

            String id = request.getParameter("id");
            int cartID = Integer.valueOf(id);
            productList = new ArrayList<>(categoriesFacade.find(cartID).getProductsCollection());

        } catch (Exception e) {
            System.out.println("errrrr");

        }
    }

    public ArrayList<Products> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Products> productList) {
        this.productList = productList;
    }
}
