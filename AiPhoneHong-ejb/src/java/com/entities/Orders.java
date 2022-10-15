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
@Table(name = "Orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.findById", query = "SELECT o FROM Orders o WHERE o.id = :id"),
    @NamedQuery(name = "Orders.findByOrderDate", query = "SELECT o FROM Orders o WHERE o.orderDate = :orderDate"),
    @NamedQuery(name = "Orders.findByShipDate", query = "SELECT o FROM Orders o WHERE o.shipDate = :shipDate"),
    @NamedQuery(name = "Orders.findByDeleted", query = "SELECT o FROM Orders o WHERE o.deleted = :deleted"),
    @NamedQuery(name = "Orders.findByPaid", query = "SELECT o FROM Orders o WHERE o.paid = :paid"),
    @NamedQuery(name = "Orders.findByPaymentDate", query = "SELECT o FROM Orders o WHERE o.paymentDate = :paymentDate"),
    @NamedQuery(name = "Orders.findByPaymentID", query = "SELECT o FROM Orders o WHERE o.paymentID = :paymentID"),
    @NamedQuery(name = "Orders.findByIsConfirmed", query = "SELECT o FROM Orders o WHERE o.isConfirmed = :isConfirmed"),
    @NamedQuery(name = "Orders.findByShippingAddress", query = "SELECT o FROM Orders o WHERE o.shippingAddress = :shippingAddress"),
    @NamedQuery(name = "Orders.findByTotal", query = "SELECT o FROM Orders o WHERE o.total = :total"),
    @NamedQuery(name = "Orders.findByNote", query = "SELECT o FROM Orders o WHERE o.note = :note")})
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "OrderDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name = "ShipDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipDate;
    @Column(name = "Deleted")
    private Boolean deleted;
    @Column(name = "Paid")
    private Boolean paid;
    @Column(name = "PaymentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;
    @Column(name = "PaymentID")
    private Integer paymentID;
    @Column(name = "isConfirmed")
    private Boolean isConfirmed;
    @Size(max = 255)
    @Column(name = "ShippingAddress")
    private String shippingAddress;
    @Column(name = "Total")
    private Integer total;
    @Size(max = 2147483647)
    @Column(name = "Note")
    private String note;
    @JoinColumn(name = "CustomerID", referencedColumnName = "ID")
    @ManyToOne
    private Customers customerID;
    @JoinColumn(name = "TransactStatusID", referencedColumnName = "ID")
    @ManyToOne
    private TransactionStatus transactStatusID;
    @OneToMany(mappedBy = "orderID")
    private Collection<OrderDetails> orderDetailsCollection;

    public Orders() {
    }

    public Orders(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Integer getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public Boolean getIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(Boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Customers getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Customers customerID) {
        this.customerID = customerID;
    }

    public TransactionStatus getTransactStatusID() {
        return transactStatusID;
    }

    public void setTransactStatusID(TransactionStatus transactStatusID) {
        this.transactStatusID = transactStatusID;
    }

    @XmlTransient
    public Collection<OrderDetails> getOrderDetailsCollection() {
        return orderDetailsCollection;
    }

    public void setOrderDetailsCollection(Collection<OrderDetails> orderDetailsCollection) {
        this.orderDetailsCollection = orderDetailsCollection;
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
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Orders[ id=" + id + " ]";
    }
    
}
