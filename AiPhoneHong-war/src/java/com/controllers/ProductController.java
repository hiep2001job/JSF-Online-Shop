/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.controllers;

import com.entities.Categories;
import com.entities.Products;
import com.sessionbeans.CategoriesFacadeLocal;
import com.sessionbeans.ProductsFacadeLocal;
import com.ultilities.StringHandler;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


/**
 *
 * @author thanh
 */
@Named(value = "productCtrler")
@RequestScoped
public class ProductController {

    @EJB
    private ProductsFacadeLocal productsFacade;

    @EJB
    private CategoriesFacadeLocal categoriesFacade;

//message
    private String message;
//create
    private Products product = new Products();
    private int categoryID;

//edit
    private Products selectedEditProducts=new Products();
    private int selectedEditCategory=0;
//list
    private List<Products> productList;
    private String filterName = "";

    public ProductController() {
    }

    public List<Products> showProducts() {
        if (productList == null) {
            productList = productsFacade.findAll();
        }
        return productList;
    }

    public void applySearch() {
        productList = productsFacade.searchByName(filterName);
    }

    public void createProduct() {
        product.setAlias(StringHandler.toSlug(product.getName()));
        product.setCatID(categoriesFacade.find(categoryID));
        productsFacade.create(product);
        product=new Products();
        message = "Create product successfully!";

    }

    public String edit(int id) {
        selectedEditProducts = productsFacade.find(id);
        if (selectedEditProducts == null) {
            return "product";
        }
        selectedEditCategory = selectedEditProducts.getCatID().getId();

        return "productEdit";
    }

    public void saveEditProduct() {
        System.out.println(selectedEditProducts.getId());
        selectedEditProducts.setCatID(categoriesFacade.find(selectedEditCategory));
        selectedEditProducts.setAlias(StringHandler.toSlug(selectedEditProducts.getName()));
        productsFacade.edit(selectedEditProducts);
        message="Edit product successfully";
    }

    public void deleteProduct(int id) {
        Products product=productsFacade.find(id);
        if(product!=null){
            productsFacade.remove(product);
        }
    }

    public List<Categories> showCategories() {
        return categoriesFacade.findByPublished(Boolean.TRUE);
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public Products getSelectedEditProducts() {
        return selectedEditProducts;
    }

    public void setSelectedEditProducts(Products selectedEditProducts) {
        this.selectedEditProducts = selectedEditProducts;
    }

    public int getSelectedEditCategory() {
        return selectedEditCategory;
    }

    public void setSelectedEditCategory(int selectedEditCategory) {
        this.selectedEditCategory = selectedEditCategory;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Products> getProductList() {
        return productList;
    }

    public void setProductList(List<Products> productList) {
        this.productList = productList;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

}
