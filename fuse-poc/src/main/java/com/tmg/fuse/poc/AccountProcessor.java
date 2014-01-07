package com.tmg.fuse.poc;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.*;
import org.apache.cxf.message.MessageContentsList;


public class AccountProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		Message inMessage = exchange.getIn();                        
        
		// Get the operation name from in message
        String operationName = inMessage.getHeader(CxfConstants.OPERATION_NAME, String.class);
        
        if ("retrieveAccount".equals(operationName)) {

        	//Nothing here
        	
        } else if ("createAccount".equals(operationName)) {
        	//The body is a MessageContentList object, which is not handled when sending back out to the client
        	//So set the message (Account object) as the body, which will be handled by CXF back to the client.
        	MessageContentsList inList = (MessageContentsList)exchange.getIn().getBody();
        	Account account = (Account)inList.get(0);
        
        	//Set the account body and headers back onto the body
        	exchange.getOut().setBody(account);
        	exchange.getOut().setHeaders(exchange.getIn().getHeaders());
        }
	
	}

	
	
}
