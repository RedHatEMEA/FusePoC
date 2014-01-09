package com.tmg.fuse.poc;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;

public class PSPCreateAccountProcessor  implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
	
		Account account = (Account)exchange.getIn().getBody();

		com.tmg.fuse.poc.psp.Account pspAccount = new com.tmg.fuse.poc.psp.Account();
		pspAccount.setFirstName(account.getName());
		pspAccount.setTmgId(account.getAccountID());
		
    	exchange.getOut().setBody(pspAccount);
    	exchange.getOut().setHeaders(exchange.getIn().getHeaders());
    	exchange.getOut().setHeader(CxfConstants.OPERATION_NAME, "createAccount");
    	 
	}
}
