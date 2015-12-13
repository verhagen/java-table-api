package com.github.verhagen.table;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.net.URI;

import org.testng.annotations.Test;

public class HeaderTest {

	@Test
	public void create() throws Exception {
		Header header = new Header.Builder()
				.setName("issue")
				.setType(URI.class)
				.create();
		
		assertNotNull(header);
		assertEquals(header.getName(), "issue");
		assertEquals(header.getType(), URI.class);
	}

}
