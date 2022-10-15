/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.controllers;

import com.authentication.UserIdentity;
import com.entities.Categories;
import com.entities.Customers;
import com.entities.Orders;
import com.entities.Products;
import com.entities.Slides;
import com.sessionbeans.CategoriesFacadeLocal;
import com.sessionbeans.CustomersFacadeLocal;
import com.sessionbeans.OrdersFacadeLocal;
import com.sessionbeans.ProductsFacadeLocal;
import com.sessionbeans.SlidesFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;

import javax.inject.Named;

import javax.faces.bean.SessionScoped;

import javax.inject.Inject;

/**
 *
 * @author thanh
 */
@Named(value = "homeMB")
@RequestScoped
public class HomeController {

    @EJB
    private CustomersFacadeLocal customersFacade;

    @EJB
    private OrdersFacadeLocal ordersFacade;

    @EJB
    private SlidesFacadeLocal slidesFacade;

    @EJB
    private ProductsFacadeLocal productsFacade;

    @EJB
    private CategoriesFacadeLocal categoriesFacade;
    

    @Inject
    UserIdentity userIdentity;
    
    private List<Products> searchProductList = new ArrayList<>();
    private List<Products> homeProductList = new ArrayList<>();
    private List<Orders> orderList = new ArrayList();
    private Products productDetail = new Products();
    private String searchName = "";
    private String message = "Hello Test";

    /**
     * Creates a new instance of homeMB
     */
    public HomeController() {

    }

    @PostConstruct
    public void init() {
        homeProductList = productsFacade.findHomeProducts();

    }

    public List<Orders> showAllOrders() {
        Customers customer=customersFacade.find(userIdentity.getCustomer().getId());
        return (List<Orders>) customer.getOrdersCollection();
    }

    public List<Slides> showAllSlides() {
        return slidesFacade.findAll();

    }

    public List<Categories> showAllCategories() {
        return categoriesFacade.findByPublished(Boolean.TRUE);
    }

    public String detailProduct(Integer id) {
        try {
            productDetail = productsFacade.find(id);
            if (productDetail != null) {
                return "productDetail";
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "productDetail";
    }

    public String search() {
        if (!searchName.isEmpty()) {
            searchProductList = productsFacade.searchByName(searchName);
            return "productSearch";
        }
        return "index";
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public List<Products> getSearchProductList() {
        return searchProductList;
    }

    public void setSearchProductList(List<Products> productList) {
        this.searchProductList = productList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Products> getHomeProductList() {
        return homeProductList;
    }

    public void setHomeProductList(List<Products> homeProductList) {
        this.homeProductList = homeProductList;
    }

    public Products getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(Products productDetail) {
        this.productDetail = productDetail;
    }

}
