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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "AttributeDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AttributeDetails.findAll", query = "SELECT a FROM AttributeDetails a"),
    @NamedQuery(name = "AttributeDetails.findById", query = "SELECT a FROM AttributeDetails a WHERE a.id = :id"),
    @NamedQuery(name = "AttributeDetails.findByName", query = "SELECT a FROM AttributeDetails a WHERE a.name = :name"),
    @NamedQuery(name = "AttributeDetails.findByValue", query = "SELECT a FROM AttributeDetails a WHERE a.value = :value")})
public class AttributeDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "Name")
    private String name;
    @Size(max = 50)
    @Column(name = "Value")
    private String value;
    @JoinColumn(name = "AttributeID", referencedColumnName = "ID")
    @ManyToOne
    private Attributes attributeID;

    public AttributeDetails() {
    }

    public AttributeDetails(Integer id) {
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

    public Attributes getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(Attributes attributeID) {
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
        if (!(object instanceof AttributeDetails)) {
            return false;
        }
        AttributeDetails other = (AttributeDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.AttributeDetails[ id=" + id + " ]";
    }
    
}
