package com.github.verhagen.table.cell;

import java.util.regex.Pattern;

public class Cell <T> {
	private CellDefinition cellDef;
	private T value;

	public Cell(final CellDefinition cellDef, final T value) {
		this.cellDef = cellDef;
		
		if (cellDef.getRegExpStr() != null && (! Pattern.matches(cellDef.getRegExpStr(), value.toString()))) {
			throw new IllegalArgumentException("Argument 'value' with value '" + value 
					+ "', does not follow the given pattern '" + cellDef.getRegExpStr() + "'");
		}
		this.value = value;
	}

	public static <T> Cell<T> create(final CellDefinition cellDef, final T value) {
		return new Cell<T>(cellDef, value);
	}
	
	public T getValue() {
		return value;
	}

	public String getName() {
		return cellDef.getName();
	}

	public Class<?> getType() {
		return cellDef.getType();
	}

}
