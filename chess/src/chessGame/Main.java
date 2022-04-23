package chessGame;

import java.io.IOException;

public class Main {
	
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		PieceManager.initPieceMan();
		ChessBoard.initChessBoardMan();

		ChessBoard chessBoard = ChessBoard.getChessBoard();
		PieceManager pieceMan = PieceManager.getPieceMan();
		chessBoard.startGame(pieceMan);
		
	}
}
