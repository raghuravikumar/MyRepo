@one
Feature: Manage CRUD operations for organization

  Scenario: CRUD operations for ORG-MANAGGEMENT	
    Given A new organization with name as "org-test"
    When create a organization "org-test" with more details
    Then get the organization named as "org-test"
    Then  update the organization "org-test" with licence-type as "Standard"  
	Then get all the organizations
	Then delete the organization "org-test"