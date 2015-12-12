package com.github.verhagen.table.cell;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CellGroupDefinition {
	private final Map<String, CellDefinition> cellDefinitions; // = new HashMap<>();


	public CellGroupDefinition(final Builder bldr) {
		this.cellDefinitions = bldr.getCellDefinitions(); 
	}


	public Map<String, CellDefinition> getCellDefinitions() {
		return Collections.unmodifiableMap(cellDefinitions);
	}


	public CellDefinition getCellDefinition(final String name) {
		return cellDefinitions.get(name);
	}


	public static class Builder {
		private Map<String, CellDefinition> cellDefinitions = new HashMap<>();
		
		
		public CellGroupDefinition create() {
			return new CellGroupDefinition(this);
		}


		public Map<String, CellDefinition> getCellDefinitions() {
			return Collections.unmodifiableMap(cellDefinitions);
		}


		public Builder add(final CellDefinition cellDefinition) {
			cellDefinitions.put(cellDefinition.getName(), cellDefinition);
			return this;
		}

	}

}
