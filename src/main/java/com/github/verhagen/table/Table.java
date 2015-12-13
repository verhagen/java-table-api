package com.github.verhagen.table;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Table {
	private final HeaderRow headers;
	private final List<DataRow> rows;


	public Table(final Builder bldr) {
		headers = bldr.getHeaders();
		rows = bldr.getRows();
	}


	public DataRow getRow(int index) {
		return rows.get(index);
	}

	public List<DataRow> getRows() {
		return Collections.unmodifiableList(rows);
	}
	
	public Header getHeader(final String name) {
		return headers.get(name);
	}


	public static class Builder {
		private HeaderRow headers;
		private List<DataRow> rows = new LinkedList<>();

		public Table create() {
			return new Table(this);
		}

		public Builder(final HeaderRow headers) {
			this.headers = headers;
		}

		public List<DataRow> getRows() {
			return Collections.unmodifiableList(rows);
		}

		public HeaderRow getHeaders() {
			return headers;
		}

		public Builder add(final DataRow row) {
			// TODO Compare headers
			rows.add(row);
			return this;
		}

	}

}
