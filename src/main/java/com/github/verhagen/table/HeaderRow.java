package com.github.verhagen.table;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class HeaderRow {
	private Map<String, Header> headers = new HashMap<>();
	

	public HeaderRow(final Builder bldr) {
		this.headers = bldr.getHeaders();
	}


	public Header get(final String name) {
		return headers.get(name);
	}


	public Map<String, Header> getHeaders() {
		return Collections.unmodifiableMap(headers);
	}
	

	// Builder

	public static class Builder {
		private Map<String, Header> headers = new HashMap<>();

		
		public Builder add(Header header) {
			headers.put(header.getName(), header);
			return this;
		}


		public Map<String, Header> getHeaders() {
			return Collections.unmodifiableMap(headers);
		}


		public HeaderRow create() {
			return new HeaderRow(this);
		}
		
	}

}
