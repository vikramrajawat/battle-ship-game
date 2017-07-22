package com.tw.game.battle.common;

/* 
 * A representation of coordinate having X and Y coordinates. 
 * Coordinates will be used to place ships on specific position on battle field and 
 * Coordinates will also be used by missiles to target enemy on battle field
 */
public class Coordinate {

	private int xCoordinate, yCoordinate;

	public Coordinate(int xCoordinate,int yCoordinate) {
		super();
		this.xCoordinate = xCoordinate-1;
		this.yCoordinate = yCoordinate-1;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xCoordinate;
		result = prime * result + yCoordinate;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (xCoordinate != other.xCoordinate)
			return false;
		if (yCoordinate != other.yCoordinate)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Coordinate [xCoordinate=" + xCoordinate + ", yCoordinate="
				+ yCoordinate + "]";
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
}
