package com.tmg.fuse.poc;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.cxf.message.MessageContentsList;

import com.tmg.fuse.poc.account.Result;
import com.tmg.fuse.poc.psp.Response;
import com.tmg.fuse.poc.psp.Status;

public class AccountValidationProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		
		MessageContentsList cl =  (MessageContentsList)exchange.getIn().getBody();
		
		if(cl.get(0) instanceof Result) {
		
			Result result = (Result)cl.get(0);
			
			//Copy the result into a serializable result object otherwise it will fail when writing to the JMS queue!
			com.tmg.fuse.poc.Result re = new com.tmg.fuse.poc.Result();
			re.setTSNumber(result.getTSNumber());
			re.setWsError(result.getWsError());
			exchange.getOut().setBody(re);
			 
		} else if(cl.get(0) instanceof Response) {
			//Copy the result into a serializable result object otherwise it will fail when writing to the JMS queue!
			Response response = (Response)cl.get(0);
			com.tmg.fuse.poc.Response re = new com.tmg.fuse.poc.Response();
			re.setResponseStatus(response.getResponseStatus());
			exchange.getOut().setBody(re);
		}
		
	}
}
