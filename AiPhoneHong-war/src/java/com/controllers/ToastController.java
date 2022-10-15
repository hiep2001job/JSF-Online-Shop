/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.controllers;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author thanh
 */
@Named(value = "toastController")
@RequestScoped
public class ToastController {

    /**
     * Creates a new instance of ToastController
     */
    public ToastController() {
    }
    
     public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showInfo(String title,String content) {
        addMessage(FacesMessage.SEVERITY_INFO, title, content);
    }

    public void showWarn(String title,String content) {
        addMessage(FacesMessage.SEVERITY_WARN, title, content);
    }

    public void showError(String title,String content) {
        addMessage(FacesMessage.SEVERITY_ERROR,  title, content);
    }

    public void showSticky(String title,String content) {
        FacesContext.getCurrentInstance().addMessage("sticky-key", new FacesMessage(FacesMessage.SEVERITY_INFO,  title, content));
    }

    public void showMultiple() {
        addMessage(FacesMessage.SEVERITY_INFO, "Message 1", "Message Content");
        addMessage(FacesMessage.SEVERITY_INFO, "Message 2", "Message Content");
        addMessage(FacesMessage.SEVERITY_INFO, "Message 3", "Message Content");
    }
}
