package com.tmg.fuse.poc;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.*;


public class AccountProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		exchange.getOut().setBody("<html><b>Processing your account now!</b></html>");
		
		Message inMessage = exchange.getIn();                        
        
		// Get the operation name from in message
        String operationName = inMessage.getHeader(CxfConstants.OPERATION_NAME, String.class);
        System.out.println("Operation name is " + operationName);
        
        
        if ("retrieveAccount".equals(operationName)) {
            String httpMethod = inMessage.getHeader(Exchange.HTTP_METHOD, String.class);
            
            String path = inMessage.getHeader(Exchange.HTTP_PATH, String.class);
            // The parameter of the invocation is stored in the body of in message
            String id = inMessage.getBody(String.class);
            System.out.println("ID to retrieve is " + id);
            
            exchange.getOut().setBody("select xrefId from account where id = " + id);
            
       
        }
        
        
        if ("createAccount".equals(operationName)) {
            //assertEquals("Get a wrong customer message header", "header1;header2", inMessage.getHeader("test"));
            String httpMethod = inMessage.getHeader(Exchange.HTTP_METHOD, String.class);
            //assertEquals("Get a wrong http method", "PUT", httpMethod);
            //Customer customer = inMessage.getBody(Customer.class);
            //assertNotNull("The customer should not be null.", customer);
            // Now you can do what you want on the customer object
            //assertEquals("Get a wrong customer name.", "Mary", customer.getName());
            // set the response back
            //exchange.getOut().setBody(Response.ok().build());
    	}
	
	}

	
	
}
