package model;

import chessGame.ChessBoard;
import chessGame.PieceManager;

public class Rook extends Piece implements CheckVertical,CheckHorizontal{

	public Rook(int x, int y, boolean color, String name) {
		super(x, y, color, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(int moveX, int moveY) {
		// TODO Auto-generated method stub
		String[][] map = ChessBoard.getBoard();
		//setting up range
		int rightXrange = rangeX(map,x,true); //positive range on x-axis
		int leftXrange = rangeX(map,x,false);// negative range on x-axis
		int upYrange = rangeY(map,y,false);
		int downYrange = rangeY(map,y,true);
		System.out.println("moveX="+moveX);
		System.out.println("moveY="+moveY);
		System.out.println("rightXrange"+rightXrange);
		System.out.println("leftXrange"+leftXrange);
		System.out.println("upYrange"+upYrange);
		System.out.println("downYrange"+downYrange);
		
		
		
		
		if (checkVertical(moveY,moveX, upYrange, downYrange) || checkHorizontal(moveX,moveY, rightXrange, leftXrange)) {
			if(isBlank(map, moveX, moveY)) {
				return true;
			} else {
				if (isEatable(map,moveX,moveY)) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean checkHorizontal(int moveX,int moveY,int rightXrange, int leftXrange) {
		// TODO Auto-generated method stub
		if (moveX >= leftXrange && moveX <= rightXrange && moveY == y) {
			return true;
		}
		return false;
	}
	@Override
	public boolean checkVertical(int moveY,int moveX, int upYrange, int downYrange) {
		// TODO Auto-generated method stub
		if (moveY <= downYrange && moveY >= upYrange && moveX == x) {
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean isBlank(String[][] map, int moveX, int moveY) {
		return map[moveY][moveX] == null;
	}
	
//	public void 
	@Override
	public boolean isEatable(String[][] map, int moveX, int moveY) {
		return PieceManager.getMap().get(map[moveY][moveX]).getColor() != super.getColor();
	}
	
	@Override
	public int rangeX(String[][] map, int x, boolean direction) {
		if (direction) {
			if (x+1> 7) return x;	
			x ++;
		} else {
			if (x-1 < 0) return x;
			x --;
		}
		
		if (map[y][x] != null) return x;
		return rangeX(map,x,direction);
	}

	
	
	
	@Override
	public int rangeY(String[][]map, int y, boolean direction) {
		if (direction) {
			if (y+1>7) return y;
			y ++;
		}else {
			if (y-1 < 0) return y;
			y --;
		}
		if (map[y][x] != null) return y;
		return rangeY(map,y,direction);
	}
	
	
	
	@Override
	public void moveTo(int moveX, int moveY) {
		// TODO Auto-generated method stub
		String map [][] = ChessBoard.getBoard();
		map[moveY][moveX] = map[y][x];
		map[y][x] = null;
		x = moveX; y = moveY;
		
	}

	

	


}
