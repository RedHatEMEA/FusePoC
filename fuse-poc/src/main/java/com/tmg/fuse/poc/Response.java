package com.tmg.fuse.poc;

import java.io.Serializable;

/**
 * This result class extends the generated response class but implements serializable so that it can be used with camel and 
 * JMS queues. 
 * @author gcolman
 *
 */
public class Response extends com.tmg.fuse.poc.psp.Response implements Serializable{
	
		private static final long serialVersionUID = 1L;

}
