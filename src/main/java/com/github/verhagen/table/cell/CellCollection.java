package com.github.verhagen.table.cell;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CellCollection {
	private List<Cell<?>> cells;


	public CellCollection(final Builder<?> bldr) {
		cells = bldr.getCells();
	}
	
	public List<Cell<?>> get() {
		return Collections.unmodifiableList(cells);
	}


	public static class Builder<T> {
		private CellDefinition cellDef;
		private List<Cell<T>> cells = new LinkedList<>();
		
		public Builder(final CellDefinition cellDef) {
			this.cellDef = cellDef;
		}
		
		public CellCollection create() {
			return new CellCollection(this);
		}

		public List<Cell<?>> getCells() {
			return Collections.unmodifiableList(cells);
		}

		public Builder<T> add(T value) {
			cells.add(Cell.create(cellDef, value));
			return this;
		}
	}

}
