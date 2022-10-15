package com.entities;

import com.entities.Orders;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-14T20:58:02")
@StaticMetamodel(TransactionStatus.class)
public class TransactionStatus_ { 

    public static volatile SingularAttribute<TransactionStatus, String> description;
    public static volatile SingularAttribute<TransactionStatus, Integer> id;
    public static volatile CollectionAttribute<TransactionStatus, Orders> ordersCollection;
    public static volatile SingularAttribute<TransactionStatus, String> status;

}