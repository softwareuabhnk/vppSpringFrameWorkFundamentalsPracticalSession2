package com.virtualpairprogrammers.services.calls;

import java.util.Collection;

import com.virtualpairprogrammers.domain.Action;
import com.virtualpairprogrammers.domain.Call;
import com.virtualpairprogrammers.services.customers.CustomerNotFoundException;

public class CallHandlingServiceMockImpl implements CallHandlingService {

	@Override
	public void recordCall(String customerId, Call newCall, Collection<Action> actions)
			throws CustomerNotFoundException {
		// TODO Auto-generated method stub

	}

}
