/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbeans;

import com.entities.Categories;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thanh
 */
@Local
public interface CategoriesFacadeLocal extends Serializable {

    void create(Categories categories);

    void edit(Categories categories);

    void remove(Categories categories);

    Categories find(Object id);

    List<Categories> findAll();

    List<Categories> findRange(int[] range);

    List<Categories> findByPublished(Boolean published);
    List<Categories> findByName(String name);

    boolean checkUniqueCategoryAlias(String alias);

    int count();

}
