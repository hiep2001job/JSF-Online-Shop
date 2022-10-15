package com.entities;

import com.entities.Attributes;
import com.entities.Categories;
import com.entities.OrderDetails;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-14T20:58:02")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, String> thumb;
    public static volatile CollectionAttribute<Products, OrderDetails> orderDetailsCollection;
    public static volatile SingularAttribute<Products, String> metaDesc;
    public static volatile SingularAttribute<Products, String> description;
    public static volatile SingularAttribute<Products, Integer> discount;
    public static volatile SingularAttribute<Products, Boolean> active;
    public static volatile SingularAttribute<Products, String> metaKey;
    public static volatile SingularAttribute<Products, String> video;
    public static volatile SingularAttribute<Products, String> title;
    public static volatile SingularAttribute<Products, String> tags;
    public static volatile SingularAttribute<Products, Categories> catID;
    public static volatile SingularAttribute<Products, Boolean> homeFlag;
    public static volatile SingularAttribute<Products, Integer> price;
    public static volatile SingularAttribute<Products, String> name;
    public static volatile SingularAttribute<Products, String> alias;
    public static volatile SingularAttribute<Products, String> shortDesc;
    public static volatile SingularAttribute<Products, Integer> id;
    public static volatile CollectionAttribute<Products, Attributes> attributesCollection;
    public static volatile SingularAttribute<Products, Date> createDate;
    public static volatile SingularAttribute<Products, Boolean> bestSellers;
    public static volatile SingularAttribute<Products, Integer> unitInStock;

}