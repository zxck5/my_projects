package chessGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import model.Bishop;
import model.King;
import model.Knight;
import model.Pawn;
import model.Piece;
import model.Queen;
import model.Rook;

public class PieceManager {
	// PiecesManager has -a relationship Pieces class
	private static ArrayList<Piece> piecesArr;
	private static HashMap<String,Piece> map;
	
	// singleton
	private static PieceManager pieceMan;
	
	private PieceManager() {}	
	// initalizing single manager
	public static void initPieceMan () {
		pieceMan = new PieceManager();
		// when it is initalized, array is created
		piecesArr = new ArrayList<Piece>();
		// map is created
		map = new HashMap<>();
		pushMap();
		for (String keys : map.keySet()) {
			piecesArr.add(map.get(keys));
		}
		
	}
	public static PieceManager getPieceMan() {
		return pieceMan;
	}
	public static ArrayList<Piece> getPiecesArr() {
		return piecesArr;
	} 
	public static HashMap<String,Piece> getMap() {
		return map;
	}
	
	public boolean validatePiece(String pieceName, Piece piece, int x, int y) throws ClassNotFoundException, NumberFormatException, IOException {
		// TODO Auto-generated method stub
		if ((piece).canMove(x, y)){
			piece.moveTo(x, y);
			System.out.println(piece);
			return true;
		} else {
			return false;
		}
		
		
//		if(isRook(piece)) {
//			System.out.println("Rook");
//			if ((piece).canMove(x, y)){
//				piece.moveTo(x, y);
//				System.out.println(piece);
//				return true;
//			} else {
//				return false;
//			}
//		}
//		if(isPawn(piece)) {
//			System.out.println("pawn");
//			if(((Pawn)piece).canMove(x, y)) {
//				((Pawn)piece).moveTo(x, y);
//				System.out.println("moved!!");
//				return true;
//			} else {
//				return false;
//			}
//		}
//		if(isKnight(piece)) {
//			System.out.println("knight");
//			if (((Knight)piece).canMove(x, y)) {
//				((Knight)piece).moveTo(x, y);
//				return true;
//			} else {
//				return false;
//			}
//		}
//		if(isBishop(piece)) {
//			System.out.println("bishop");
//			if (((Bishop)piece).canMove(x, y)) {
//				((Bishop)piece).moveTo(x, y);
//				return true;
//			} else {
//				return false;
//			}
//		}
//		if(isKing(piece)) {
//			System.out.println("King");
//			if(((King)piece).canMove(x, y)) {
//				((King)piece).moveTo(x, y);
//				return true;
//			} else {
//				return false;				
//			}
//		}
//		if(isQueen(piece)) {
//			System.out.println("Queen");
//			if(((Queen)piece).canMove(x, y)) {
//				((Queen)piece).moveTo(x, y);
//				return true;
//			}
//			return false;
//		}
//		return false;
//		
	}

	
	public boolean isPawn(Piece piece) throws ClassNotFoundException {
		return Pawn.class.isInstance(piece);
	}
	public boolean isKnight(Piece piece) throws ClassNotFoundException {
		return Knight.class.isInstance(piece);
	}
	public boolean isBishop(Piece piece) throws ClassNotFoundException {
		return Bishop.class.isInstance(piece);
	}
	public boolean isKing(Piece piece) throws ClassNotFoundException {
		return King.class.isInstance(piece);
	}
	public boolean isQueen(Piece piece) throws ClassNotFoundException {
		return Queen.class.isInstance(piece);
	}
	public boolean isRook(Piece piece) throws ClassNotFoundException {
		return Rook.class.isInstance(piece);
	}
	
	
	
	private static void pushMap() {
		String [] whiteSample = {"WR1","WKn1","WV1","WK","WQ","WV2","WKn2","WR2",
				"WP1","WP2","WP3","WP4","WP5","WP6","WP7","WP8"};
		
		map.put(whiteSample[0], new Rook(0,7,true,"Rook")); // x(col)= 0 , y(row) = 7
		map.put(whiteSample[1], new Knight(1,7,true,"Knight")); // x(col)= 1 , y(row) = 7
		map.put(whiteSample[2], new Bishop(2,7,true,"Bishop")); // x(col)= 2 , y(row) = 7
		map.put(whiteSample[3], new King(3,7,true,"King")); // x(col)= 3 , y(row) = 7
		map.put(whiteSample[4], new Queen(4,7,true,"Queen")); // x(col)= 4 , y(row) = 7
		map.put(whiteSample[5], new Bishop(5,7,true,"Bishop")); // x(col)= 5 , y(row) = 7
		map.put(whiteSample[6], new Knight(6,7,true,"Knight")); // x(col)= 6 , y(row) = 7
		map.put(whiteSample[7], new Rook(7,7,true,"Rook")); // x(col)= 7 , y(row) = 7
		for (int i = 8; i < whiteSample.length; i ++) {
			map.put(whiteSample[i], new Pawn(i-8,6,true,"Pawn"));
		}
			
		String [] blackSample = {"BR1","BKn1","BV1","BK","BQ","BV2","BKn2","BR2",
				"BP1","BP2","BP3","BP4","BP5","BP6","BP7","BP8"}; 
		map.put(blackSample[0], new Rook(0,0,false,"Rook")); // x(col)= 0 , y(row) = 7
		map.put(blackSample[1], new Knight(1,0,false,"Knight")); // x(col)= 1 , y(row) = 7
		map.put(blackSample[2], new Bishop(2,0,false,"Bishop")); // x(col)= 2 , y(row) = 7
		map.put(blackSample[3], new King(3,0,false,"King")); // x(col)= 3 , y(row) = 7
		map.put(blackSample[4], new Queen(4,0,false,"Queen")); // x(col)= 4 , y(row) = 7
		map.put(blackSample[5], new Bishop(5,0,false,"Bishop")); // x(col)= 5 , y(row) = 7
		map.put(blackSample[6], new Knight(6,0,false,"Knight")); // x(col)= 6 , y(row) = 7
		map.put(blackSample[7], new Rook(7,0,false,"Rook")); // x(col)= 7 , y(row) = 7
		for (int i = 8; i < blackSample.length; i ++) {
			map.put(blackSample[i], new Pawn(i-8,1,false,"Pawn"));
		}
		whiteSample = null;
		blackSample = null;
	}
	
}
