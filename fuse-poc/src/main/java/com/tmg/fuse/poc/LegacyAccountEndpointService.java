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

import com.tmg.fuse.poc.account.legacy.AccountDetails;
import com.tmg.fuse.poc.account.legacy.AccountServicePortType;
import com.tmg.fuse.poc.account.legacy.Result;

/**
 * This is the implementation of the real web service
 *
 * @version 
 */
public class LegacyAccountEndpointService implements AccountServicePortType {

	@Override
	public AccountDetails getAccount(String tsNumber) {

		System.out.println("***********CALLED LEGACY CRM SERVICE***************");
		// For the purposes of the demo the string coming in actually contains the TSNumber plus their Name
		String name = tsNumber.split(",")[1];
		String num = tsNumber.split(",")[0];
		
		AccountDetails a = new AccountDetails();	
		
		a.setCity("Birmingham");
		a.setCountry("UK");
		a.setAccountType("-");
		a.setCounty("-");
		a.setDigitalSubscriberStatus("-");
		a.setFirstName(name);
		a.setGUID("-");
		a.setHomePhone("0000");
		a.setLastName("Walton");
		a.setMarketingEmailPref(true);
		a.setMarketingPhonePref(true);
		a.setMarketingPostPref(true);
		a.setMarketingSMSPref(true);
		a.setMobilePhone("0000");
		a.setPersonalEmail("email");
		a.setPostalCode("-");
		a.setStreet("-");
		a.setTCode("-");
		a.setTitle("Mr");
		a.setTSNumber(num);
		
		
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
