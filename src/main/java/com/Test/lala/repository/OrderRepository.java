package com.Test.lala.repository;

import com.Test.lala.model.OrderU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends JpaRepository<OrderU,Long> {
}
