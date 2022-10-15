/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbeans;

import com.entities.AttributesDetails;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thanh
 */
@Local
public interface AttributesDetailsFacadeLocal {

    void create(AttributesDetails attributesDetails);

    void edit(AttributesDetails attributesDetails);

    void remove(AttributesDetails attributesDetails);

    AttributesDetails find(Object id);

    List<AttributesDetails> findAll();

    List<AttributesDetails> findRange(int[] range);

    int count();
    
}
