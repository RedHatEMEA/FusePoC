package com.tmg.fuse.poc;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.*;
import org.apache.cxf.message.MessageContentsList;

import com.tmg.fuse.poc.account.AccountDetails;




public class CreateAccountProcessor implements Processor {


		@Override
		public void process(Exchange exchange) throws Exception {
			
//        	MessageContentsList inList = (MessageContentsList)exchange.getIn().getBody();
//        	Account account = (Account)inList.get(0);
//        	
			Account account = (Account)exchange.getIn().getBody();
			
//        	System.out.println("\n account to create is :" + account.toString());
        	AccountDetails accountdetails = new AccountDetails();
        	accountdetails.setFirstName(account.getName());
        	accountdetails.setGUID(account.getAccountID());
        	
        	exchange.getOut().setBody(accountdetails);
        	exchange.getOut().setHeaders(exchange.getIn().getHeaders());
        	exchange.getOut().setHeader(CxfConstants.OPERATION_NAME, "createAccount");
        	 
		}
        
}

