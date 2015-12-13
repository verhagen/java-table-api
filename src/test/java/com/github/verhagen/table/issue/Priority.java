package com.github.verhagen.table.issue;

public class Priority {
	private final String name;

	public Priority(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Priority create(final String name) {
		return new Priority(name);
	}

	@Override
	public String toString() {
		return "Priority [name=" + name + "]";
	}

}
