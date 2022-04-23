package model;

public interface CheckHorizontal {
	public int rangeX(String[][] map, int x, boolean direction);
	public boolean checkHorizontal(int x,int y, int rightRange, int leftRange);
}
