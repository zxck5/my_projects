package model;

public interface CheckDiagonal {
	// direction true ==> right and down, false --> left and up
	public int posSlope(String[][]map, int x, int y, boolean direction, int range);
	public boolean checkPosDiagonal(int x, int y, int distance1, int distance2);
	// direction true ==> left and down, false --> right and up 
	public int negSlope(String[][] map, int x, int y, boolean direction, int range); 
	
	public boolean checkNegDiagonal(int x, int y, int distance1, int distance2);
}
