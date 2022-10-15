/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.authentication;

import com.entities.Customers;
import com.sessionbeans.CustomersFacadeLocal;
import com.sessionbeans.LocationsFacadeLocal;
import com.ultilities.StringHandler;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thanh
 */
@Named(value = "userIdentity")
@SessionScoped
public class UserIdentity implements Serializable {

    @EJB
    private LocationsFacadeLocal locationsFacade;

    @EJB
    private CustomersFacadeLocal customersFacade;

    private Customers customer = new Customers();
    private Boolean isLoggedIn = Boolean.FALSE;

    private Customers regisCustomer=new Customers();
            
    private String email = "";

    private String password = "";
    private String message = "";

    /**
     * Creates a new instance of UserIdentity
     */
    public UserIdentity() {
    }

    public String login() {
        password = StringHandler.getMD5(password);
        customer = customersFacade.login(email, password);
        if (customer != null) {
            isLoggedIn = Boolean.TRUE;
            return "profile";
        } else {
            message = "Email or password is incorrect";
            return "signIn";
        }
    }

    public void updateInfor() {

    }

    public String register() {
        try {
            
            regisCustomer.setActive(Boolean.TRUE);
            regisCustomer.setPassword(StringHandler.getMD5(regisCustomer.getPassword()));

            customersFacade.create(regisCustomer);
            message = "Register successfully";
            return "signIn";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return "signUp";
        }

    }

    public String logout() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();

        return "signIn";
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(Boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Customers getRegisCustomer() {
        return regisCustomer;
    }

    public void setRegisCustomer(Customers regisCustomer) {
        this.regisCustomer = regisCustomer;
    }

}
