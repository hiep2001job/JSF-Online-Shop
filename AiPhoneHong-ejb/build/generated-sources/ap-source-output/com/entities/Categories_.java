package com.entities;

import com.entities.Categories;
import com.entities.Posts;
import com.entities.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-14T20:58:02")
@StaticMetamodel(Categories.class)
public class Categories_ { 

    public static volatile SingularAttribute<Categories, String> thumb;
    public static volatile SingularAttribute<Categories, Integer> ordering;
    public static volatile SingularAttribute<Categories, String> metaDesc;
    public static volatile CollectionAttribute<Categories, Categories> categoriesCollection;
    public static volatile SingularAttribute<Categories, String> description;
    public static volatile SingularAttribute<Categories, String> metaKey;
    public static volatile SingularAttribute<Categories, Boolean> published;
    public static volatile SingularAttribute<Categories, String> schemaMarkup;
    public static volatile SingularAttribute<Categories, String> title;
    public static volatile SingularAttribute<Categories, Categories> parentID;
    public static volatile SingularAttribute<Categories, String> cover;
    public static volatile CollectionAttribute<Categories, Products> productsCollection;
    public static volatile CollectionAttribute<Categories, Posts> postsCollection;
    public static volatile SingularAttribute<Categories, String> name;
    public static volatile SingularAttribute<Categories, String> alias;
    public static volatile SingularAttribute<Categories, Integer> id;
    public static volatile SingularAttribute<Categories, Integer> levels;

}