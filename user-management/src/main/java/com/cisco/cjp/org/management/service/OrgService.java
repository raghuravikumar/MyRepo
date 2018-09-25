package com.cisco.cjp.org.management.service;

import java.util.List;

import com.cisco.cjp.org.management.pojo.Organization;

public interface OrgService {

	Organization findOrgById(String orgId);

	List<Organization> getAllOrganizations();

	Organization addOrganization(Organization org);

	Organization updateOrganization(Organization org);

	void deleteOrganization(String orgId);

}