package com.cisco.cjp.org.management.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.cjp.org.management.exception.OrgNotFoundException;
import com.cisco.cjp.org.management.pojo.Organization;
import com.cisco.cjp.org.management.repository.OrgRepository;

@Service
public class OrgServiceImpl implements OrgService {

    private static final Logger LOG = LoggerFactory.getLogger(OrgServiceImpl.class);

    @Autowired
    private OrgRepository orgRepository;

    @Override
    public Organization findOrgById(String orgId) {
        Optional<Organization> result = orgRepository.findById(orgId);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new OrgNotFoundException("Org not found: " + orgId);
        }

    }

    @Override
    public List<Organization> getAllOrganizations() {
        return orgRepository.findAll();
    }

    @Override
    public Organization addOrganization(Organization org) {
        return orgRepository.save(org);
    }

    @Override
    public Organization updateOrganization(Organization org) {
        return orgRepository.save(org);
    }

    @Override
    public void deleteOrganization(String orgId) {
        Organization org = findOrgById(orgId);
        orgRepository.delete(org);
    }

}
