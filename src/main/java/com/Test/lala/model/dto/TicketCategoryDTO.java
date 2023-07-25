package com.Test.lala.model.dto;

import com.Test.lala.model.EventU;
import com.Test.lala.model.TicketCategory;

public class TicketCategoryDTO {
    public TicketCategoryDTO() {
    }

    private Double price;
    private String descriptionEventCategory;
    private Long eventID;
    private Long idTicketCategory;

    public Long getEvent() {
        return eventID;
    }

    public void setEventID(Long event) {
        this.eventID = event;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescriptionEventCategory() {
        return descriptionEventCategory;
    }

    public void setDescriptionEventCategory(String descriptionEventCategory) {
        this.descriptionEventCategory = descriptionEventCategory;
    }


    public Long getIdTicketCategory() {
        return idTicketCategory;
    }

    public void setIdTicketCategory(Long idTicketCategory) {
        this.idTicketCategory = idTicketCategory;
    }


    public TicketCategoryDTO(TicketCategory ticketCategory) {
        this.eventID=ticketCategory.getEvent().getIdEvent();
        this.price = ticketCategory.getPrice();
        this.descriptionEventCategory = ticketCategory.getDescriptionEventCategory();
        this.idTicketCategory = ticketCategory.getIdTicketCategory();
    }





}
