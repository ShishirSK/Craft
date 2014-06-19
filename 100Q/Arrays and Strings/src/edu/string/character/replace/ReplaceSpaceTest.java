package edu.string.character.replace;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReplaceSpaceTest {

	ReplaceSpace stringWithSpace = new ReplaceSpace();

	@Test
	public void aRegularString() {
		assertEquals(stringWithSpace.replaceTheSpace("A String With Space"), "A%20String%20With%20Space");
	}

	@Test
	public void aStringWithExtraSpaces(){
		assertEquals(stringWithSpace.replaceTheSpace("A String With Extra Spaces   "), "A%20String%20With%20Extra%20Spaces");
	}
}
