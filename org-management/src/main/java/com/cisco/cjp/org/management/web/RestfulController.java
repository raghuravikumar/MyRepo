package com.cisco.cjp.org.management.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.cjp.org.management.pojo.ResultInfo;
import com.cisco.cjp.org.management.pojo.Tenant;
import com.cisco.cjp.org.management.service.RestfulService;

@RestController
@RequestMapping("/test")
public class RestfulController {

	@Autowired
	RestfulService service;

	@GetMapping("/retrieve")
	public Tenant retrieve(final Model model, final HttpServletRequest request) {
		return service.getTenantDetails();
	}

	@PostMapping("/create/{name}")
	public ResultInfo<List<Map<String, String>>> create(@PathVariable("name") final String name, final Model model,
			final HttpServletRequest request) {
		final ResultInfo<List<Map<String, String>>> response = new ResultInfo<>();
		response.setStatus(200);
		response.setMessage("Tenant created sucessfully");
		return response;
	}

	@PutMapping("/update/{name}")
	public ResultInfo<List<Map<String, String>>> update(@PathVariable("name") final String name, final Model model,
			final HttpServletRequest request) {
		final ResultInfo<List<Map<String, String>>> response = new ResultInfo<>();
		response.setStatus(200);
		response.setMessage(String.format("%s%s", "Tenant updated sucessfully with ", name));
		return response;
	}

	@DeleteMapping("/delete")
	public String delete(final Model model, final HttpServletRequest request) {
		return "Tenant deleted sucessfully";
	}

}
