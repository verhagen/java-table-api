package com.github.verhagen.table;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.github.verhagen.table.issue.Priority;

public class DataRowTest {
	private static final String HEADER_ISSUE_ID = "issue-id";
	private static final String HEADER_CREATION_DATE = "creation-date";
	private static final String HEADER_PRIORITY = "priority";


	@Test
	public void create() throws Exception {
		Priority priority = Priority.create("bug");
		DataRow dataRow = new DataRow.Builder(createHeaders())
				.add(HEADER_ISSUE_ID, "sample-12")
				.add(HEADER_CREATION_DATE, createDate("2015.12.13"))
				.add(HEADER_PRIORITY, priority)
				.create();

		assertNotNull(dataRow);
		assertEquals(dataRow.get(HEADER_ISSUE_ID).getValue(), "sample-12");
		DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
		assertEquals(df.format(dataRow.get(HEADER_CREATION_DATE).getValue()), "13/Dec/2015");
		assertEquals(dataRow.get(HEADER_PRIORITY).getValue(), priority);
	}


	private Date createDate(final String dateStr) {
		String datePattern = "yyyy.MM.dd";
		DateFormat dateFormat = new SimpleDateFormat(datePattern);
		try {
			return dateFormat.parse(dateStr);
		}
		catch (ParseException pe) {
			throw new IllegalArgumentException("The given date '" + dateStr 
					+ "' seams not correct or following the format '" + datePattern + "'", pe);
		}
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
