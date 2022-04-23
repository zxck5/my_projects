package model;

import chessGame.ChessBoard;
import chessGame.PieceManager;

public class Knight extends Piece{

	public Knight(int x, int y, boolean color, String name) {
		super(x, y, color, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(int moveX, int moveY) {
        String[][] map = ChessBoard.getBoard();
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        System.out.println("moveX=" + moveX);
        System.out.println("moveY=" + moveY);

            if ((x - 1 == moveX && y - 2 == moveY)
                    || (x - 2 == moveX && y - 1 == moveY)
                    || (x - 1 == moveX && y + 2 == moveY)
                    || (x - 2 == moveX && y + 1 == moveY)
                    || (x + 1 == moveX && y + 2 == moveY)
                    || (x + 2 == moveX && y + 1 == moveY)
                    || (x + 1 == moveX && y - 2 == moveY)
                    || (x + 2 == moveX && y - 1 == moveY)) {
                if (isBlank(map, moveX, moveY)) {
                    System.out.println("can move!!");
                    return true;
                } else {
                    if (isEatable(map, moveX, moveY)) {
                        return true;
                    }
                }
            }
        return false;

    }

    @Override
    public void moveTo(int moveX, int moveY) {
        // TODO Auto-generated method stub
        String map[][] = ChessBoard.getBoard();
        map[moveY][moveX] = map[y][x];
        map[y][x] = null;
        x = moveX;
        y = moveY;
    }

    @Override
    public boolean isEatable(String[][] map, int moveX, int moveY) {
	return PieceManager.getMap().get(map[moveY][moveX]).getColor() != super.getColor();

    }

    @Override
    public boolean isBlank(String[][] map, int moveX, int moveY) {
        return map[moveY][moveX] == null;
    }

}