package com.johnson.hb_backend.controller;

import com.johnson.hb_backend.model.ResourceEntity;
import com.johnson.hb_backend.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {

	private final ResourceService resourceService;

	@Autowired
	public ResourceController(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	@GetMapping("/all")
	public List<ResourceEntity> getAllResource() {
		return resourceService.getAllResource();
	}
}
