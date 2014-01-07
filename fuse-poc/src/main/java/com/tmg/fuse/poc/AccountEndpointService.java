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

//import com.tmg.fuse.poc.account.InputAccount;
import javax.xml.bind.JAXBElement;

import com.tmg.fuse.poc.account.AccountDetails;
import com.tmg.fuse.poc.account.AccountServicePortType;
import com.tmg.fuse.poc.account.Result;

/**
 * This is the implementation of the real web service
 *
 * @version 
 */
public class AccountEndpointService implements AccountServicePortType {

	@Override
	public AccountDetails getAccount(String tsNumber) {
		// TODO Auto-generated method stub
		AccountDetails a = new AccountDetails();
		
		a.setCity("Birmingham");
		a.setCountry("UK");
		return a;
	}
	

	@Override
	public Result updateAccount(AccountDetails accountDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result createAccount(AccountDetails accountDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
