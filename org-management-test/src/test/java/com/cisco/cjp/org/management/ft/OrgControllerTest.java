package com.cisco.cjp.org.management.ft;

import org.json.JSONException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cisco.cjp.org.management.pojo.Organization;

@RunWith(SpringRunner.class)
public abstract class OrgControllerTest extends BaseTest {

	private TestRestTemplate restTemplate = new TestRestTemplate();
	private HttpHeaders headers = new HttpHeaders();

	public ResponseEntity<String> addOrganization(final String orgName) {

		Organization org = new Organization(orgName, "Africa", "Cisco", "Premium");

		HttpEntity<Organization> entity = new HttpEntity<Organization>(org, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				String.format("%s%s", String.format("%s%s%s", host, ":", port), "/organization"), HttpMethod.POST,
				entity, String.class);

		return response;

	}

	public ResponseEntity<String> getOrgById(final String orgName) throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				String.format("%s%s%s", String.format("%s%s%s", host, ":", port), "/organization/", orgName),
				HttpMethod.GET, entity, String.class);

		return response;

	}

	public ResponseEntity<String> updateOrganization(final String orgName, final String licenceType)
			throws JSONException {

		Organization org = new Organization(orgName, "Africa", "Cisco", licenceType);

		HttpEntity<Organization> entity = new HttpEntity<Organization>(org, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				String.format("%s%s", String.format("%s%s%s", host, ":", port), "/organization"), HttpMethod.PUT,
				entity, String.class);

		return response;

	}

	public ResponseEntity<String> findAll() {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				String.format("%s%s", String.format("%s%s%s", host, ":", port), "/organization"), HttpMethod.GET,
				entity, String.class);

		return response;

	}

	public ResponseEntity<String> deleteOrgById(final String orgName) {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				String.format("%s%s%s", String.format("%s%s%s", host, ":", port), "/organization/", orgName),
				HttpMethod.DELETE, entity, String.class);
		return response;

	}

}
