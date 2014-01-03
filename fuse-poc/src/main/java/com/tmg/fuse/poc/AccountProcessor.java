package com.tmg.fuse.poc;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class AccountProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		exchange.getOut().setBody("<html><b>Processing your account now!</b></html>");
		
	}

	
	
}
