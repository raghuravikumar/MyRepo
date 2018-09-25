package com.cisco.cjp.org.management.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.cisco.cjp.org.management.exception.OrgNotFoundException;
import com.cisco.cjp.org.management.pojo.Organization;
import com.cisco.cjp.org.management.repository.OrgRepository;

@RunWith(MockitoJUnitRunner.class)
public class OrgServiceImplTest {

    @Mock
    OrgRepository orgRepository;

    @InjectMocks
    OrgServiceImpl orgServiceImpl;

    private Organization mockOrg;
    private Optional<Organization> optionalOrg;
    private List<Organization> list;

    @Before
    public void init() {
        mockOrg = new Organization("org-001", "Asia", "test org", "standered");
        optionalOrg = Optional.of((Organization) mockOrg);
        list = new ArrayList<Organization>();
        list.add(mockOrg);
    }

    @Test
    public void getAllOrganizationsTest() {
        when(orgRepository.findAll()).thenReturn(list);
        List<Organization> newList = orgServiceImpl.getAllOrganizations();
        verify(orgRepository).findAll();
        assertThat(newList.size(), is(list.size()));
    }

    @Test
    public void addOrganizationTest() {
        when(orgRepository.save(Mockito.any(Organization.class))).thenReturn(mockOrg);
        Organization org = orgServiceImpl.addOrganization(mockOrg);
        verify(orgRepository).save(Mockito.any(Organization.class));
        assertThat(org.getOrgId(), is(mockOrg.getOrgId()));
        assertThat(org.getLicenceType(), is(mockOrg.getLicenceType()));
    }

    @Test
    public void updateOrganizationTest() {
        when(orgRepository.save(Mockito.any(Organization.class))).thenReturn(mockOrg);
        Organization org = orgServiceImpl.updateOrganization(mockOrg);
        verify(orgRepository).save(Mockito.any(Organization.class));
        assertThat(org.getOrgId(), is(mockOrg.getOrgId()));
        assertThat(org.getLicenceType(), is(mockOrg.getLicenceType()));
    }

    @Test(expected = OrgNotFoundException.class)
    public void findOrgByIdTestWithException() {
        when(orgRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());
        when(orgServiceImpl.findOrgById(Mockito.anyString())).thenThrow(new OrgNotFoundException("Org not found: org-001"));
        verify(orgRepository).findById(Mockito.anyString());
        verify(orgServiceImpl).findOrgById(Mockito.anyString());
        doThrow(OrgNotFoundException.class).when(orgServiceImpl).findOrgById(Mockito.anyString());
    }

    @Test
    public void deleteOrganizationTest() {
        when(orgRepository.findById(Mockito.anyString())).thenReturn(optionalOrg);
        Organization org = orgServiceImpl.findOrgById(Mockito.anyString());
        doNothing().doThrow(new RuntimeException()).when(orgRepository).delete(Mockito.any(Organization.class));
        orgServiceImpl.deleteOrganization(mockOrg.getOrgId());
        verify(orgRepository, times(2)).findById(Mockito.anyString());
        verify(orgRepository).delete(Mockito.any(Organization.class));
        assertThat(org.getOrgId(), is(mockOrg.getOrgId()));
        assertThat(org.getLicenceType(), is(mockOrg.getLicenceType()));
    }

}
