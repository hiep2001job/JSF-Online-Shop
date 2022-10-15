package com.entities;

import com.entities.Accounts;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-14T20:58:02")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile CollectionAttribute<Roles, Accounts> accountsCollection;
    public static volatile SingularAttribute<Roles, String> name;
    public static volatile SingularAttribute<Roles, String> description;
    public static volatile SingularAttribute<Roles, Integer> id;

}