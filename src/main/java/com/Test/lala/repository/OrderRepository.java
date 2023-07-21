package com.Test.lala.repository;

import com.Test.lala.model.OrderU;
import com.Test.lala.model.UserU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderU,Long> {

    List<OrderU> findByUser_IdUser(Long userId);

}
