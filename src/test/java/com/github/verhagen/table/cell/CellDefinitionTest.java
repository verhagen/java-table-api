package com.github.verhagen.table.cell;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.verhagen.table.cell.CellDefinition;

public class CellDefinitionTest {

	@Test
	public void createCellWithString() throws Exception {
		CellDefinition cellDef = new CellDefinition.Builder().setName("first-name").setType(String.class).create();
		
		assertEquals(cellDef.getName(), "first-name");
		assertEquals(cellDef.getType(), String.class);
	}

	@Test
	public void createCellWithInteger() throws Exception {
		CellDefinition cellDef = new CellDefinition.Builder().setName("age").setType(Integer.class).create();
		
		assertEquals(cellDef.getName(), "age");
		assertEquals(cellDef.getType(), Integer.class);
	}
}
