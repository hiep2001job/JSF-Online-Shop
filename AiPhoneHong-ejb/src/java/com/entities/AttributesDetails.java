/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thanh
 */
@Entity
@Table(name = "AttributesDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttributesDetails.findAll", query = "SELECT a FROM AttributesDetails a"),
    @NamedQuery(name = "AttributesDetails.findById", query = "SELECT a FROM AttributesDetails a WHERE a.id = :id"),
    @NamedQuery(name = "AttributesDetails.findByName", query = "SELECT a FROM AttributesDetails a WHERE a.name = :name"),
    @NamedQuery(name = "AttributesDetails.findByValue", query = "SELECT a FROM AttributesDetails a WHERE a.value = :value"),
    @NamedQuery(name = "AttributesDetails.findByAttributeID", query = "SELECT a FROM AttributesDetails a WHERE a.attributeID = :attributeID")})
public class AttributesDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "Name")
    private String name;
    @Size(max = 100)
    @Column(name = "Value")
    private String value;
    @Column(name = "AttributeID")
    private Integer attributeID;

    public AttributesDetails() {
    }

    public AttributesDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(Integer attributeID) {
        this.attributeID = attributeID;
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
        if (!(object instanceof AttributesDetails)) {
            return false;
        }
        AttributesDetails other = (AttributesDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.AttributesDetails[ id=" + id + " ]";
    }
    
}
