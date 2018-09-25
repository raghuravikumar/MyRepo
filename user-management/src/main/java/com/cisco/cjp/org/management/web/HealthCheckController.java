package com.cisco.cjp.org.management.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HealthCheckController {

	@ApiOperation(value = "Health info for Org-Service")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Successfully retrieved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource") 
		}
	)
	@GetMapping("/admin/api/v1/ping")
	public String ping() {

		ObjectMapper mapper = new ObjectMapper();

		ObjectNode node = mapper.createObjectNode();
		node.put("serviceName", "org-management");
		node.put("serviceType", "REQUIRED");
		node.put("serviceState", "online");
		node.put("message", "Healthy");

		return node.toString();
	}

}
