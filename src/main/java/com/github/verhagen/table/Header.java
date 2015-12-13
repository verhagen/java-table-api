package com.github.verhagen.table;

import com.github.verhagen.table.cell.CellDefinition;

public class Header {
	private final CellDefinition cellDefinition;


	public Header(final CellDefinition cellDefinition) {
		this.cellDefinition = cellDefinition;
	}

	public String getName() {
		return cellDefinition.getName();
	}

	public Class<?> getType() {
		return cellDefinition.getType();
	}
	
	public String getRegExpStr() {
		return cellDefinition.getRegExpStr();
	}


	// Builder

	public static class Builder {
		private CellDefinition.Builder cellDefBldr = new CellDefinition.Builder();

		public Header create() {
			return new Header(cellDefBldr.create());
		}
		
		public Builder setName(final String name) {
			cellDefBldr.setName(name);
			return this;
		}

		public Builder setType(final Class<?> type) {
			cellDefBldr.setType(type);
			return this;
		}


		public Builder setPattern(final String regExpStr) {
			cellDefBldr.setPattern(regExpStr);
			return this;
		}

	}

}
