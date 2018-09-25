package com.cisco.cjp.org.management.repository;

import com.cisco.cjp.org.management.pojo.Organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgRepository extends JpaRepository<Organization, String> {

}
