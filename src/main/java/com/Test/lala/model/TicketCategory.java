package com.Test.lala.model;

import jakarta.persistence.*;

@Entity
@Table(name="TicketCategory")
public class TicketCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idTicketCategory",nullable = false)
    private Long idTicketCategory;

    @ManyToOne
    @JoinColumn(name = "idEvent", nullable = false)
    private EventU event;

    @Column(name = "descriptionEventCategory", nullable = false)
    private String descriptionEventCategory;

    @Column(name = "price", nullable = false)
    private Double price;

    public Long getIdTicketCategory() {
        return idTicketCategory;
    }

    public void setIdTicketCategory(Long idTicketCategory) {
        this.idTicketCategory = idTicketCategory;
    }


    public String getDescriptionEventCategory() {
        return descriptionEventCategory;
    }

    public void setDescriptionEventCategory(String descriptionEventCategory) {
        this.descriptionEventCategory = descriptionEventCategory;
    }

    public TicketCategory() {

    }

    public TicketCategory(Long idTicketCategory, EventU event, String descriptionEventCategory, Double price) {
        this.idTicketCategory = idTicketCategory;
        this.event = event;
        this.descriptionEventCategory = descriptionEventCategory;
        this.price = price;
    }
}
