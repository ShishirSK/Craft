package com.craft.rover;

import com.craft.rover.RoverPositionAndMovement.Direction;

public class MarsRover {

	private static MarsGrid planetGrid = new MarsGrid();
	private static Rover aRover = new Rover();

	public static void main(String[] args) {

		planetGrid.showGrid();

		// Get a rover and place it on the grid

		boolean roverPlaced = aRover.placeRover(planetGrid, 0, 0);
		if (roverPlaced) {
			planetGrid.setPosition(0, 0);
			aRover.setDirection(Direction.EAST);
		} else {
			System.out.print("Position is not valid");
		}

		traverse();
	}

	private static void traverse() {

		int[] nextPos;
		boolean isValidPosition;
		Direction newDir;

		RoverPositionAndMovement roverStuff = new RoverPositionAndMovement();
		char[] commands = { 'f', 'f', 'r', 'f', 'f', 'l', 'f', 'r', 'f', 'r',
				'b' };
		for (int i = 0; i < commands.length; i++) {
			if (commands[i] == 'f' || commands[i] == 'b') {
				nextPos = roverStuff.getNextBotPosition(aRover.getxPos(),
						aRover.getyPos(), aRover.getDirection(), commands[i]);
				isValidPosition = planetGrid.isPositionEmpty(nextPos[0],
						nextPos[1]);
				if (isValidPosition) {
					planetGrid.updateRoverPosition(aRover.getxPos(),
							aRover.getyPos(), nextPos[0], nextPos[1]);
					aRover.setxPos(nextPos[0]);
					aRover.setyPos(nextPos[1]);
				} else {
					System.out.println("That position at " + "[" + nextPos[0]
							+ ", " + nextPos[1] + "]"
							+ " is occupied! Are you trying to damage me?!");
					System.out.println("Am not taking anymore commands from you!!");
					break;
				}
			} else if (commands[i] == 'l' || commands[i] == 'r') {
				newDir = roverStuff.turnRover(aRover.getDirection(),
						commands[i]);
				aRover.setDirection(newDir);
			}
			planetGrid.showGrid();
		}
		planetGrid.showGrid();
		// roverStuff.move();
	}
}
