/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbeans;

import com.entities.Slides;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thanh
 */
@Local
public interface SlidesFacadeLocal {

    void create(Slides slides);

    void edit(Slides slides);

    void remove(Slides slides);

    Slides find(Object id);

    List<Slides> findAll();

    List<Slides> findRange(int[] range);
    List<Slides> findByName(String name);

    int count();
    
}
