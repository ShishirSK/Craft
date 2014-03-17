package com.craft.rover;

import com.craft.rover.RoverPositionAndMovement.Direction;

public class Rover {

	private int xPos = 0;
	private int yPos = 0;
	Direction direction;

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	/*
	 * Place rover-rover on grid
	 */
	public boolean placeRover(MarsGrid grid, int x, int y) {
		// Check for position coordinates less than 0
		if (x < 0 || y < 0) {
			System.out.println("Positions cannot be negative");
			return false;
		}
		if (grid.isPositionEmpty(x, y)) {
			return true;
		}
		return false;
	}
	
}
