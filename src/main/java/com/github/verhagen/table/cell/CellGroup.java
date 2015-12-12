package com.github.verhagen.table.cell;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CellGroup {
	private final CellGroupDefinition cellGroupDefinition;
	private final Map<String, Cell<?>> cells;


	public CellGroup(final Builder bldr) {
		this.cellGroupDefinition = bldr.getCellGroupDefinition();
		this.cells = bldr.getCells();
	}


	public Cell<?> get(final String name) {
		return cells.get(name);
	}


	public CellDefinition getCellDefinition(final String name) {
		return cellGroupDefinition.getCellDefinition(name);
	}



	// Builder

	public static class Builder {
		private final CellGroupDefinition cellGroupDefinition;
		private Map<String, Cell<?>> cells = new HashMap<>();


		public Builder(final CellGroupDefinition cellGroupDefinition) {
			this.cellGroupDefinition = cellGroupDefinition;
		}

		public CellGroup create() {
			return new CellGroup(this);
		}

		
		public CellGroupDefinition getCellGroupDefinition() {
			return cellGroupDefinition;
		}

		public Map<String, Cell<?>> getCells() {
			return Collections.unmodifiableMap(cells);
		}

		public <T> Builder add(final String name, T value) {
			CellDefinition cellDef = cellGroupDefinition.getCellDefinition(name);
			cells.put(name, Cell.create(cellDef, value));
			return this;
		}

	}

}
