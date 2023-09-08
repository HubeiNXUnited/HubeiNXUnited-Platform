package com.johnson.hb_backend.service;

import com.johnson.hb_backend.model.ResourceEntity;
import com.johnson.hb_backend.repository.ResourceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

	private final ResourceListRepository resourceListRepository;

	@Autowired
	public ResourceService(ResourceListRepository resourceListRepository) {
		this.resourceListRepository = resourceListRepository;
	}

	public List<ResourceEntity> getAllResource() {
		return resourceListRepository.findAll();
	}
}
