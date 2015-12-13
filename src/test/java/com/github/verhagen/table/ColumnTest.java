package com.github.verhagen.table;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.annotations.Test;

public class ColumnTest {

	@Test
	public void create() throws Exception {
		Column column = new Column.Builder<String>(new Header.Builder().setName("issue-id").setType(String.class).setPattern("sample-[0-9]*").create())
				.add("sample-22")
				.add("sample-33")
				.add("sample-44")
				.create();

		assertNotNull(column);
		List<TableCell<?>> cells = column.get();
		assertEquals(cells.size(), 3);
		assertEquals(cells.get(0).getValue(), "sample-22");
		assertEquals(cells.get(1).getValue(), "sample-33");
		assertEquals(cells.get(2).getValue(), "sample-44");

	}
}
