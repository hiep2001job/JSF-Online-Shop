/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.controllers;

import com.entities.Slides;
import com.sessionbeans.SlidesFacadeLocal;
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
@Named(value = "slideCtrler")
@RequestScoped
public class SlideController {

    @EJB
    private SlidesFacadeLocal slidesFacade;

    private String message = "";
    private Slides slide = new Slides();

    private Slides selectedEditSlide = new Slides();
    private String filterName;
    private List<Slides> slideList = new ArrayList<>();

    /**
     * Creates a new instance of SlideController
     */
    public SlideController() {
    }

    @PostConstruct
    public void init() {
        slideList = slidesFacade.findAll();
    }

    public void applySearch() {
        slideList = slidesFacade.findByName(filterName);
    }

    public String edit(int id) {
        selectedEditSlide = slidesFacade.find(id);
        if (selectedEditSlide != null) {
            return "slideEdit";
        }
        return "slide";
    }

    public String delete(int id) {
        Slides dslide = slidesFacade.find(id);
        if (slide != null) {
            slidesFacade.remove(dslide);
            message = "Deleted slide";
        }
        return "slide";
    }

    public void saveEditSlide() {
        slidesFacade.edit(selectedEditSlide);
        message = "Update slide successfully";
    }

    public void createSlide() {
        slidesFacade.create(slide);
        slide = new Slides();
        message = "Create Slide successfully";
    }

//    public List<Slides> showSlides() {
//        return slidesFacade.findAll();
//    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Slides getSlide() {
        return slide;
    }

    public void setSlide(Slides slide) {
        this.slide = slide;
    }

    public List<Slides> getSlideList() {
        return slideList;
    }

    public void setSlideList(List<Slides> slideList) {
        this.slideList = slideList;
    }

    public Slides getSelectedEditSlide() {
        return selectedEditSlide;
    }

    public void setSelectedEditSlide(Slides selectedEditSlide) {
        this.selectedEditSlide = selectedEditSlide;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }
}
