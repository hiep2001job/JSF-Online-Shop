/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thanh
 */
@Entity
@Table(name = "Pages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pages.findAll", query = "SELECT p FROM Pages p"),
    @NamedQuery(name = "Pages.findById", query = "SELECT p FROM Pages p WHERE p.id = :id"),
    @NamedQuery(name = "Pages.findByName", query = "SELECT p FROM Pages p WHERE p.name = :name"),
    @NamedQuery(name = "Pages.findByContents", query = "SELECT p FROM Pages p WHERE p.contents = :contents"),
    @NamedQuery(name = "Pages.findByThumb", query = "SELECT p FROM Pages p WHERE p.thumb = :thumb"),
    @NamedQuery(name = "Pages.findByPublished", query = "SELECT p FROM Pages p WHERE p.published = :published"),
    @NamedQuery(name = "Pages.findByTitle", query = "SELECT p FROM Pages p WHERE p.title = :title"),
    @NamedQuery(name = "Pages.findByMetaDesc", query = "SELECT p FROM Pages p WHERE p.metaDesc = :metaDesc"),
    @NamedQuery(name = "Pages.findByMetaKey", query = "SELECT p FROM Pages p WHERE p.metaKey = :metaKey"),
    @NamedQuery(name = "Pages.findByAlias", query = "SELECT p FROM Pages p WHERE p.alias = :alias"),
    @NamedQuery(name = "Pages.findByCreateDate", query = "SELECT p FROM Pages p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "Pages.findByOrdering", query = "SELECT p FROM Pages p WHERE p.ordering = :ordering")})
public class Pages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 250)
    @Column(name = "Name")
    private String name;
    @Size(max = 2147483647)
    @Column(name = "Contents")
    private String contents;
    @Size(max = 250)
    @Column(name = "Thumb")
    private String thumb;
    @Column(name = "Published")
    private Boolean published;
    @Size(max = 250)
    @Column(name = "Title")
    private String title;
    @Size(max = 250)
    @Column(name = "MetaDesc")
    private String metaDesc;
    @Size(max = 250)
    @Column(name = "MetaKey")
    private String metaKey;
    @Size(max = 250)
    @Column(name = "Alias")
    private String alias;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "Ordering")
    private Integer ordering;

    public Pages() {
    }

    public Pages(Integer id) {
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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetaDesc() {
        return metaDesc;
    }

    public void setMetaDesc(String metaDesc) {
        this.metaDesc = metaDesc;
    }

    public String getMetaKey() {
        return metaKey;
    }

    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getOrdering() {
        return ordering;
    }

    public void setOrdering(Integer ordering) {
        this.ordering = ordering;
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
        if (!(object instanceof Pages)) {
            return false;
        }
        Pages other = (Pages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Pages[ id=" + id + " ]";
    }
    
}
