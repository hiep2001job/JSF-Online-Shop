/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbeans;

import com.entities.Attributes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thanh
 */
@Local
public interface AttributesFacadeLocal {

    void create(Attributes attributes);

    void edit(Attributes attributes);

    void remove(Attributes attributes);

    Attributes find(Object id);

    List<Attributes> findAll();

    List<Attributes> findRange(int[] range);

    int count();
    
}
