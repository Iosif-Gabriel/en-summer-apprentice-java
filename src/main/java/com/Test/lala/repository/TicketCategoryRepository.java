package com.Test.lala.repository;

import com.Test.lala.model.TicketCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketCategoryRepository extends JpaRepository<TicketCategory,Long> {

    TicketCategory findByidTicketCategory(Long ticketCategoryId);
}
