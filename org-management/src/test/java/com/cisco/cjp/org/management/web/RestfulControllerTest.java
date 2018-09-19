package com.cisco.cjp.org.management.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import com.cisco.cjp.org.management.pojo.Tenant;
import com.cisco.cjp.org.management.service.RestfulService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = RestfulController.class)
public class RestfulControllerTest {

	@Mock
	private HttpServletRequest request;

	@Mock
	private Model model;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RestfulService service;

// 	@Test
// 	public void shouldReturnTenant() throws Exception {
// 		Tenant tenant = new Tenant();
// 		tenant.setName("Cisco");
// 		tenant.setTimeZone("Asia/Calcutta");
// 		tenant.setDescription("Cisco tenant");
// 		tenant.setLicenceType("Standard");
// 		given(service.getTenantDetails()).willReturn(tenant);
// 		mockMvc.perform(get("/test/retrieve")).andExpect(status().is2xxSuccessful());
// 	}

// 	@Test
// 	public void shouldReturnTenantCreatedSuccess() throws Exception {
// 		mockMvc.perform(post("/test/create/test")).andExpect(jsonPath("$.status", is(200)))
// 				.andExpect(jsonPath("$.message", is("Tenant created sucessfully")))
// 				.andExpect(status().is2xxSuccessful());
// 	}

// 	@Test
// 	public void shouldReturnTenantUpdatedSuccess() throws Exception {
// 		mockMvc.perform(put("/test/update/test")).andExpect(jsonPath("$.status", is(200)))
// 				.andExpect(jsonPath("$.message", is("Tenant updated sucessfully with test")))
// 				.andExpect(status().is2xxSuccessful());
// 	}

// 	@Test
// 	public void shouldReturnTenantDeletedSuccess() throws Exception {
// 		mockMvc.perform(delete("/test/delete")).andExpect(content().string("Tenant deleted sucessfully"))
// 				.andExpect(status().is2xxSuccessful());
// 	}

}
