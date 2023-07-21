package com.Test.lala.repository;

import com.Test.lala.model.UserU;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserU,Long> {

    UserU findUserUByIdUser(Long idUser);
}
