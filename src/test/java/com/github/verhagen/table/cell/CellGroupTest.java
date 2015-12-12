package com.github.verhagen.table.cell;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class CellGroupTest {

	@Test
	public void createCellGroup() throws Exception {
		Date date = new SimpleDateFormat("yyyy.MM.dd").parse("1934.06.09");
		CellGroup cellGroup = new CellGroup.Builder(createPersonCellGroupDefinition())
				.add("given-name", "Donald")
				.add("surname", "Duck")
				.add("birth-date", date)
				.create();
		
		assertNotNull(cellGroup);
		assertEquals(cellGroup.get("given-name").getName(), "given-name");
		assertEquals(cellGroup.get("given-name").getType(), String.class);
		assertEquals(cellGroup.get("given-name").getValue(), "Donald");
		assertEquals(cellGroup.get("birth-date").getName(), "birth-date");
		assertEquals(cellGroup.get("birth-date").getType(), Date.class);
		assertEquals(new SimpleDateFormat("d/MMM/yyyy").format(cellGroup.get("birth-date").getValue()), "9/Jun/1934");
	}

	private CellGroupDefinition createPersonCellGroupDefinition() {
		CellDefinition givenNameCellDef = new CellDefinition.Builder().setName("given-name").setType(String.class).create();
		CellDefinition preposCellDef = new CellDefinition.Builder().setName("prepositions").setType(String.class).create();
		CellDefinition surnameCellDef = new CellDefinition.Builder().setName("surname").setType(String.class).create();
		CellDefinition birthDateCellDef = new CellDefinition.Builder().setName("birth-date").setType(Date.class).create();
		
		CellGroupDefinition cellGroupDef = new CellGroupDefinition.Builder()
				.add(givenNameCellDef)
				.add(preposCellDef)
				.add(surnameCellDef)
				.add(birthDateCellDef)
				.create();
		return cellGroupDef;
	}
}
