package com.github.verhagen.table;

public class TableCell <T> {
	final Header header;
	final T value;

	public TableCell(final Header header, final T value) {
		this.header = header;
		this.value = value;
	}

	public static <T> TableCell<T> create(Header header, T value) {
		return new TableCell<T>(header, value);
	}

	public T getValue() {
		return value;
	}


	public String getName() {
		return header.getName();
	}
	
	public Class<?> getType() {
		return header.getType();
	}

}
