package com.cisco.cjp.org.management.service;

import org.springframework.stereotype.Service;

import com.cisco.cjp.org.management.pojo.Tenant;

@Service
public class RestfulService {

    public Tenant getTenantDetails() {

        final Tenant tenant = new Tenant();
        tenant.setName("Cisco");
        tenant.setDescription("Cisco tenant");
        tenant.setTimeZone("Asia/Calcutta");
        tenant.setLicenceType("Standard");

        return tenant;

    }

}
