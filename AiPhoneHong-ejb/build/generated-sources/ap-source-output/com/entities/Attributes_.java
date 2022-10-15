package com.entities;

import com.entities.AttributeDetails;
import com.entities.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2022-10-14T20:58:02")
@StaticMetamodel(Attributes.class)
public class Attributes_ { 

    public static volatile SingularAttribute<Attributes, Products> productID;
    public static volatile SingularAttribute<Attributes, Integer> price;
    public static volatile SingularAttribute<Attributes, String> name;
    public static volatile SingularAttribute<Attributes, Boolean> active;
    public static volatile SingularAttribute<Attributes, Integer> id;
    public static volatile CollectionAttribute<Attributes, AttributeDetails> attributeDetailsCollection;

}