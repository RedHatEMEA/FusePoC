package com.tmg.fuse.poc;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.cxf.service.model.*;
import org.apache.cxf.message.*;
import com.tmg.fuse.poc.account.legacy.AccountDetails;


public class LegacyAccountDetailsProcessor implements Processor{
	
	//private static final transient Logger LOG = LoggerFactory.getLogger(PersonProcessor.class);
	 
    @SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {
        //LOG.info("processing exchange in camel");
 
        BindingOperationInfo boi = (BindingOperationInfo)exchange.getProperty(BindingOperationInfo.class.toString());
        if (boi != null) {
            //LOG.info("boi.isUnwrapped" + boi.isUnwrapped());
        }
        // Get the parameters list which element is the holder.
        MessageContentsList msgList = (MessageContentsList)exchange.getIn().getBody();
        AccountDetails a = (AccountDetails)msgList.get(0);
        
        
        exchange.getOut().setBody(a, AccountDetails.class);
    }

}
