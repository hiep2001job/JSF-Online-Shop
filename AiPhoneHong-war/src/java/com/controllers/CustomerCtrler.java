/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.controllers;

import com.entities.Customers;
import com.sessionbeans.CustomersFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import javax.enterprise.context.RequestScoped;

/**
 *
 * @author thanh
 */
@Named(value = "customerCtrler")
@RequestScoped
public class CustomerCtrler {

    @EJB
    private CustomersFacadeLocal customersFacade;

    private List<Customers> customerList = new ArrayList<>();
    private String filterName;
    private Customers detailCustomer;

    /**
     * Creates a new instance of CustomerCtrler
     */
    public CustomerCtrler() {
    }

    @PostConstruct
    public void init() {
        customerList = customersFacade.findAllDesc();
    }

    public String detail(int id) {
        detailCustomer=customersFacade.find(id);
        return "customerDetail";
    }

    public void applySearch() {
        customerList = customersFacade.findByName(filterName);
    }

    public List<Customers> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customers> customerList) {
        this.customerList = customerList;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public Customers getDetailCustomer() {
        return detailCustomer;
    }

    public void setDetailCustomer(Customers detailCustomer) {
        this.detailCustomer = detailCustomer;
    }

}
