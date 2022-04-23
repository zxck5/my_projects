package model;

public interface CheckVertical {
	public int rangeY(String[][]map, int y, boolean direction);
	public boolean checkVertical(int y,int x, int upRange, int downRange);
}
