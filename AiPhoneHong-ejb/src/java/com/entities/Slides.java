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
@Table(name = "Slides")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Slides.findAll", query = "SELECT s FROM Slides s"),
    @NamedQuery(name = "Slides.findById", query = "SELECT s FROM Slides s WHERE s.id = :id"),
    @NamedQuery(name = "Slides.findByName", query = "SELECT s FROM Slides s WHERE s.name = :name"),
    @NamedQuery(name = "Slides.findByLink", query = "SELECT s FROM Slides s WHERE s.link = :link"),
    @NamedQuery(name = "Slides.findByImage", query = "SELECT s FROM Slides s WHERE s.image = :image")})
public class Slides implements Serializable {

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
    @Column(name = "Link")
    private String link;
    @Size(max = 255)
    @Column(name = "Image")
    private String image;

    public Slides() {
    }

    public Slides(Integer id) {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        if (!(object instanceof Slides)) {
            return false;
        }
        Slides other = (Slides) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Slides[ id=" + id + " ]";
    }
    
}
