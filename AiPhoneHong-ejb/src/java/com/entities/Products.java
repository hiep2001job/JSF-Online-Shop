/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thanh
 */
@Entity
@Table(name = "Products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findById", query = "SELECT p FROM Products p WHERE p.id = :id"),
    @NamedQuery(name = "Products.findByName", query = "SELECT p FROM Products p WHERE p.name = :name"),
    @NamedQuery(name = "Products.findByShortDesc", query = "SELECT p FROM Products p WHERE p.shortDesc = :shortDesc"),
    @NamedQuery(name = "Products.findByDescription", query = "SELECT p FROM Products p WHERE p.description = :description"),
    @NamedQuery(name = "Products.findByPrice", query = "SELECT p FROM Products p WHERE p.price = :price"),
    @NamedQuery(name = "Products.findByDiscount", query = "SELECT p FROM Products p WHERE p.discount = :discount"),
    @NamedQuery(name = "Products.findByThumb", query = "SELECT p FROM Products p WHERE p.thumb = :thumb"),
    @NamedQuery(name = "Products.findByVideo", query = "SELECT p FROM Products p WHERE p.video = :video"),
    @NamedQuery(name = "Products.findByCreateDate", query = "SELECT p FROM Products p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "Products.findByBestSellers", query = "SELECT p FROM Products p WHERE p.bestSellers = :bestSellers"),
    @NamedQuery(name = "Products.findByHomeFlag", query = "SELECT p FROM Products p WHERE p.homeFlag = :homeFlag"),
    @NamedQuery(name = "Products.findByActive", query = "SELECT p FROM Products p WHERE p.active = :active"),
    @NamedQuery(name = "Products.findByTags", query = "SELECT p FROM Products p WHERE p.tags = :tags"),
    @NamedQuery(name = "Products.findByTitle", query = "SELECT p FROM Products p WHERE p.title = :title"),
    @NamedQuery(name = "Products.findByAlias", query = "SELECT p FROM Products p WHERE p.alias = :alias"),
    @NamedQuery(name = "Products.findByMetaDesc", query = "SELECT p FROM Products p WHERE p.metaDesc = :metaDesc"),
    @NamedQuery(name = "Products.findByMetaKey", query = "SELECT p FROM Products p WHERE p.metaKey = :metaKey"),
    @NamedQuery(name = "Products.findByUnitInStock", query = "SELECT p FROM Products p WHERE p.unitInStock = :unitInStock")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "Name")
    private String name;
    @Size(max = 255)
    @Column(name = "ShortDesc")
    private String shortDesc;
    @Size(max = 2147483647)
    @Column(name = "Description")
    private String description;
    @Column(name = "Price")
    private Integer price;
    @Column(name = "Discount")
    private Integer discount;
    @Size(max = 255)
    @Column(name = "Thumb")
    private String thumb;
    @Size(max = 255)
    @Column(name = "Video")
    private String video;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "BestSellers")
    private Boolean bestSellers;
    @Column(name = "HomeFlag")
    private Boolean homeFlag;
    @Column(name = "Active")
    private Boolean active;
    @Size(max = 2147483647)
    @Column(name = "Tags")
    private String tags;
    @Size(max = 255)
    @Column(name = "Title")
    private String title;
    @Size(max = 255)
    @Column(name = "Alias")
    private String alias;
    @Size(max = 255)
    @Column(name = "MetaDesc")
    private String metaDesc;
    @Size(max = 255)
    @Column(name = "MetaKey")
    private String metaKey;
    @Column(name = "UnitInStock")
    private Integer unitInStock;
    @JoinColumn(name = "CatID", referencedColumnName = "ID")
    @ManyToOne
    private Categories catID;
    @OneToMany(mappedBy = "productID")
    private Collection<OrderDetails> orderDetailsCollection;
    @OneToMany(mappedBy = "productID")
    private Collection<Attributes> attributesCollection;

    public Products() {
    }

    public Products(Integer id) {
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

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getBestSellers() {
        return bestSellers;
    }

    public void setBestSellers(Boolean bestSellers) {
        this.bestSellers = bestSellers;
    }

    public Boolean getHomeFlag() {
        return homeFlag;
    }

    public void setHomeFlag(Boolean homeFlag) {
        this.homeFlag = homeFlag;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
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

    public Integer getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(Integer unitInStock) {
        this.unitInStock = unitInStock;
    }

    public Categories getCatID() {
        return catID;
    }

    public void setCatID(Categories catID) {
        this.catID = catID;
    }

    @XmlTransient
    public Collection<OrderDetails> getOrderDetailsCollection() {
        return orderDetailsCollection;
    }

    public void setOrderDetailsCollection(Collection<OrderDetails> orderDetailsCollection) {
        this.orderDetailsCollection = orderDetailsCollection;
    }

    @XmlTransient
    public Collection<Attributes> getAttributesCollection() {
        return attributesCollection;
    }

    public void setAttributesCollection(Collection<Attributes> attributesCollection) {
        this.attributesCollection = attributesCollection;
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
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Products[ id=" + id + " ]";
    }
    
}
