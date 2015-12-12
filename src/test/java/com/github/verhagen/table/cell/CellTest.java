package com.github.verhagen.table.cell;

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.github.verhagen.table.cell.Cell;
import com.github.verhagen.table.cell.CellDefinition;

public class CellTest {

	@Test
	public void createFirstName() throws Exception {
		//Column column = new Column.ColumnBuilder().setName("xxx").setType(Integer.class).create();
		CellDefinition cellDef = new CellDefinition.Builder().setName("first-name").setType(String.class).create();
		Cell<String> cell = Cell.create(cellDef, "Pluto");

		assertEquals(cell.getValue(), "Pluto");
		assertEquals(cell.getName(), "first-name");
		assertEquals(cell.getType(), String.class);
	}

	@Test
	public void createNameWithPattern() throws Exception {
		//Column column = new Column.ColumnBuilder().setName("xxx").setType(Integer.class).create();
		CellDefinition cellDef = new CellDefinition.Builder().setName("first-name").setType(String.class).setPattern("[a-zA-Z][a-zA-Z ]*").create();
		Cell<String> cell = Cell.create(cellDef, "Donald Duck");
		
		assertEquals(cell.getValue(), "Donald Duck");
		assertEquals(cell.getName(), "first-name");
		assertEquals(cell.getType(), String.class);
	}

	@Test
	public void createAge() throws Exception {
		CellDefinition cellDef = new CellDefinition.Builder().setName("age").setType(Integer.class).create();
		Cell<Integer> cell = Cell.create(cellDef, Integer.valueOf("22"));
		
		assertEquals(cell.getValue().intValue(), 22);
		assertEquals(cell.getName(), "age");
		assertEquals(cell.getType(), Integer.class);
	}

	@Test
	public void createBirthDate() throws Exception {
		//Column column = new Column.ColumnBuilder().setName("xxx").setType(Integer.class).create();
		CellDefinition cellDef = new CellDefinition.Builder().setName("birth-date").setType(Date.class).create();
		Date birthDate = createDate("1939.04.20");
		Cell<Date> cell = Cell.create(cellDef, birthDate);
		
		DateFormat dateFormat = new SimpleDateFormat("d-MMM-yyyy");
		assertEquals(dateFormat.format(cell.getValue()), "20-Apr-1939");
		assertEquals(cell.getName(), "birth-date");
		assertEquals(cell.getType(), Date.class);
	}


	private Date createDate(String dateStr) {
		final String pattern = "yyyy.MM.dd";
		try {
			DateFormat dateFormat = new SimpleDateFormat(pattern);
			return dateFormat.parse(dateStr);
		}
		catch (ParseException e) {
			throw new IllegalArgumentException("Argument 'dateStr' with value '" + dateStr 
					+ "' is not following the date pattern '" + pattern + "'");
		}
	}
}
