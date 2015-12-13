package com.github.verhagen.table;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class DataCellTest {

	@Test
	public void createFirstName() throws Exception {
		//Column column = new Column.ColumnBuilder().setName("xxx").setType(Integer.class).create();
		Header header = new Header.Builder().setName("first-name").setType(String.class).create();
		DataCell<String> cell = DataCell.create(header, "Pluto");

		assertEquals(cell.getValue(), "Pluto");
		assertEquals(cell.getName(), "first-name");
		assertEquals(cell.getType(), String.class);
	}

}
