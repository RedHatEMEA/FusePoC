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
        	String xrefId = row.get("XREFID").toString();
        	
        	System.out.println("\n XREFID is :" + xrefId);
        	
        	exchange.getOut().setBody(new Object[] {xrefId});
        	
        	exchange.getOut().setHeader(CxfConstants.OPERATION_NAME, "getAccount");
        	 
		}
        
}