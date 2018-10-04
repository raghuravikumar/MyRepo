@two
Feature: Manage CD operations for TENANT

  Scenario: CD operations for TENANT	
    Given A new Tenant with name as "transera"
    When create a Tenant "transera" with more details
    Then get the Tenant named as "transera"
	Then delete the Tenant "transera"