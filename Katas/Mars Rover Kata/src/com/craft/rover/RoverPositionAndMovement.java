package com.craft.rover;

public class RoverPositionAndMovement {

	public static enum Direction {
		 NORTH, SOUTH, EAST, WEST
	}

	private int currentX;
	private int currentY;

	public int getCurrentX() {
		return currentX;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}

	/**
	 * Get the next rover position depending on direction
	 * 
	 * @param x
	 *            - X coordinate of position
	 * @param y
	 *            - Y coordinate of position
	 * @param dir
	 *            - Direction of the rover
	 * @param movDir
	 *            - Forward / backward movement
	 * @return - Next position coordinates
	 */
	public int[] getNextBotPosition(int x, int y, Direction dir, char move) {
		char movDir = Character.toLowerCase(move);
		int[] nextPos = new int[2];

		switch (dir) {
		case EAST:
			if (movDir == 'f') {
				y++;
			} else if (movDir == 'b') {
				y--;
			}
			break;
		case WEST:
			if (movDir == 'f') {
				y--;
			} else if (movDir == 'b') {
				y++;
			}
			break;
		case NORTH:
			if (movDir == 'f') {
				x--;
			} else if (movDir == 'b') {
				x++;
			}
			break;
		case SOUTH:
			if (movDir == 'f') {
				x++;
			} else if (movDir == 'b') {
				x--;
			}
			break;
		}
		nextPos[0] = x;
		nextPos[1] = y;
		return nextPos;
	}

	/**
	 * @return newDir - Direction of the rover after command
	 */
	public Direction turnRover(Direction currentDir, char turn) {
		char turnDir = Character.toLowerCase(turn);
		Direction newDir = null;

		switch (currentDir) {
		case EAST:
			if (turnDir == 'l')
				return Direction.NORTH;
			if (turnDir == 'r')
				return Direction.SOUTH;
			break;
		case NORTH:
			if (turnDir == 'l')
				return Direction.WEST;
			if (turnDir == 'r')
				return Direction.EAST;
			break;
		case SOUTH:
			if (turnDir == 'l')
				return Direction.EAST;
			if (turnDir == 'r')
				return Direction.WEST;
			break;
		case WEST:
			if (turnDir == 'l')
				return Direction.SOUTH;
			if (turnDir == 'r')
				return Direction.NORTH;
			break;
		default:
			break;
		}
		return newDir;
	}

}
