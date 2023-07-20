package com.Test.lala.repository;

import com.Test.lala.model.EventU;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventU,Long> {
}
