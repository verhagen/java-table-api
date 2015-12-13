package com.github.verhagen.table;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Column {
	private final List<DataCell<?>> cells;


	public Column(final Builder<?> bldr) {
		cells = bldr.getCells();
	}


	public List<DataCell<?>> get() {
		return Collections.unmodifiableList(cells);
	}


	// Builder

	public static class Builder<T> {
		private Header header;
		private List<DataCell<T>> cells = new LinkedList<>();

		public Builder(final Header header) {
			this.header = header;
		}
		
		public Column create() {
			return new Column(this);
		}

		public List<DataCell<?>> getCells() {
			return Collections.unmodifiableList(cells);
		}

		public Builder<T> add(final T value) {
			cells.add(DataCell.create(header, value));
			return this;
		}

	}

}
