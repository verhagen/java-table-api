package com.github.verhagen.table.issue;

import java.util.ArrayList;
import java.util.List;

public class PriorityRepository {
	private final List<Priority> priorities = new ArrayList<>();

	public void add(Priority priority) {
		priorities.add(priority);
	}

	public Priority get(final String priorityStr) {
		for (Priority priority : priorities) {
			if (priority.getName().equalsIgnoreCase(priorityStr)) {
				return priority;
			}
		}
		
		throw new IllegalArgumentException("Argument 'priorityStr' with value '" + priorityStr 
				+ "' is not a known Priority. Known Priotities are " + priorities);
	}
}
