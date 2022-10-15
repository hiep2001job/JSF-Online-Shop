/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbeans;

import com.entities.TransactionStatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thanh
 */
@Local
public interface TransactionStatusFacadeLocal {

    void create(TransactionStatus transactionStatus);

    void edit(TransactionStatus transactionStatus);

    void remove(TransactionStatus transactionStatus);

    TransactionStatus find(Object id);

    List<TransactionStatus> findAll();

    List<TransactionStatus> findRange(int[] range);

    int count();
    
}
