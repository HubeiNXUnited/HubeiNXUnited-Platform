package com.johnson.hb_backend.repository;

import com.johnson.hb_backend.model.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersEntityRepository extends JpaRepository<UsersEntity, Long> {
}
