package com.cisco.cjp.org.management.web;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.cisco.cjp.org.management.exception.OrgNotFoundException;
import com.cisco.cjp.org.management.pojo.Organization;
import com.cisco.cjp.org.management.service.OrgService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = OrgController.class)
public class OrgControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrgService orgService;

    private Organization mockOrg;
    private String expected;
    private List<Organization> list;

    @Before
    public void init() {
        mockOrg = new Organization("org-001", "Asia", "test org", "standered");
        expected = "{\"orgId\":\"org-001\",\"timeZone\":\"Asia\",\"description\":\"test org\",\"licenceType\":\"standered\"}";
        list = new ArrayList<Organization>();
        list.add(mockOrg);
    }

    @Test
    public void getOrgByIdTest() throws Exception {

        when(orgService.findOrgById(Mockito.anyString())).thenReturn(mockOrg);

        mockMvc.perform(get("/organization/org-001").accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.orgId").value("org-001")).andExpect(jsonPath("$.timeZone").value("Asia"))
                .andExpect(jsonPath("$.description").value("test org")).andExpect(jsonPath("$.licenceType").value("standered"));
        verify(orgService).findOrgById(Mockito.anyString());

    }

    @Test
    public void getOrgByIdTestWithOrgNotFoundException() throws Exception {

        when(orgService.findOrgById(Mockito.anyString())).thenThrow(new OrgNotFoundException("Organization is not found"));

        mockMvc.perform(get("/organization/123").accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Organization is not found"));
        verify(orgService).findOrgById(Mockito.anyString());

    }

    @Test
    public void getOrgByIdTestWithException() throws Exception {

        when(orgService.findOrgById(Mockito.anyString())).thenThrow(new RuntimeException("Internal server error"));

        mockMvc.perform(get("/organization/error").accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.message").value("Internal server error"));
        verify(orgService).findOrgById(Mockito.anyString());
    }

    @Test
    public void addOrganizationTest() throws Exception {

        when(orgService.addOrganization(Mockito.any(Organization.class))).thenReturn(mockOrg);

        mockMvc.perform(post("/organization").contentType(MediaType.APPLICATION_JSON).content(expected)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
                .andExpect(jsonPath("$.orgId").value("org-001")).andExpect(jsonPath("$.timeZone").value("Asia"))
                .andExpect(jsonPath("$.description").value("test org")).andExpect(jsonPath("$.licenceType").value("standered"));
        verify(orgService).addOrganization(Mockito.any(Organization.class));
    }


    @Test
    public void addOrganizationTestWithException() throws Exception {

        when(orgService.addOrganization(Mockito.any(Organization.class)))
                .thenThrow(new RuntimeException("Internal server error"));

        mockMvc.perform(post("/organization").contentType(MediaType.APPLICATION_JSON).content(expected)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.message").value("Internal server error"));
        verify(orgService).addOrganization(Mockito.any(Organization.class));

    }

    @Test
    public void updateOrganizationTest() throws Exception {

        when(orgService.updateOrganization(Mockito.any(Organization.class))).thenReturn(mockOrg);

        mockMvc.perform(
                put("/organization").contentType(MediaType.APPLICATION_JSON).content(expected).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.orgId").value("org-001"))
                .andExpect(jsonPath("$.timeZone").value("Asia")).andExpect(jsonPath("$.description").value("test org"))
                .andExpect(jsonPath("$.licenceType").value("standered"));
        verify(orgService).updateOrganization(Mockito.any(Organization.class));

    }

    @Test
    public void updateOrganizationTestWithException() throws Exception {

        when(orgService.updateOrganization(Mockito.any(Organization.class)))
                .thenThrow(new RuntimeException("Internal server error"));

        mockMvc.perform(
                put("/organization").contentType(MediaType.APPLICATION_JSON).content(expected).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError()).andExpect(jsonPath("$.message").value("Internal server error"));
        verify(orgService).updateOrganization(Mockito.any(Organization.class));

    }

    @Test
    public void deleteOrgByIdTest() throws Exception {

        doNothing().when(orgService).deleteOrganization(Mockito.anyString());

        mockMvc.perform(delete("/organization/org-001").accept(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
        verify(orgService).deleteOrganization(Mockito.anyString());

    }

    @Test
    public void deleteOrgByIdTestWithOrgNotFoundException() throws Exception {

        doThrow(new OrgNotFoundException("Organization is not found")).when(orgService).deleteOrganization(Mockito.anyString());

        mockMvc.perform(delete("/organization/org-001").accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Organization is not found"));
        verify(orgService).deleteOrganization(Mockito.anyString());

    }

    @Test
    public void deleteOrgByIdTestWithException() throws Exception {

        doThrow(new RuntimeException("Internal server error")).when(orgService).deleteOrganization(Mockito.anyString());

        mockMvc.perform(delete("/organization/org-001").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError()).andExpect(jsonPath("$.message").value("Internal server error"));
        verify(orgService).deleteOrganization(Mockito.anyString());

    }

    @Test
    public void findAllTest() throws Exception {

        when(orgService.getAllOrganizations()).thenReturn(list);

        mockMvc.perform(get("/organization").accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].orgId").value("org-001")).andExpect(jsonPath("$[0].timeZone").value("Asia"))
                .andExpect(jsonPath("$[0].description").value("test org"))
                .andExpect(jsonPath("$[0].licenceType").value("standered"));
        verify(orgService).getAllOrganizations();

    }

    @Test
    public void findAllTestWithException() throws Exception {

        when(orgService.getAllOrganizations()).thenThrow(new RuntimeException("Internal server error"));

        mockMvc.perform(get("/organization").accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.message").value("Internal server error"));
        verify(orgService).getAllOrganizations();

    }

}
