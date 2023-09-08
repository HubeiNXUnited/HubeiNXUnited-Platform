package com.johnson.hb_backend.repository;

import com.johnson.hb_backend.model.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceListRepository extends JpaRepository<ResourceEntity, Long> {
}
