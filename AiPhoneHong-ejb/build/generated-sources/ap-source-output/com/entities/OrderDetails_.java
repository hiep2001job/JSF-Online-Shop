package com.entities;

import com.entities.Orders;
import com.entities.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-14T20:58:02")
@StaticMetamodel(OrderDetails.class)
public class OrderDetails_ { 

    public static volatile SingularAttribute<OrderDetails, Integer> total;
    public static volatile SingularAttribute<OrderDetails, Integer> quantity;
    public static volatile SingularAttribute<OrderDetails, Products> productID;
    public static volatile SingularAttribute<OrderDetails, Orders> orderID;
    public static volatile SingularAttribute<OrderDetails, Integer> price;
    public static volatile SingularAttribute<OrderDetails, Integer> id;

}