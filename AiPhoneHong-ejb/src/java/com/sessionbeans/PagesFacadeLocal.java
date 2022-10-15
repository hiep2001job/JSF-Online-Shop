/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbeans;

import com.entities.Pages;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thanh
 */
@Local
public interface PagesFacadeLocal {

    void create(Pages pages);

    void edit(Pages pages);

    void remove(Pages pages);

    Pages find(Object id);

    List<Pages> findAll();

    List<Pages> findRange(int[] range);

    int count();
    
}
