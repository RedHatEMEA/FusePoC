package com.tmg.fuse.poc;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.apache.cxf.message.MessageContentsList;

public class GUIDAggregationStrategy implements AggregationStrategy {

    public Exchange aggregate(Exchange original, Exchange resource) {
        Account account = (Account)original.getIn().getBody();
        String ID = "";
        
        
        //Just let all exceptions bubble through to the caller....well, it is a POC!
        
        //Grab the sequence number from the first element of the hashList object if the DB result arrayList!
        ArrayList al = (ArrayList)resource.getIn().getBody();
    	if(al.size() >0) {
    		ID = ((LinkedHashMap)al.get(0)).get("1").toString();
    	}        
    	
    	//Set the sequence number as the account ID
    	account.setAccountID(ID);
    	
    	// Set the new account object as the body.
    	original.getOut().setBody(account);
        return original;
    }
    
}