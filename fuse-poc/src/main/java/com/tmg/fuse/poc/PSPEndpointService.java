/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tmg.fuse.poc;


import org.eclipse.jetty.server.Authentication.ResponseSent;

import com.tmg.fuse.poc.account.Result;
import com.tmg.fuse.poc.account.util.WSError;
import com.tmg.fuse.poc.psp.Account;
import com.tmg.fuse.poc.psp.AccountResponse;
import com.tmg.fuse.poc.psp.Order;
import com.tmg.fuse.poc.psp.PaymentInstrument;
import com.tmg.fuse.poc.psp.PaymentService;
import com.tmg.fuse.poc.psp.Response;
import com.tmg.fuse.poc.psp.Status;

/**
 * This is the implementation of the real web service
 *
 * @version 
 */
public class PSPEndpointService implements PaymentService {

	@Override
	public Response updateAccount(Account arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountResponse getAccount(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response createOrder(Order arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response createAccount(Account arg0) {
		Response response = new Response();
		Status status = new Status();
		
		if(arg0.getFirstName().equalsIgnoreCase("pspfail")) {
			status.setStatusCode(arg0.getTmgId());
			status.setStatusMessage("Create account filed for XREF " +arg0.getTmgId() +" - This test error was caused by the create account request message firstname = 'fail'");
			status.setException("Create account filed for XREF " +arg0.getTmgId() +" - This test error was caused by the create account request message firstname = 'fail'");
		} else {
			status.setStatusCode(arg0.getTmgId());
			status.setStatusDetail("VALID PSP status detail");
			status.setStatusMessage("VALID PSP status message");
			status.setException("null");
		}
		
		response.setResponseStatus(status);
		return response;
	
	}

	@Override
	public Response updateEwallet(String arg0, PaymentInstrument arg1,
			boolean arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response createEwallet(String arg0, PaymentInstrument arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
