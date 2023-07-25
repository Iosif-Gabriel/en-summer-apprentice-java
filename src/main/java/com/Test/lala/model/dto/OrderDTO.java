package com.Test.lala.model.dto;

import com.Test.lala.model.TicketCategory;
import com.Test.lala.model.UserU;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;
import java.util.Date;

@JsonSerialize
public class OrderDTO {
    public OrderDTO() {
    }
    private Long ticketCategoryID;
    private Date orderedAt;
    private int numberOfTickets;
    private double totalPrice;
    private Long idEvent;

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }


    public Long getTicketCategoryID() {
        return ticketCategoryID;
    }

    public void setTicketCategoryID(Long ticketCategory) {
        this.ticketCategoryID = ticketCategory;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
