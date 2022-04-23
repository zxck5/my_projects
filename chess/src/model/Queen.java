package model;

import chessGame.ChessBoard;
import chessGame.PieceManager;

public class Queen extends Piece implements CheckHorizontal, CheckDiagonal, CheckVertical{

	public Queen(int x, int y, boolean color, String name) {
		super(x, y, color, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(int moveX, int moveY) {
		
		String[][] map = ChessBoard.getBoard();
		//setting up range
		int rightXrange = rangeX(map,x,true); //positive range on x-axis
		int leftXrange = rangeX(map,x,false);// negative range on x-axis
		int upYrange = rangeY(map,y,false);
		int downYrange = rangeY(map,y,true);
		
		int d1 = 0; int d2 = 0;
		
		if (checkPosDiagonal(moveX,moveY,d1,d2) || checkNegDiagonal(moveX,moveY,d1,d2) || checkHorizontal(moveX,moveY,rightXrange,leftXrange) || checkVertical(moveX,moveY,upYrange,downYrange) ) {
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
	public boolean checkHorizontal(int moveX,int moveY,int rightXrange, int leftXrange) {
		// TODO Auto-generated method stub
		
		
		if (moveX >= leftXrange && moveX <= rightXrange && moveY == y) {
			return true;
		}
		return false;
	}
	@Override
	public boolean checkVertical(int moveX,int moveY, int upYrange, int downYrange) {
		// TODO Auto-generated method stub
		
		if (moveY <= downYrange && moveY >= upYrange && moveX == x) {
			System.out.println("hello");
			
			return true;
		}
		
		return false;
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
