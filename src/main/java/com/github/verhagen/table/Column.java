package com.github.verhagen.table;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Column {
	private final List<TableCell<?>> cells;


	public Column(final Builder<?> bldr) {
		cells = bldr.getCells();
	}


	public List<TableCell<?>> get() {
		return Collections.unmodifiableList(cells);
	}


	// Builder

	public static class Builder<T> {
		private Header header;
		private List<TableCell<T>> cells = new LinkedList<>();

		public Builder(final Header header) {
			this.header = header;
		}
		
		public Column create() {
			return new Column(this);
		}

		public List<TableCell<?>> getCells() {
			return Collections.unmodifiableList(cells);
		}

		public Builder<T> add(T value) {
			cells.add(TableCell.create(header, value));
			return this;
		}

	}

}
