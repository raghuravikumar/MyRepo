
// package com.cisco.cjp.org.management.web;

// import java.util.List;

// import javax.validation.Valid;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.cisco.cjp.org.management.exception.OrgExceptionResponse;
// import com.cisco.cjp.org.management.pojo.Organization;
// import com.cisco.cjp.org.management.service.OrgService;

// import io.swagger.annotations.ApiOperation;
// import io.swagger.annotations.ApiResponse;
// import io.swagger.annotations.ApiResponses;

// @RestController
// @RequestMapping("organization")
// public class OrgController {

// 	@Autowired
// 	OrgService orgService;

// 	@ApiOperation(value = "Get Organization By Id")
// 	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Organization Info.", response=Organization.class),
// 			@ApiResponse(code = 404, message = "Organization is not found", response=OrgExceptionResponse.class),
// 			@ApiResponse(code = 500, message = "Internal server error", response=OrgExceptionResponse.class) })
// 	@GetMapping("/{id}")
// 	public ResponseEntity<Organization> getOrgById(@PathVariable("id") String id) {
// 		Organization org = orgService.findOrgById(id);
// 		return new ResponseEntity<Organization>(org, HttpStatus.OK);
// 	}

// 	@ApiOperation(value = "Add new Organization")
// 	@ApiResponses(value = { @ApiResponse(code = 201, message = "Successfully created new Organization", response=Organization.class),
// 			@ApiResponse(code = 500, message = "Internal server error", response=OrgExceptionResponse.class) })
// 	@PostMapping()
// 	public ResponseEntity<Organization> addOrganization(@Valid @RequestBody Organization org) {
// 	    Organization newOrg = orgService.addOrganization(org);
// 		return new ResponseEntity<Organization>(newOrg, HttpStatus.CREATED);
// 	}

// 	@ApiOperation(value = "Update Organization")
// 	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated the Organization", response=Organization.class),
// 			@ApiResponse(code = 500, message = "Internal server error", response=OrgExceptionResponse.class) })
// 	@PutMapping()
// 	public ResponseEntity<Organization> updateOrganization(@RequestBody Organization org) {
// 	    Organization newOrg = orgService.updateOrganization(org);
// 		return new ResponseEntity<Organization>(newOrg, HttpStatus.OK);
// 	}

// 	@ApiOperation(value = "Delete Organization")
// 	@ApiResponses(value = { @ApiResponse(code = 204, message = "Successfully deleted the Organization"),
// 			@ApiResponse(code = 404, message = "Organization is not found", response=OrgExceptionResponse.class),
// 			@ApiResponse(code = 500, message = "Internal server error", response=OrgExceptionResponse.class) })
// 	@DeleteMapping("/{id}")
// 	public ResponseEntity<Void> deleteOrgById(@PathVariable("id") String id) {
// 		orgService.deleteOrganization(id);
// 		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
// 	}
	
// 	@ApiOperation(value = "Get All Organizations")
//     @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved Organizations.", response=Organization.class),
//             @ApiResponse(code = 500, message = "Internal server error", response=OrgExceptionResponse.class) })
// 	@GetMapping()
//     public ResponseEntity<List<Organization>> findAll() {
//         return new ResponseEntity<List<Organization>>(orgService.getAllOrganizations(), HttpStatus.OK);
//     }

// }
