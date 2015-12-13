package com.github.verhagen.table;

public class DataCell <T> {
	final Header header;
	final T value;

	public DataCell(final Header header, final T value) {
		this.header = header;
		this.value = value;
	}

	public static <T> DataCell<T> create(final Header header, final T value) {
		return new DataCell<T>(header, value);
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
