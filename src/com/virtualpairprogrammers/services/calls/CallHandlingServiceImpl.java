package com.virtualpairprogrammers.services.calls;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.virtualpairprogrammers.domain.Action;
import com.virtualpairprogrammers.domain.Call;
import com.virtualpairprogrammers.services.customers.CustomerManagementService;
import com.virtualpairprogrammers.services.customers.CustomerNotFoundException;
import com.virtualpairprogrammers.services.diary.DiaryManagementService;
import com.virtualpairprogrammers.services.diary.DiaryManagementService;


public class CallHandlingServiceImpl implements CallHandlingService {
	
	private CustomerManagementService customerService;
	private DiaryManagementService diaryService;
	
	public CallHandlingServiceImpl( CustomerManagementService cms, DiaryManagementService dms)
	{
		this.customerService = cms;
		this.diaryService = dms;
	}


	@Override
	public void recordCall(String customerId, Call newCall, Collection<Action> actions)
			throws CustomerNotFoundException {
		
		customerService.recordCall(customerId, newCall);
		
		for (Action next : actions) {
			diaryService.recordAction(next);
		}

	}

}
