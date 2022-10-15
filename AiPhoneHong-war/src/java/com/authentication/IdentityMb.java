/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.authentication;

import com.entities.Accounts;
import com.sessionbeans.AccountsFacadeLocal;
import com.ultilities.StringHandler;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author thanh
 */
@Named(value = "identityMb")
@SessionScoped
public class IdentityMb implements Serializable {

    @EJB
    private AccountsFacadeLocal accountsFacade;

    private Accounts loggedAccount;
    private String username = "";
    private String password = "";
    private Boolean isLoggedIn=Boolean.FALSE;

    /**
     * Creates a new instance of IdentityMb
     */
    public IdentityMb() {
    }

    public void checkLoggedIn() {
        if (loggedAccount == null) {
            try {
                ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
                ec.redirect(ec.getRequestContextPath() + "/faces/admin/login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(IdentityMb.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public String login() {
        try {
           
            loggedAccount = accountsFacade.login(username, StringHandler.getMD5(password));
        } catch (Exception e) {
               System.out.println(e.getMessage());
        }
        

        if (loggedAccount != null) {
            isLoggedIn=Boolean.TRUE;
            return "category";
        }
        return "login";
    }

    public Accounts getLoggedAccount() {
        return loggedAccount;
    }

    public void setLoggedAccount(Accounts loggedAccount) {
        this.loggedAccount = loggedAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(Boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

}
