package com.cisco.cjp.org.management.it;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BaseIntegrationTest {

	public static final String IP_ADDRESS = "http://localhost:";

	@LocalServerPort
	private int port;

	public String createURLWithPort(String uri) {
		return IP_ADDRESS + port + uri;
	}
}
