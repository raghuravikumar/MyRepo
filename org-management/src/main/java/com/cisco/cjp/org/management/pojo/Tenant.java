package com.cisco.cjp.org.management.pojo;

public class Tenant {

    private String name;
    private String timeZone;
    private String description;
    private String licenceType;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(final String timeZone) {
        this.timeZone = timeZone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getLicenceType() {
        return licenceType;
    }

    public void setLicenceType(final String licenceType) {
        this.licenceType = licenceType;
    }

}
