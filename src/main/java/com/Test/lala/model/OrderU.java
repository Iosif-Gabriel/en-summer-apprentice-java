package com.Test.lala.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="OrderU")
public class OrderU implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idOrder",nullable = false)
    private Long idOrder;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private UserU user;

    @ManyToOne
    @JoinColumn(name = "idTicketCategory", nullable = false)
    private TicketCategory ticketCategory;

    @Column(name = "orderedAt",nullable = false)
    private Date orderedAt;

    @Column(name="numberOfTickets",nullable = false)
    private int numberOfTickets;

    @Column(name="totalPrice",nullable = false)
    private int totalPrice;

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public UserU getUser() {
        return user;
    }

    public void setUser(UserU user) {
        this.user = user;
    }

    public TicketCategory getTicketCategory() {
        return ticketCategory;
    }

    public void setTicketCategory(TicketCategory ticketCategory) {
        this.ticketCategory = ticketCategory;
    }

    public Date getOrderedAt() {
        return orderedAt;
    }

    public void setOrderedAt(Date orderedAt) {
        this.orderedAt = orderedAt;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderU() {
    }

    public OrderU(Long idOrder, UserU user, TicketCategory ticketCategory, Date orderedAt, int numberOfTickets, int totalPrice) {
        this.idOrder = idOrder;
        this.user = user;
        this.ticketCategory = ticketCategory;
        this.orderedAt = orderedAt;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderU{" +
                "idOrder=" + idOrder +
                ", user=" + user +
                ", ticketCategory=" + ticketCategory +
                ", orderedAt=" + orderedAt +
                ", numberOfTickets=" + numberOfTickets +
                ", totalPrice=" + totalPrice +
                '}';
    }


}
