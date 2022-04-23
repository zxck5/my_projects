package model;

import chessGame.ChessBoard;
import chessGame.PieceManager;

public class Bishop extends Piece implements  CheckDiagonal{

	public Bishop(int x, int y, boolean color, String name) {
		super(x, y, color, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(int moveX, int moveY) {
		
		String[][] map = ChessBoard.getBoard();
		//setting up range
		int d1 = 0; int d2 = 0;
		
		if (checkPosDiagonal(moveX,moveY,d1,d2) || checkNegDiagonal(moveX,moveY,d1,d2) ) {
			if (isBlank(map,moveX,moveY)) {
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
	public int posSlope(String[][] map, int x, int y, boolean direction, int range) {
		// TODO Auto-generated method stub
		
		if (direction) {
			if (x+1 > 7 || y+1 > 7) return range;
			y ++; x++;
		} else {
			if (x-1 < 0 || y-1 < 0) return range;
			y --; x--;
		}
		if (map[y][x] != null) return range+1;
		
		return posSlope(map,x,y,direction,range+1);
		
	}

	@Override
	public boolean checkPosDiagonal(int moveX, int moveY, int d1, int d2) {
		// TODO Auto-generated method stub
		d1 = posSlope(ChessBoard.getBoard(),x,y,true,0); // if true, right(+) and down(+) 
		d2 = posSlope(ChessBoard.getBoard(),x,y,false,0);// false , left(-), up(-)
		if (x == moveX) return false;
		if ((y-moveY)/(x-moveX) != 1) return false; 
			
		if ( x-d2 <= moveX && moveX <= x+d1) {
			if ( y-d2 <= moveY  && moveY <=y+d1) {
					return true;
			}
		}
		
		
		return false;
	}

	@Override
	public int negSlope(String[][] map, int x, int y, boolean direction, int range) {
		// TODO Auto-generated method stub
		if (direction) {
			if (x-1 < 0 || y+1 > 7) return range;
			y ++; x--;
		} else {
			if (x+1 > 7 || y-1 < 0) return range;
			y --; x++;
		}
		if (map[y][x] != null) return range+1;
		
		return negSlope(map,x,y,direction,range+1);
	}

	@Override
	public boolean checkNegDiagonal(int moveX, int moveY, int d1, int d2) {
		// TODO Auto-generated method stub
		d1 = negSlope(ChessBoard.getBoard(),x,y,true,0); // if true, left(-) and down(+) 
		d2 = negSlope(ChessBoard.getBoard(),x,y,false,0);// false , right(+), up(-)
		if (x == moveX) return false;
		if ((y-moveY)/(x-moveX) != -1) return false; 
		
		if ( x-d1 <= moveX && moveX <= x+d2) {
			if ( y-d2 <= moveY  && moveY <=y+d1) {
					return true;
			}
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
	public void moveTo(int moveX, int moveY) {
		// TODO Auto-generated method stub
		String map [][] = ChessBoard.getBoard();
		map[moveY][moveX] = map[y][x];
		map[y][x] = null;
		x = moveX; y = moveY;
		
	}


	

	
	
}
