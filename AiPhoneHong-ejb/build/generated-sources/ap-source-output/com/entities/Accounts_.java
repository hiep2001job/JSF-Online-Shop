package com.entities;

import com.entities.Posts;
import com.entities.Roles;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-14T20:58:02")
@StaticMetamodel(Accounts.class)
public class Accounts_ { 

    public static volatile SingularAttribute<Accounts, Date> lastLogin;
    public static volatile SingularAttribute<Accounts, String> password;
    public static volatile SingularAttribute<Accounts, String> salt;
    public static volatile SingularAttribute<Accounts, String> phone;
    public static volatile CollectionAttribute<Accounts, Posts> postsCollection;
    public static volatile SingularAttribute<Accounts, Roles> roleID;
    public static volatile SingularAttribute<Accounts, Boolean> active;
    public static volatile SingularAttribute<Accounts, Integer> id;
    public static volatile SingularAttribute<Accounts, String> fullname;
    public static volatile SingularAttribute<Accounts, String> email;
    public static volatile SingularAttribute<Accounts, Date> createDate;

}