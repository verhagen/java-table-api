package com.github.verhagen.table;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.verhagen.table.issue.Priority;
import com.github.verhagen.table.issue.PriorityRepository;

public class TableTest {
	private static final String HEADER_ISSUE_ID = "issue-id";
	private static final String HEADER_CREATION_DATE = "creation-date";
	private static final String HEADER_PRIORITY = "priority";

	private final PriorityRepository priorityRepo = new PriorityRepository();
	private final static Priority PRIORITY_BUG = Priority.create("bug");
	
	@BeforeClass
	public void setUp() {
		priorityRepo.add(PRIORITY_BUG);
		priorityRepo.add(Priority.create("improvement"));
	}

	@Test
	public void create() throws Exception {
		HeaderRow headers = createHeaders();
		Table table = new Table.Builder(headers)
				.add(new DataRow.Builder(headers)
						.add(HEADER_ISSUE_ID, "sample-11")
						.add(HEADER_CREATION_DATE, "sample-11")
						.add(HEADER_PRIORITY, PRIORITY_BUG)
						.create())
				.add(new DataRow.Builder(headers)
						.add(HEADER_ISSUE_ID, "sample-22")
						.add(HEADER_CREATION_DATE, "sample-22")
						.add(HEADER_PRIORITY, priorityRepo.get("improvement"))
						.create())
				.create();
		
		assertNotNull(table);
		assertNotNull(table.getRows());
		assertEquals(table.getRows().size(), 2);
		assertEquals(table.getRow(1).get(HEADER_ISSUE_ID).getValue(), "sample-22");
		assertEquals(table.getRow(1).get(HEADER_PRIORITY).getValue(), priorityRepo.get("improvement"));
	}


	public HeaderRow createHeaders() {
		HeaderRow headerRow = new HeaderRow.Builder()
				.add(new Header.Builder().setName(HEADER_ISSUE_ID).setType(String.class).create())
				.add(new Header.Builder().setName(HEADER_CREATION_DATE).setType(Date.class).create())
				.add(new Header.Builder().setName(HEADER_PRIORITY).setType(Priority.class).create())
				.create();
		return headerRow;
	}

}
