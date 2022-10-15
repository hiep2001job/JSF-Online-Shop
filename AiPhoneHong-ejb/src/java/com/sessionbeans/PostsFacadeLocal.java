/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sessionbeans;

import com.entities.Posts;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thanh
 */
@Local
public interface PostsFacadeLocal {

    void create(Posts posts);

    void edit(Posts posts);

    void remove(Posts posts);

    Posts find(Object id);

    List<Posts> findAll();

    List<Posts> findRange(int[] range);

    int count();
    
}
