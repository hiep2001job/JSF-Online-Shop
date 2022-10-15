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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thanh
 */
@Entity
@Table(name = "Categories")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categories.findAll", query = "SELECT c FROM Categories c"),
    @NamedQuery(name = "Categories.findById", query = "SELECT c FROM Categories c WHERE c.id = :id"),
    @NamedQuery(name = "Categories.findByName", query = "SELECT c FROM Categories c WHERE c.name = :name"),
    @NamedQuery(name = "Categories.findByDescription", query = "SELECT c FROM Categories c WHERE c.description = :description"),
    @NamedQuery(name = "Categories.findByLevels", query = "SELECT c FROM Categories c WHERE c.levels = :levels"),
    @NamedQuery(name = "Categories.findByOrdering", query = "SELECT c FROM Categories c WHERE c.ordering = :ordering"),
    @NamedQuery(name = "Categories.findByPublished", query = "SELECT c FROM Categories c WHERE c.published = :published"),
    @NamedQuery(name = "Categories.findByThumb", query = "SELECT c FROM Categories c WHERE c.thumb = :thumb"),
    @NamedQuery(name = "Categories.findByTitle", query = "SELECT c FROM Categories c WHERE c.title = :title"),
    @NamedQuery(name = "Categories.findByAlias", query = "SELECT c FROM Categories c WHERE c.alias = :alias"),
    @NamedQuery(name = "Categories.findByMetaDesc", query = "SELECT c FROM Categories c WHERE c.metaDesc = :metaDesc"),
    @NamedQuery(name = "Categories.findByMetaKey", query = "SELECT c FROM Categories c WHERE c.metaKey = :metaKey"),
    @NamedQuery(name = "Categories.findByCover", query = "SELECT c FROM Categories c WHERE c.cover = :cover"),
    @NamedQuery(name = "Categories.findBySchemaMarkup", query = "SELECT c FROM Categories c WHERE c.schemaMarkup = :schemaMarkup")})
public class Categories implements Serializable {

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
    @Column(name = "Description")
    private String description;
    @Column(name = "Levels")
    private Integer levels;
    @Column(name = "Ordering")
    private Integer ordering;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Published")
    private boolean published;
    @Size(max = 250)
    @Column(name = "Thumb")
    private String thumb;
    @Size(max = 250)
    @Column(name = "Title")
    private String title;
    @Size(max = 250)
    @Column(name = "Alias")
    private String alias;
    @Size(max = 250)
    @Column(name = "MetaDesc")
    private String metaDesc;
    @Size(max = 250)
    @Column(name = "MetaKey")
    private String metaKey;
    @Size(max = 255)
    @Column(name = "Cover")
    private String cover;
    @Size(max = 2147483647)
    @Column(name = "SchemaMarkup")
    private String schemaMarkup;
    @OneToMany(mappedBy = "catID")
    private Collection<Products> productsCollection;
    @OneToMany(mappedBy = "parentID")
    private Collection<Categories> categoriesCollection;
    @JoinColumn(name = "ParentID", referencedColumnName = "ID")
    @ManyToOne
    private Categories parentID;
    @OneToMany(mappedBy = "catID")
    private Collection<Posts> postsCollection;

    public Categories() {
    }

    public Categories(Integer id) {
        this.id = id;
    }

    public Categories(Integer id, boolean published) {
        this.id = id;
        this.published = published;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public Integer getOrdering() {
        return ordering;
    }

    public void setOrdering(Integer ordering) {
        this.ordering = ordering;
    }

    public boolean getPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getSchemaMarkup() {
        return schemaMarkup;
    }

    public void setSchemaMarkup(String schemaMarkup) {
        this.schemaMarkup = schemaMarkup;
    }

    @XmlTransient
    public Collection<Products> getProductsCollection() {
        return productsCollection;
    }

    public void setProductsCollection(Collection<Products> productsCollection) {
        this.productsCollection = productsCollection;
    }

    @XmlTransient
    public Collection<Categories> getCategoriesCollection() {
        return categoriesCollection;
    }

    public void setCategoriesCollection(Collection<Categories> categoriesCollection) {
        this.categoriesCollection = categoriesCollection;
    }

    public Categories getParentID() {
        return parentID;
    }

    public void setParentID(Categories parentID) {
        this.parentID = parentID;
    }

    @XmlTransient
    public Collection<Posts> getPostsCollection() {
        return postsCollection;
    }

    public void setPostsCollection(Collection<Posts> postsCollection) {
        this.postsCollection = postsCollection;
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
        if (!(object instanceof Categories)) {
            return false;
        }
        Categories other = (Categories) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Categories[ id=" + id + " ]";
    }
    
}
