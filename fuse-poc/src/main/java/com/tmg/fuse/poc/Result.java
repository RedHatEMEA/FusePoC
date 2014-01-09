package com.tmg.fuse.poc;

import java.io.Serializable;

/**
 * This result class extends the generated result class but implements serializable so that it can be used with camel and 
 * JMS queues. 
 * @author gcolman
 *
 */
public class Result extends com.tmg.fuse.poc.account.Result implements Serializable{

	private static final long serialVersionUID = 1L;
	
}
