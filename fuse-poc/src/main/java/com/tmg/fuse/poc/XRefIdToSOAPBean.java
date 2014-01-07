package com.tmg.fuse.poc;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.*;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.SOAPEnvelope;

public class XRefIdToSOAPBean implements Processor {


		@Override
		public void process(Exchange exchange) throws Exception {
			Message inMessage = exchange.getIn();
			
			List<Map<String, Object>> data = (List<Map<String, Object>>)inMessage.getBody();
			Map<String, Object> row = data.get(0);
        	String xrefId = row.get("XREFID").toString();
        	
        	System.out.println("\n XREFID is :\n" + xrefId);
        	
        	SOAPConnectionFactory sfc = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = sfc.createConnection();

            MessageFactory mf = MessageFactory.newInstance();
            SOAPMessage sm = mf.createMessage();
            
            SOAPPart part = sm.getSOAPPart();
            SOAPEnvelope envelope = part.getEnvelope();

            // add namespaces
            envelope.addNamespaceDeclaration("acc", "http://account.poc.fuse.tmg.com");
            SOAPHeader sh = sm.getSOAPHeader();
            
            SOAPBody sb = sm.getSOAPBody();
            sh.detachNode();
            QName bodyName = new QName("inputAccount");
            
            SOAPBodyElement bodyElement = sb.addBodyElement(bodyName);
            bodyElement.setPrefix("acc");
            QName qn = new QName("accountId");
            SOAPElement quotation = bodyElement.addChildElement(qn);         
            quotation.addTextNode("1");
            
            System.out.println("\n Soap Request:\n");
            sm.writeTo(System.out);
			
            exchange.getOut().setBody(sm);
		}
        
}