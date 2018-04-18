package com.virtualpairprogrammers.services.diary;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.virtualpairprogrammers.domain.Action;

public class DiaryManagementServiceMockImpl implements DiaryManagementService {
	
	Set<Action> set = new HashSet<Action>();
	
	DiaryManagementServiceMockImpl(){
		
		Calendar requiredBy = Calendar.getInstance();
		
		requiredBy.add(Calendar.DATE,15);
		Action a1 = new Action("Call John", requiredBy , "Mike Jones" );
		Action a2 = new Action("SMS John", requiredBy , "Mike Jones" );
		Action a3 = new Action("email John", requiredBy , "Mike Jones" );
		Action a4 = new Action("1","email Oliver", requiredBy , "Mike Jones", true);
				
		set.add(a1);
		set.add(a2);
		set.add(a3);
		set.add(a4);
		
	}

	@Override
	public void recordAction(Action action) {
		set.add(action);

	}

	@Override
	public List<Action> getAllIncompleteActions(String requiredUser) {
		
		List<Action> nextArrayList = new ArrayList<Action>();
		
		for(Action next: set) {
			if (next.getOwningUser().equals(requiredUser)&&next.isComplete()==false) {
		    nextArrayList.add(next);		
			}
		}

		return nextArrayList;
	}

}
