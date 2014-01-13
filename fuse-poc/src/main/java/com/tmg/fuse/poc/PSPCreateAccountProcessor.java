package com.tmg.fuse.poc;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;

import com.tmg.fuse.poc.psp.Account;
import com.tmg.fuse.poc.canonical.CanonicalAccountDetails;

public class PSPCreateAccountProcessor  implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		CanonicalAccountDetails account = (CanonicalAccountDetails)exchange.getIn().getBody();
		

		Account pspAccount = new Account();
		pspAccount.setFirstName(account.getFirstName());
		pspAccount.setTmgId(account.getGuid());
		
    	exchange.getOut().setBody(pspAccount);
    	exchange.getOut().setHeaders(exchange.getIn().getHeaders());
    	exchange.getOut().setHeader(CxfConstants.OPERATION_NAME, "createAccount");
    	 
	}
}
