package com.entities;

import com.entities.Accounts;
import com.entities.Categories;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-14T20:58:02")
@StaticMetamodel(Posts.class)
public class Posts_ { 

    public static volatile SingularAttribute<Posts, String> thumb;
    public static volatile SingularAttribute<Posts, String> author;
    public static volatile SingularAttribute<Posts, String> metaDesc;
    public static volatile SingularAttribute<Posts, String> sContents;
    public static volatile SingularAttribute<Posts, String> metaKey;
    public static volatile SingularAttribute<Posts, Boolean> published;
    public static volatile SingularAttribute<Posts, String> title;
    public static volatile SingularAttribute<Posts, String> tags;
    public static volatile SingularAttribute<Posts, Accounts> accountID;
    public static volatile SingularAttribute<Posts, Categories> catID;
    public static volatile SingularAttribute<Posts, Boolean> isNewFeed;
    public static volatile SingularAttribute<Posts, String> contents;
    public static volatile SingularAttribute<Posts, String> alias;
    public static volatile SingularAttribute<Posts, Integer> id;
    public static volatile SingularAttribute<Posts, Boolean> isHot;
    public static volatile SingularAttribute<Posts, Integer> views;
    public static volatile SingularAttribute<Posts, Date> createDate;

}