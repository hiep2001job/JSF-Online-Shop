package com.entities;

import com.entities.Locations;
import com.entities.Orders;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-14T20:58:02")
@StaticMetamodel(Customers.class)
public class Customers_ { 

    public static volatile SingularAttribute<Customers, Date> birthday;
    public static volatile SingularAttribute<Customers, Date> lastLogin;
    public static volatile SingularAttribute<Customers, String> address;
    public static volatile SingularAttribute<Customers, String> salt;
    public static volatile SingularAttribute<Customers, Boolean> active;
    public static volatile SingularAttribute<Customers, String> avatar;
    public static volatile SingularAttribute<Customers, Integer> ward;
    public static volatile CollectionAttribute<Customers, Orders> ordersCollection;
    public static volatile SingularAttribute<Customers, String> password;
    public static volatile SingularAttribute<Customers, String> phone;
    public static volatile SingularAttribute<Customers, Integer> district;
    public static volatile CollectionAttribute<Customers, Locations> locationsCollection;
    public static volatile SingularAttribute<Customers, Integer> id;
    public static volatile SingularAttribute<Customers, String> fullname;
    public static volatile SingularAttribute<Customers, String> email;
    public static volatile SingularAttribute<Customers, Date> createDate;

}