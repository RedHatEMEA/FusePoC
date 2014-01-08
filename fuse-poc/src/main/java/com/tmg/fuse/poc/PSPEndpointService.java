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


import com.tmg.fuse.poc.psp.Account;
import com.tmg.fuse.poc.psp.AccountResponse;
import com.tmg.fuse.poc.psp.Order;
import com.tmg.fuse.poc.psp.PaymentInstrument;
import com.tmg.fuse.poc.psp.PaymentService;
import com.tmg.fuse.poc.psp.Response;

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
		// TODO Auto-generated method stub
		return null;
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
