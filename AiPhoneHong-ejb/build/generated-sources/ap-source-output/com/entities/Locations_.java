package com.entities;

import com.entities.Customers;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-14T20:58:02")
@StaticMetamodel(Locations.class)
public class Locations_ { 

    public static volatile SingularAttribute<Locations, Boolean> isMainLocation;
    public static volatile SingularAttribute<Locations, String> addressDetail;
    public static volatile SingularAttribute<Locations, String> phone;
    public static volatile SingularAttribute<Locations, String> receiverName;
    public static volatile SingularAttribute<Locations, String> name;
    public static volatile SingularAttribute<Locations, Customers> customerID;
    public static volatile SingularAttribute<Locations, Integer> id;

}