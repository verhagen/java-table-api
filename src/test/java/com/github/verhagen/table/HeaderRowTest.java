package com.github.verhagen.table;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

public class HeaderRowTest {
	private static final String HEADER_ISSUE_ID = "issue-id";
	private static final String HEADER_ISSUE_DESCRIPTION = "description";

	@Test
	public void create() throws Exception {
		Header issueId = new Header.Builder().setName(HEADER_ISSUE_ID).setType(String.class).create();
		Header description = new Header.Builder().setName(HEADER_ISSUE_DESCRIPTION).setType(String.class).create();
		
		HeaderRow headerRow = new HeaderRow.Builder()
				.add(issueId)
				.add(description)
				.create();
		
		assertNotNull(headerRow);
		assertEquals(headerRow.get(HEADER_ISSUE_ID), issueId);
		assertEquals(headerRow.get(HEADER_ISSUE_DESCRIPTION), description);
	}
}
