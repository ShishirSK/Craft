package com.craft.rover.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.craft.rover.MarsGrid;
import com.craft.rover.Rover;
import com.craft.rover.RoverPositionAndMovement;
import com.craft.rover.RoverPositionAndMovement.Direction;

public class MarsRoverTest {

	MarsGrid grid = new MarsGrid();
	Rover rover = new Rover();
	RoverPositionAndMovement roverPos = new RoverPositionAndMovement();
	int[] nextRoverPos;
	Direction currentDir;
	char f = 'f';
	char l = 'l';
	char b = 'b';
	char r = 'r';
	
	@Test
	public void gridNotNull() {
		assertNotNull("The MarsGrid is not defined", grid);
	}

	@Test
	public void roverNotFound() {
		assertNotNull("The rover is not defined", rover);
	}
	
	@Test
	public void roverPosObjectNotDefined(){
		assertNotNull("The rover position and movement object not defined", roverPos);
	}
	
	@Test
	public void isPositionEmpty(){
		assertTrue(grid.isPositionEmpty(0, 0));
	}
	
	@Test
	public void setRoverPosition(){
		grid.setPosition(0, 0);
		assertEquals(grid.getGrid()[0][0], 8);
	}
	
	@Test
	public void rightPositionToPlaceRover(){
		assertTrue(rover.placeRover(grid, 0, 0));
	}

	@Test
	public void wrongLocationToPlaceRover(){
		assertFalse(rover.placeRover(grid, -1, -1));
	}
	
	@Test
	public void getNextRoverPositionEastForward(){
		nextRoverPos = roverPos.getNextRoverPosition(5, 5, Direction.EAST, f);
		assertEquals(nextRoverPos[1], 6);
	}
	
	@Test
	public void getNextRoverPositionWestForward(){
		nextRoverPos = roverPos.getNextRoverPosition(5, 5, Direction.WEST, f);
		assertEquals(nextRoverPos[1], 4);
	}
	
	@Test
	public void getNextRoverPositionNorthForward(){
		nextRoverPos = roverPos.getNextRoverPosition(5, 5, Direction.NORTH, f);
		assertEquals(nextRoverPos[0], 4);
	}
	
	@Test
	public void getNextRoverPositionSouthForward(){
		nextRoverPos = roverPos.getNextRoverPosition(5, 5, Direction.SOUTH, f);
		assertEquals(nextRoverPos[0], 6);
	}
	
	@Test
	public void getNextRoverPositionEastBackward(){
		nextRoverPos = roverPos.getNextRoverPosition(5, 5, Direction.EAST, b);
		assertEquals(nextRoverPos[1], 4);
	}
	
	@Test
	public void getNextRoverPositionWestBackward(){
		nextRoverPos = roverPos.getNextRoverPosition(5, 5, Direction.WEST, b);
		assertEquals(nextRoverPos[1], 6);
	}
	
	@Test
	public void getNextRoverPositionNorthBackward(){
		nextRoverPos = roverPos.getNextRoverPosition(5, 5, Direction.NORTH, b);
		assertEquals(nextRoverPos[0], 6);
	}
	
	@Test
	public void getNextRoverPositionSouthBackward(){
		nextRoverPos = roverPos.getNextRoverPosition(5, 5, Direction.SOUTH, b);
		assertEquals(nextRoverPos[0], 4);
	}
	
	@Test
	public void turnLeftFromEast(){
		currentDir = roverPos.turnRover(Direction.EAST, l);
		assertEquals(currentDir, Direction.NORTH);
	}
	
	@Test
	public void turnLeftFromWest(){
		currentDir = roverPos.turnRover(Direction.WEST, l);
		assertEquals(currentDir, Direction.SOUTH);
	}
	@Test
	public void turnLeftFromNorth(){
		currentDir = roverPos.turnRover(Direction.NORTH, l);
		assertEquals(currentDir, Direction.WEST);
	}
	@Test
	public void turnLeftFromSouth(){
		currentDir = roverPos.turnRover(Direction.SOUTH, l);
		assertEquals(currentDir, Direction.EAST);
	}
}
