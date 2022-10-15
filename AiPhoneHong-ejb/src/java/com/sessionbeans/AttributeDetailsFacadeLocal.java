/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbeans;

import com.entities.AttributeDetails;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thanh
 */
@Local
public interface AttributeDetailsFacadeLocal {

    void create(AttributeDetails attributeDetails);

    void edit(AttributeDetails attributeDetails);

    void remove(AttributeDetails attributeDetails);

    AttributeDetails find(Object id);

    List<AttributeDetails> findAll();

    List<AttributeDetails> findRange(int[] range);

    int count();
    
}
