package model;

import chessGame.ChessBoard;
import chessGame.PieceManager;


public class Pawn extends Piece {
	
	public Pawn(int x, int y, boolean color, String name) {
		super(x, y, color, name);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean canMove(int moveX, int moveY) {
		String map [][] = ChessBoard.getBoard();
		// TODO Auto-generated method stub
		int direction = 1; 
		//if color is black
		if (super.getColor()) direction *= -1;
		System.out.println("moveY="+moveY);
		System.out.println("moveX= "+ moveX);
		// can it move diagonally? is the place where you would go is null?
		if (!isBlank(map,moveX,moveY)) { // when it is not null, when there is a piece front of the pawn
			if (isEatable(map,moveX,moveY) && canDiagonal(moveX, moveY, direction)) return true;
		} else { // can it move straight forward? when there is no piece in front of the pawn
			
			if (y == originPlace()) { // if x is in orgin place, pawn may move two blocks
				if(canStraight(moveX,moveY,direction,2)) return true; // giving 2 blocks available to move
			}
			if (canStraight(moveX,moveY,direction,1)) return true;
		} 
		return false;
		
	}
	// for origin place of the pawn
	public int originPlace() {
		if (super.getColor()) return 6; // if it is white pawn and the location is in row 6, it may move 2 blocks
		else return 1;// if it is black pawn and the location is in row 1, it may move 2 blocks
	}
	public boolean canDiagonal(int moveX, int moveY, int direction) {
		if (moveY == y+1*direction && (moveX == x+1) || (moveX == x-1)) {
			System.out.println("diagonal");
			return true;
		} 
		return false;
	}
	public boolean canStraight(int moveX, int moveY, int direction, int amount) {
		if (moveY == y+amount*direction && moveX == x) {
			System.out.println("straight");
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
	@Override
	public boolean isEatable(String[][] map, int moveX, int moveY) {
		// TODO Auto-generated method stub
		return PieceManager.getMap().get(map[moveY][moveX]).getColor() != super.getColor();
		
	}
	@Override
	public boolean isBlank(String[][] map, int moveX, int moveY) {
		// TODO Auto-generated method stub
		return map[moveY][moveX] == null;
	}

}
