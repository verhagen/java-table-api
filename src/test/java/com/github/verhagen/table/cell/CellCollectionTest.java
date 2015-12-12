package com.github.verhagen.table.cell;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.annotations.Test;

public class CellCollectionTest {

	@Test
	public void create() throws Exception {
		CellCollection cellColl = new CellCollection.Builder<String>(new CellDefinition.Builder().setName("issue-id").setType(String.class).create())
				.add("sample-22")
				.add("sample-33")
				.add("sample-44")
				.create();
		
		assertNotNull(cellColl);
		List<Cell<?>> cells = cellColl.get();
		assertEquals(cells.size(), 3);
		assertEquals(cells.get(0).getValue(), "sample-22");
		assertEquals(cells.get(1).getValue(), "sample-33");
		assertEquals(cells.get(2).getValue(), "sample-44");
	}
	
}
