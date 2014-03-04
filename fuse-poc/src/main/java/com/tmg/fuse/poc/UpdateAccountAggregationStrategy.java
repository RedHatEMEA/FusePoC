package com.tmg.fuse.poc;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.apache.cxf.message.MessageContentsList;

public class UpdateAccountAggregationStrategy implements AggregationStrategy {

    public Exchange aggregate(Exchange original, Exchange resource) {
    	
    	//The original message is an Account message.
    	//The resource is the data returned from the database.);
 

		
		List<Map<String, Object>> data = (List<Map<String, Object>>)resource.getIn().getBody();
		System.out.println("**************************" + data.getClass());
		Map<String, Object> row = data.get(0);
		String xrefId = row.get("XREFID").toString();
		String name = row.get("NAME").toString();
		System.out.println("XREFID = " +xrefId +" name=" +name);
    	
     	
		//The only thing we can merge is the name... 
        Account account = (Account)original.getIn().getBody();

             
    	// Set the new account object as the body.
    	original.getOut().setBody(account);
        return original;
    }
    
}

