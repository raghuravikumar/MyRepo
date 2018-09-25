package com.cisco.cjp.org.management.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Organization")
public class Organization {

	@NotNull
	@Size(min = 5, message = "orgId should have atleast 5 characters")
    private String orgId;
	
    private String timeZone;
    private String description;
    
    @Size(min = 2, message = "licenceType should have atleast 2 characters")
    private String licenceType;

    public Organization() {

    }

    public Organization(String orgId, String timeZone, String description, String licenceType) {
        super();
        this.orgId = orgId;
        this.timeZone = timeZone;
        this.description = description;
        this.licenceType = licenceType;
    }

    @Id
    @Column(name = "orgId")
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Column(name = "timeZone")
    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "licenceType")
    public String getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
    }

    @Override
    public String toString() {
        return "Organization [orgId=" + orgId + ", timeZone=" + timeZone + ", description=" + description + ", licenceType="
                + licenceType + "]";
    }

}
