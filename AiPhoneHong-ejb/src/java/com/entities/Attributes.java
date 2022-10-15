/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thanh
 */
@Entity
@Table(name = "Attributes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attributes.findAll", query = "SELECT a FROM Attributes a"),
    @NamedQuery(name = "Attributes.findById", query = "SELECT a FROM Attributes a WHERE a.id = :id"),
    @NamedQuery(name = "Attributes.findByPrice", query = "SELECT a FROM Attributes a WHERE a.price = :price"),
    @NamedQuery(name = "Attributes.findByName", query = "SELECT a FROM Attributes a WHERE a.name = :name"),
    @NamedQuery(name = "Attributes.findByActive", query = "SELECT a FROM Attributes a WHERE a.active = :active")})
public class Attributes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Price")
    private Integer price;
    @Size(max = 50)
    @Column(name = "Name")
    private String name;
    @Column(name = "Active")
    private Boolean active;
    @JoinColumn(name = "ProductID", referencedColumnName = "ID")
    @ManyToOne
    private Products productID;
    @OneToMany(mappedBy = "attributeID")
    private Collection<AttributeDetails> attributeDetailsCollection;

    public Attributes() {
    }

    public Attributes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Products getProductID() {
        return productID;
    }

    public void setProductID(Products productID) {
        this.productID = productID;
    }

    @XmlTransient
    public Collection<AttributeDetails> getAttributeDetailsCollection() {
        return attributeDetailsCollection;
    }

    public void setAttributeDetailsCollection(Collection<AttributeDetails> attributeDetailsCollection) {
        this.attributeDetailsCollection = attributeDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attributes)) {
            return false;
        }
        Attributes other = (Attributes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Attributes[ id=" + id + " ]";
    }
    
}
