package com.craft.rover.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.craft.rover.MarsGrid;

public class MarsRoverTest {

	MarsGrid grid = new MarsGrid();
	@Test
	public void gridNotNull() {
		assertNotNull("The grid is not initiated", grid);
	}

	
	
}
