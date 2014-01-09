package com.tmg.fuse.poc;


import javax.ws.rs.core.Response;

import org.apache.camel.EndpointInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.tmg.fuse.poc.account.legacy.AccountDetails;
import com.tmg.fuse.poc.account.AccountDetails;


public class CamelContextXmlTest extends CamelSpringTestSupport {
	
	private final static String ENDPOINT_ADDRESS = "http://localhost:9090/route";

	// Mock endpoints used to consume messages from the output endpoints and then perform assertions
	@EndpointInject(uri = "mock:output")
	protected MockEndpoint outputEndpoint;
	
    
	@Test
	public void testGetAccount() throws Exception {
		
		// Add an interceptor to catch the response back to the mock client
		// Unmarshall the JSON and pass on to the mock endpoint
		RouteDefinition route = context.getRouteDefinitions().get(0);          
		route.adviceWith(context, new RouteBuilder() {              
			public void configure() throws Exception {             
				interceptSendToEndpoint("mock:client")
				.to("log:input")
				//.unmarshal("legacyAccountDetailsFormat")
				.unmarshal("accountDetailsFormat")
				.to(outputEndpoint);        
				}     
			});
		
		// Call the REST endpoint
		WebClient client = WebClient.create(ENDPOINT_ADDRESS);
		client.accept("application/json");
		client.path("/accountservice/account/1234");
		Response r = client.get();
		
		// Retrieve the message body and cast to AccountDetails
		AccountDetails a = (AccountDetails)outputEndpoint.getExchanges().get(0).getIn().getBody();
		
		// Assert the values of the obect
		assertEquals("Birmingham", a.getCity());
		assertEquals("UK", a.getCountry());
		assertEquals("100", a.getTSNumber());
		
	}
	
	

	@Override
	protected ClassPathXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext(
				"META-INF/spring/camel-context.xml");
	}

}
