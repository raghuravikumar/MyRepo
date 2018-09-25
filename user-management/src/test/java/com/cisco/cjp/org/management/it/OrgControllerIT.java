package com.cisco.cjp.org.management.it;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.json.JSONException;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cisco.cjp.org.management.pojo.Organization;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
public class OrgControllerIT extends BaseIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void test1AddOrganization() {

		Organization org = new Organization("org-002", "Africa", "Cisco", "Premium");

		HttpEntity<Organization> entity = new HttpEntity<Organization>(org, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/organization"), HttpMethod.POST,
				entity, String.class);

		assertThat(response.getStatusCode().value(), is(HttpStatus.CREATED.value()));

	}

	@Test
	public void test2GetOrgById() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/organization/org-002"),
				HttpMethod.GET, entity, String.class);

		assertThat(response.getStatusCode().value(), is(HttpStatus.OK.value()));

		String expected = "{\"orgId\":\"org-002\",\"timeZone\":\"Africa\",\"description\":\"Cisco\",\"licenceType\":\"Premium\"}";

		JSONAssert.assertEquals(expected, response.getBody(), true);

	}

	@Test
	public void test3UpdateOrganization() {

		Organization org = new Organization("org-002", "Africa", "Cisco", "Standard");

		HttpEntity<Organization> entity = new HttpEntity<Organization>(org, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/organization"), HttpMethod.PUT,
				entity, String.class);

		assertThat(response.getStatusCode().value(), is(HttpStatus.OK.value()));

	}

	@Test
	public void test4FindAll() {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/organization"), HttpMethod.GET,
				entity, String.class);

		System.out.println(response.getBody());

		assertThat(response.getStatusCode().value(), is(HttpStatus.OK.value()));

	}

	@Test
	public void test5DeleteOrgById() {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/organization/org-002"),
				HttpMethod.DELETE, entity, String.class);

		assertThat(response.getStatusCode().value(), is(HttpStatus.NO_CONTENT.value()));

	}

}
