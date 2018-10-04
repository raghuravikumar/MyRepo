package com.cisco.cjp.org.management.pojo;

public class Organization {

	private String orgId;
	private String timeZone;
	private String description;
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

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLicenceType() {
		return licenceType;
	}

	public void setLicenceType(String licenceType) {
		this.licenceType = licenceType;
	}

	@Override
	public String toString() {
		return "Organization [orgId=" + orgId + ", timeZone=" + timeZone + ", description=" + description
				+ ", licenceType=" + licenceType + "]";
	}

}
