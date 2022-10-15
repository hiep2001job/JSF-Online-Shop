/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.controllers;

import com.entities.OrderDetails;
import com.entities.Orders;
import com.sessionbeans.OrdersFacadeLocal;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author thanh
 */
@Named(value = "orderController")
@RequestScoped
public class OrderController {

    @EJB
    private OrdersFacadeLocal ordersFacade;

    private ArrayList<Orders> orderList = new ArrayList<>();

    private Orders orderDetail = new Orders();
    @Inject
    ToastController toastController;

    /**
     * Creates a new instance of OrderController
     */
    public OrderController() {
    }

    @PostConstruct
    public void postContruct() {
        orderList = new ArrayList(ordersFacade.findAllDescDate());
    }

    public ArrayList<OrderDetails> showOrderDetail() {
        Orders order = ordersFacade.find(orderDetail.getId());
        return new ArrayList(order.getOrderDetailsCollection());
    }

    public String viewOrderDetail(int id) {
        orderDetail = ordersFacade.find(id);
        return "orderDetail";
    }

    public void confirmOrder() {
        try {
            int id = Integer.valueOf(((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter("orderID"));
            Orders order = ordersFacade.find(id);
            order.setIsConfirmed(Boolean.TRUE);
            ordersFacade.edit(order);
            orderDetail = ordersFacade.find(id);
            toastController.showInfo("Confirm order", "Successfully");
        } catch (Exception e) {
            e.printStackTrace();
            toastController.showError("Confirm order", e.getMessage());
        }
    }

    public ArrayList<Orders> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Orders> orderList) {
        this.orderList = orderList;
    }

    public Orders getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(Orders orderDetail) {
        this.orderDetail = orderDetail;
    }

}
