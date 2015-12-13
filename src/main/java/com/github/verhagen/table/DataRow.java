package com.github.verhagen.table;

import java.util.HashMap;
import java.util.Map;

public class DataRow {
	private HeaderRow headerRow;
	private Map<String, TableCell<?>> cells;


	public DataRow(final Builder bldr) {
		this.headerRow = bldr.getHeaders();
		this.cells = bldr.getCells();
	}

	public TableCell<?> get(final String name) {
		return cells.get(name);
	}

	public Header getHeader(final String name) {
		return headerRow.get(name);
	}


	// Builder

	public static class Builder {
		private HeaderRow headers;
		private Map<String, TableCell<?>> tableCells = new HashMap<>();

		public Builder(final HeaderRow headers) {
			this.headers = headers;
		}

		public DataRow create() {
			return new DataRow(this);
		}
		
		public HeaderRow getHeaders() {
			return headers;
		}

		public Map<String, TableCell<?>> getCells() {
			return tableCells;
		}

		public <T> Builder add(final String name, final T value) {
			Header header = headers.get(name);
			tableCells.put(name, TableCell.create(header, value));
			return this;
		}

	}

}
