package com.tmg.fuse.poc;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.*;
import java.util.List;
import java.util.Map;



public class RetrieveAccountProcessor implements Processor {


		@Override
		public void process(Exchange exchange) throws Exception {
			Message inMessage = exchange.getIn();
			
			List<Map<String, Object>> data = (List<Map<String, Object>>)inMessage.getBody();
			Map<String, Object> row = data.get(0);
        	String crmId = row.get("CRMID").toString();
        	String name = row.get("NAME").toString();
        	
        	exchange.getOut().setBody(new Object[] {crmId + ","+name});
        	
        	exchange.getOut().setHeader(CxfConstants.OPERATION_NAME, "getAccount");
        	 
		}
        
}