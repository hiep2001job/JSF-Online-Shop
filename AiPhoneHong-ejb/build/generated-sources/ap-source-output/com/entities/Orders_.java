package com.entities;

import com.entities.Customers;
import com.entities.OrderDetails;
import com.entities.TransactionStatus;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-14T20:58:02")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, String> note;
    public static volatile SingularAttribute<Orders, TransactionStatus> transactStatusID;
    public static volatile CollectionAttribute<Orders, OrderDetails> orderDetailsCollection;
    public static volatile SingularAttribute<Orders, Date> shipDate;
    public static volatile SingularAttribute<Orders, Integer> total;
    public static volatile SingularAttribute<Orders, Boolean> deleted;
    public static volatile SingularAttribute<Orders, Integer> paymentID;
    public static volatile SingularAttribute<Orders, Boolean> paid;
    public static volatile SingularAttribute<Orders, Customers> customerID;
    public static volatile SingularAttribute<Orders, String> shippingAddress;
    public static volatile SingularAttribute<Orders, Boolean> isConfirmed;
    public static volatile SingularAttribute<Orders, Integer> id;
    public static volatile SingularAttribute<Orders, Date> paymentDate;
    public static volatile SingularAttribute<Orders, Date> orderDate;

}