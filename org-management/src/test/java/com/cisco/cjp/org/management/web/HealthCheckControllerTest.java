// package com.cisco.cjp.org.management.web;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.web.servlet.MockMvc;

// @RunWith(SpringRunner.class)
// @WebMvcTest(controllers = HealthCheckController.class)
// public class HealthCheckControllerTest {

// 	@Autowired
// 	private MockMvc mockMvc;
	
// 	@Test
// 	public void shouldReturnPingApiResponseAsString() throws Exception{
// 		mockMvc.perform(get("/admin/api/v1/ping")).andExpect(status().is2xxSuccessful());
// 	}

// }
