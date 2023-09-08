package com.johnson.hb_backend.repository;

import com.johnson.hb_backend.model.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberEntityRepository extends JpaRepository<MemberEntity, Long> {
}
