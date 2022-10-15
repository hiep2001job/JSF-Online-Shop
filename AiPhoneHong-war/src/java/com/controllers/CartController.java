/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.controllers;

import com.authentication.UserIdentity;
import com.entities.CartItem;
import com.entities.OrderDetails;
import com.entities.Orders;
import com.entities.Products;
import com.sessionbeans.CustomersFacadeLocal;
import com.sessionbeans.OrderDetailsFacadeLocal;
import com.sessionbeans.OrdersFacadeLocal;
import com.sessionbeans.ProductsFacadeLocal;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

/**
 *
 * @author thanh
 */
@SessionScoped
@ManagedBean(name = "cartCtrler")
public class CartController {

    @EJB
    private OrderDetailsFacadeLocal orderDetailsFacade;

    @EJB
    private CustomersFacadeLocal customersFacade;

    @EJB
    private OrdersFacadeLocal ordersFacade;

    @EJB
    private ProductsFacadeLocal productsFacade;

    @Inject
    UserIdentity userIdentity;

    @Inject
    ToastController toastController;

    //order
    private Orders order = new Orders();

    private List<CartItem> list = new ArrayList<>();

    private String message = "Hello";
    private String searchName = "";
    private List<Products> productList = new ArrayList<>();

    /**
     * Creates a new instance of CartController
     */
    public CartController() {

    }

    public String redirectCheckout() {
        return "checkout?face-redirect=true";
    }

    public List<CartItem> checkedCartItem() {
        return (List<CartItem>) list.stream().filter((t) -> {
            return t.getIsChecked();
        });

    }
    @Transactional
    public void placeOrder() {
        try {
            order.setCustomerID(customersFacade.find(userIdentity.getCustomer().getId()));
            order.setNote("new");
            order.setIsConfirmed(Boolean.FALSE);
            order.setOrderDate(Calendar.getInstance().getTime());
            ordersFacade.create(order);
            int orderTotal=0;
            for (int i = 0; i < list.size(); i++) {
                CartItem item = list.get(i);
                //check if item is checked
                if (item.getIsChecked()) {
                    OrderDetails orderDetails = new OrderDetails();
                    orderDetails.setProductID(productsFacade.find(item.getProduct().getId()));
                    orderDetails.setQuantity(item.getQuantity());
                    orderDetails.setPrice(item.getProduct().getPrice());
                    orderDetails.setTotal(item.getProduct().getPrice() * item.getQuantity());
                    orderDetails.setOrderID(order);
                    orderDetailsFacade.create(orderDetails);
                    Products p=item.getProduct();
                    orderTotal+=item.getProduct().getPrice() * item.getQuantity();
                    p.setUnitInStock(p.getUnitInStock()-item.getQuantity());
                    productsFacade.edit(p);
                    delete(p.getId());
                }
            }
            order.setTotal(orderTotal);
            ordersFacade.edit(order);
            order = new Orders();
            toastController.showInfo("Place order", "Order placed successfully");

        } catch (Exception e) {
            e.printStackTrace();
            toastController.showError("Place order", e.getMessage());

        }
    }

    public void search() {
        if (!searchName.isEmpty()) {
            productList = productsFacade.searchByName(searchName);
        } else {
            productList.clear();
        }

    }

    public ArrayList<CartItem> showCheckedList() {
        ArrayList<CartItem> checkedList = new ArrayList<>();

        if (!list.isEmpty()) {
            for (CartItem item : list) {
                if (item.getIsChecked()) {
                    checkedList.add(item);
                }
            }
        }

        return checkedList;
    }

    public void addCart(Integer productID, Integer quantity) {
        try {
            if (productID == null) {
                HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
                        .getRequest();

                productID = Integer.valueOf(request.getParameter("productID"));
                System.out.println(productID);
            }
            Products product = productsFacade.find(productID);
            int index = this.exists(product.getId());
            if (index == -1) {
                this.list.add(new CartItem(product, 1));
            } else {
                int quant = this.list.get(index).getQuantity() + 1;
                this.list.get(index).setQuantity(quant);
            }

            toastController.showInfo("Added to cart", "Added " + product.getName());
        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println(productID);
        }

    }

    public void delete(int productID) {
        int index = this.exists(productID);
        this.list.remove(index);

    }

    public int exists(int id) {
        try {
            for (int i = 0; i < this.list.size(); i++) {
                if (this.list.get(i).getProduct().getId() == id) {
                    return i;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public int total() {
        int total = 0;
        for (CartItem item : list) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    public int checkedTotal() {
        int total = 0;
        for (CartItem item : list) {
            if (item.getIsChecked()) {
                total += item.getProduct().getPrice() * item.getQuantity();
            }
        }
        return total;
    }

    public List<CartItem> getList() {
        return list;
    }

    public void setList(List<CartItem> list) {
        this.list = list;
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

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}
