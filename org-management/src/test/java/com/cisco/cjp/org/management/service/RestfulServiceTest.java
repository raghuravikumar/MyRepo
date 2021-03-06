package com.cisco.cjp.org.management.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cisco.cjp.org.management.pojo.Tenant;

@RunWith(SpringRunner.class)
public class RestfulServiceTest {

	private RestfulService service;

	@Before
	public void setUp() throws Exception {
		service = new RestfulService();
	}

	@Test
	public void shouldReturnTenant() {
		Tenant tenant = service.getTenantDetails();
		assertThat(tenant.getName(), is("Cisco"));
	}
	
	public void dummyMethod1() {
		//TODO
	}
	public void dummyMethod2() {
		//TODO
	}

}
