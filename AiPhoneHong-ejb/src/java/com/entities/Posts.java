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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Posts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Posts.findAll", query = "SELECT p FROM Posts p"),
    @NamedQuery(name = "Posts.findById", query = "SELECT p FROM Posts p WHERE p.id = :id"),
    @NamedQuery(name = "Posts.findByTitle", query = "SELECT p FROM Posts p WHERE p.title = :title"),
    @NamedQuery(name = "Posts.findBySContents", query = "SELECT p FROM Posts p WHERE p.sContents = :sContents"),
    @NamedQuery(name = "Posts.findByContents", query = "SELECT p FROM Posts p WHERE p.contents = :contents"),
    @NamedQuery(name = "Posts.findByThumb", query = "SELECT p FROM Posts p WHERE p.thumb = :thumb"),
    @NamedQuery(name = "Posts.findByPublished", query = "SELECT p FROM Posts p WHERE p.published = :published"),
    @NamedQuery(name = "Posts.findByAlias", query = "SELECT p FROM Posts p WHERE p.alias = :alias"),
    @NamedQuery(name = "Posts.findByCreateDate", query = "SELECT p FROM Posts p WHERE p.createDate = :createDate"),
    @NamedQuery(name = "Posts.findByAuthor", query = "SELECT p FROM Posts p WHERE p.author = :author"),
    @NamedQuery(name = "Posts.findByTags", query = "SELECT p FROM Posts p WHERE p.tags = :tags"),
    @NamedQuery(name = "Posts.findByIsHot", query = "SELECT p FROM Posts p WHERE p.isHot = :isHot"),
    @NamedQuery(name = "Posts.findByIsNewFeed", query = "SELECT p FROM Posts p WHERE p.isNewFeed = :isNewFeed"),
    @NamedQuery(name = "Posts.findByMetaKey", query = "SELECT p FROM Posts p WHERE p.metaKey = :metaKey"),
    @NamedQuery(name = "Posts.findByMetaDesc", query = "SELECT p FROM Posts p WHERE p.metaDesc = :metaDesc"),
    @NamedQuery(name = "Posts.findByViews", query = "SELECT p FROM Posts p WHERE p.views = :views")})
public class Posts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "Title")
    private String title;
    @Size(max = 255)
    @Column(name = "SContents")
    private String sContents;
    @Size(max = 2147483647)
    @Column(name = "Contents")
    private String contents;
    @Size(max = 255)
    @Column(name = "Thumb")
    private String thumb;
    @Column(name = "Published")
    private Boolean published;
    @Size(max = 255)
    @Column(name = "Alias")
    private String alias;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 255)
    @Column(name = "Author")
    private String author;
    @Size(max = 2147483647)
    @Column(name = "Tags")
    private String tags;
    @Column(name = "isHot")
    private Boolean isHot;
    @Column(name = "isNewFeed")
    private Boolean isNewFeed;
    @Size(max = 255)
    @Column(name = "MetaKey")
    private String metaKey;
    @Size(max = 255)
    @Column(name = "MetaDesc")
    private String metaDesc;
    @Column(name = "Views")
    private Integer views;
    @JoinColumn(name = "AccountID", referencedColumnName = "ID")
    @ManyToOne
    private Accounts accountID;
    @JoinColumn(name = "CatID", referencedColumnName = "ID")
    @ManyToOne
    private Categories catID;

    public Posts() {
    }

    public Posts(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSContents() {
        return sContents;
    }

    public void setSContents(String sContents) {
        this.sContents = sContents;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    public Boolean getIsNewFeed() {
        return isNewFeed;
    }

    public void setIsNewFeed(Boolean isNewFeed) {
        this.isNewFeed = isNewFeed;
    }

    public String getMetaKey() {
        return metaKey;
    }

    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }

    public String getMetaDesc() {
        return metaDesc;
    }

    public void setMetaDesc(String metaDesc) {
        this.metaDesc = metaDesc;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Accounts getAccountID() {
        return accountID;
    }

    public void setAccountID(Accounts accountID) {
        this.accountID = accountID;
    }

    public Categories getCatID() {
        return catID;
    }

    public void setCatID(Categories catID) {
        this.catID = catID;
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
        if (!(object instanceof Posts)) {
            return false;
        }
        Posts other = (Posts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Posts[ id=" + id + " ]";
    }
    
}
