package com.github.verhagen.table.cell;


public class CellDefinition {
	private final String name;
	private final Class<?> type;
	private final String regExpStr;

	public CellDefinition(final Builder bldr) {
		this.name = bldr.getName();
		this.type = bldr.getType();
		this.regExpStr = bldr.getPattern();
	}


	public String getName() {
		return name;
	}

	public Class<?> getType() {
		return type;
	}
	
	public String getRegExpStr() {
		return regExpStr;
	}



	public static class Builder {
		private String name;
		private Class<?> type;
		private String regExpStr;


		public CellDefinition create() {
			return new CellDefinition(this);
		}

		
		public String getName() {
			return name;
		}

		public Class<?> getType() {
			return type;
		}

		public String getPattern() {
			return regExpStr;
		}


		public Builder setName(final String name) {
			this.name = name;
			return this;
		}

		public Builder setType(final Class<?> type) {
			this.type = type;
			return this;
		}


		public Builder setPattern(final String regExpStr) {
			this.regExpStr = regExpStr;
			return this;
		}

	}

}
