package model;

import java.io.IOException;

public abstract class Piece {
	
//	protected int x; // coordinate x
//	protected int y; // coordinate y
//	
	public int x; // coordinate x
	public int y; // coordinate y
	
	private boolean color; // white --> true, black --> false
	private String name; // name --> for .... validation?
	
	
	protected Piece (int x, int y, boolean color, String name) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.name = name;
	}
	// functions needed 
	abstract public boolean canMove(int x, int y) throws IOException;
	abstract public void moveTo(int x, int y);
	public String toString() {
		return("( x="+x + " y="+y + " color: "+color+" name: "+  name+" )\n" );
	}
	// checking the colors of what they are going to eat --> different color : true.
	abstract public boolean isEatable(String[][] map, int moveX, int moveY);
	// check if it is null in the map
	abstract public boolean isBlank(String[][] map, int moveX, int moveY);
	// check if the location that they are moving to is available 
//	abstract public boolean checkRange();
	
	public String getName() {
		return name;
	}
	public boolean getColor() {
		return color;
	}
	
}

