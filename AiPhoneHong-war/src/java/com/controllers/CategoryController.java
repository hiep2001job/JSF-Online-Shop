/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.controllers;

import com.entities.Categories;

import com.sessionbeans.CategoriesFacadeLocal;
import com.ultilities.StringHandler;
import com.ultilities.Utils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author thanh
 */
@Named(value = "categoryCtrler")
@RequestScoped
public class CategoryController {


    @EJB
    private CategoriesFacadeLocal categoriesFacade;
//create
    private Categories category = new Categories();
    private int parentID;
//edit
    private Categories selectedEditCategories = new Categories();
    private int selectedEditParent = 0;
//message
    private String message = "";
//list
    private String filterName;
    private List<Categories> cateList = new ArrayList<>();
    private String statusFilter = "all";
//view
    private Categories selectedCategories;
    private UploadedFile file;
    private String savedPath;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Creates a new instance of CategoryMb
     */
    public CategoryController() {
    }

    public void applySearch() {
        cateList = categoriesFacade.findByName(filterName);
    }

    public String categoryAdd() {
        return "categoryAdd";
    }

    public String categoryList() {
        return "categoryList";
    }

    @PostConstruct
    public void postConstruct() {
        applyFilter();

    }

    public void createCategory() {
        try {

            category.setAlias(StringHandler.toSlug(category.getName()));
            category.setParentID(categoriesFacade.find(parentID));
            while (!categoriesFacade.checkUniqueCategoryAlias(message)) {
                category.setAlias(category.getAlias() + Utils.getRandomNumber(100, 900));
            }
            categoriesFacade.create(category);

            message = "Create category successfully";
            category = new Categories();
        } catch (Exception e) {
            message = "Error";
            System.out.println(e.getMessage());
        }
    }

    public String edit(Integer id) {

        selectedEditCategories = categoriesFacade.find(id);
        if (selectedEditCategories != null) {

            selectedEditParent = selectedEditCategories.getParentID().getId();
            return "categoryEdit";
        }
        return "category";
    }

    public void saveEditCategory() {

        selectedEditCategories.setParentID(categoriesFacade.find(selectedEditParent));

        categoriesFacade.edit(selectedEditCategories);
        message = "Edit category successfully";
    }

    public void deleteCategory(Integer id) {
        Categories delCate = categoriesFacade.find(id);
        if (delCate != null) {
            categoriesFacade.remove(delCate);
            message = "Category deleted";
        } else {
            message = "Error while deleting category";
        }
    }

    public List<Categories> showAllCategories() {
        return categoriesFacade.findAll();
    }

    public void applyFilter() {
        System.out.println("Filter " + statusFilter);
        Boolean isPublished = statusFilter.equals("published");
        switch (statusFilter) {
            case "all":
                cateList = showAllCategories();
                break;
            case "published":
                cateList = categoriesFacade.findByPublished(isPublished);
                break;
            case "unpublished":
                cateList = categoriesFacade.findByPublished(isPublished);
                break;
        }
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public String getSavedPath() {
        return savedPath;
    }

    public void setSavedPath(String savedPath) {
        this.savedPath = savedPath;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public Categories getSelectedEditCategories() {
        return selectedEditCategories;
    }

    public void setSelectedEditCategories(Categories selectedEditCategories) {
        this.selectedEditCategories = selectedEditCategories;
    }

    public int getSelectedEditParent() {
        return selectedEditParent;
    }

    public void setSelectedEditParent(int selectedEditParent) {
        this.selectedEditParent = selectedEditParent;
    }

    public List<Categories> getCateList() {
        return cateList;
    }

    public void setCateList(List<Categories> cateList) {
        this.cateList = cateList;
    }

    public Categories getSelectedCategories() {
        return selectedCategories;
    }

    public void setSelectedCategories(Categories selectedCategories) {
        this.selectedCategories = selectedCategories;
    }

    public String getStatusFilter() {
        return statusFilter;
    }

    public void setStatusFilter(String statusFilter) {
        this.statusFilter = statusFilter;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

}
