package com.tmg.fuse.poc;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.*;

import com.tmg.fuse.poc.canonical.CanonicalAccountDetails;
import com.tmg.fuse.poc.account.AccountDetails;



public class CreateAccountProcessor implements Processor {


		@Override
		public void process(Exchange exchange) throws Exception {
        	
			CanonicalAccountDetails account = (CanonicalAccountDetails)exchange.getIn().getBody();
			
//        	System.out.println("\n account to create is :" + account.toString());
        	AccountDetails accountDetails = new AccountDetails();
        	//accountdetails.setFirstName(account.getName());
        	//accountdetails.setGUID(account.getAccountID());
        	
        	accountDetails.setFirstName(account.getFirstName());
        	accountDetails.setGUID(account.getGuid());
        	
        	exchange.getOut().setBody(accountDetails);
        	exchange.getOut().setHeaders(exchange.getIn().getHeaders());
        	exchange.getOut().setHeader(CxfConstants.OPERATION_NAME, "createAccount");
        	 
		}
        
}

