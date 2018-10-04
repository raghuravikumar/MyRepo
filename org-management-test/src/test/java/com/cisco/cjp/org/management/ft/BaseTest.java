package com.cisco.cjp.org.management.ft;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BaseTest {

	@Value("${app.host}")
	protected String host;

	@Value("${app.port}")
	protected String port;

}
