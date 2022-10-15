/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbeans;

import com.entities.Customers;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thanh
 */
@Local
public interface CustomersFacadeLocal {

    void create(Customers customers);

    void edit(Customers customers);

    void remove(Customers customers);

    Customers find(Object id);

    List<Customers> findAll();

    List<Customers> findRange(int[] range);

    Boolean checkUniqueCustomerEmail(String email);

    Customers login(String email, String pass);
    List<Customers> findAllDesc();
     List<Customers> findByName(String name);
    int count();

}
