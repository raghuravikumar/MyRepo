package com.cisco.cjp.org.management.ft;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Ignore
public class OrgManagementStepDefinitions extends OrgControllerTest {

	private final Logger LOGGGER = LoggerFactory.getLogger(OrgManagementStepDefinitions.class);

	@Given("^A new organization with name as \"([^\"]*)\"$")
	public void a_new_organization_with_name_as(final String orgName) throws Exception {
		
		LOGGGER.info("Given organization name is : {}", orgName);
		
		assertThat(!orgName.isEmpty()).isTrue();
	}

	@When("^create a organization \"([^\"]*)\" with more details$")
	public void create_a_organization_with_more_details(final String orgName) throws Exception {

		ResponseEntity<String> response = addOrganization(orgName);

		assertThat(response.getStatusCode().value(), is(HttpStatus.CREATED.value()));

		LOGGGER.info("Organization is created sucessfully");
	}

	@Then("^get the organization named as \"([^\"]*)\"$")
	public void get_the_organization_named_as(String orgName) throws Exception {
		
		ResponseEntity<String> response = getOrgById(orgName);

		LOGGGER.info("Details  regarding orgName {} : {}", orgName, response.getBody());

		assertThat(response.getStatusCode().value(), is(HttpStatus.OK.value()));

		String expected = "{\"orgId\":\"org-test\",\"timeZone\":\"Africa\",\"description\":\"Cisco\",\"licenceType\":\"Premium\"}";

		JSONAssert.assertEquals(expected, response.getBody(), true);
	}

	@Then("^update the organization \"([^\"]*)\" with licence-type as \"([^\"]*)\"$")
	public void update_the_organization_with_licence_type_as(String orgName, String licenceType) throws Exception {
		
		ResponseEntity<String> response = updateOrganization(orgName, licenceType);

		LOGGGER.info("Updated org details are : {}", response.getBody());

		String expected = "{\"orgId\":\"org-test\",\"timeZone\":\"Africa\",\"description\":\"Cisco\",\"licenceType\":\"Standard\"}";

		JSONAssert.assertEquals(expected, response.getBody(), true);

		assertThat(response.getStatusCode().value(), is(HttpStatus.OK.value()));
	}

	@Then("^get all the organizations$")
	public void get_all_the_organizations() throws Exception {
		
		ResponseEntity<String> response = findAll();

		LOGGGER.info("All organization details are : {}", response.getBody());

		assertThat(response.getStatusCode().value(), is(HttpStatus.OK.value()));

		// verifying the response body is not empty
		assertTrue(!StringUtils.isEmpty(response.getBody()));

		assertThat(response.getStatusCode().value(), is(HttpStatus.OK.value()));
	}

	@Then("^delete the organization \"([^\"]*)\"$")
	public void delete_the_organization_org_test(final String orgName) throws Exception {
		
		ResponseEntity<String> response = deleteOrgById(orgName);

		LOGGGER.info("Is organization delteted sucessfully : {}", response.getStatusCodeValue());

		assertThat(response.getStatusCode().value(), is(HttpStatus.NO_CONTENT.value()));
	}
	
	//Feature 2 methods	
	
	@Given("^A new Tenant with name as \"([^\"]*)\"$")
	public void a_new_Tenant_with_name_as(final String tenantName) throws Exception {
		
		LOGGGER.info("Given tenant name is : {}", tenantName);
		
		assertThat(!tenantName.isEmpty()).isTrue();
	}

	@When("^create a Tenant \"([^\"]*)\" with more details$")
	public void create_a_Tenant_with_more_details(final String tenantName) throws Exception {

		ResponseEntity<String> response = addOrganization(tenantName);

		assertThat(response.getStatusCode().value(), is(HttpStatus.CREATED.value()));

		LOGGGER.info("Tenant is created sucessfully");
	}

	@Then("^get the Tenant named as \"([^\"]*)\"$")
	public void get_the_Tenant_named_as(String tenantName) throws Exception {
		
		ResponseEntity<String> response = getOrgById(tenantName);

		LOGGGER.info("Details regarding tenantName {} : {}", tenantName, response.getBody());

		assertThat(response.getStatusCode().value(), is(HttpStatus.OK.value()));

		String expected = "{\"orgId\":\"transera\",\"timeZone\":\"Africa\",\"description\":\"Cisco\",\"licenceType\":\"Premium\"}";

		JSONAssert.assertEquals(expected, response.getBody(), true);
	}
	
	@Then("^delete the Tenant \"([^\"]*)\"$")
	public void delete_the_Tenant_org_test(final String tenantName) throws Exception {
		
		ResponseEntity<String> response = deleteOrgById(tenantName);

		LOGGGER.info("Is tenant delteted sucessfully : {}", response.getStatusCodeValue());

		assertThat(response.getStatusCode().value(), is(HttpStatus.NO_CONTENT.value()));
	}

}
