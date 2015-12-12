package com.github.verhagen.table.cell;

import static org.testng.Assert.assertEquals;

import java.util.Date;

import org.testng.annotations.Test;

public class CellGroupDefinitionTest {

	@Test
	public void createPerson() {
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
		
		CellDefinition cellDefinition = cellGroupDef.getCellDefinition("given-name");
		assertEquals(cellDefinition, givenNameCellDef);
		cellDefinition = cellGroupDef.getCellDefinition("birth-date");
		assertEquals(cellDefinition, birthDateCellDef);
	}

}
