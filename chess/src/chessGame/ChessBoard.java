package chessGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChessBoard {
	private static ChessBoard chessBoard;
	private static String[][] board;
	private BufferedReader br; 
	private StringTokenizer st;
	private ChessBoard() {}
	private static boolean exception;
	
	
	public void startGame(PieceManager pieceMan) throws IOException, ClassNotFoundException {
		boolean turn = true;
		while (true) {
			printBoard();
			System.out.println("choose your piece ex) WR1 --> white rook" );
			br = new BufferedReader(new InputStreamReader(System.in));
			if (turn) {
				turn = userInput(pieceMan,turn);
			} else {
				System.out.println("-----------------------------Black's Turn------------------------------------");
				turn = userInput(pieceMan,turn);
			}
		}
	}

	public boolean userInput(PieceManager pieceMan, boolean turn) throws IOException, NumberFormatException, ClassNotFoundException {
//		st = new StringTokenizer(br.readLine());
//		int cur_x = Integer.parseInt(st.nextToken());
//		int cur_y = Integer.parseInt(st.nextToken());
//		while (!PieceManager.getMap().containsKey(board[cur_y][cur_x])) {
//			System.out.println("please try again");
//			continue;
//		}
		String input;//
		while (true) {
			while(!PieceManager.getMap().containsKey(input=(br.readLine())) ) {
				System.out.println("please type it again");
			}
			if (PieceManager.getMap().get(input).getColor() == turn) break; // white's turn
			else System.out.println("choose your own piece");
		}
		System.out.println("where you want to go? : type coordinates x(col), y(row) --> ex) a1 --> (0,0)");
		
//		st = new StringTokenizer(br.readLine());
		String a = br.readLine(); //a1...
		int x = a.charAt(0)-97;// a - 97 = 0
		int y = (board.length-1)-(a.charAt(1)-49);
		System.out.println("x="+x);
		System.out.println("y="+y);
		while (x > 7 || x < 0 || y > 7 || y < 0) {
			System.out.println("try again");
			a = br.readLine(); //a1...
			x = a.charAt(0)-97;// a - 97 = 0
			y = (board.length-1)-(a.charAt(1)-49);
			
		}
		
		if(!pieceMan.validatePiece(board[y][x],PieceManager.getMap().get(input),x,y)) {
			System.out.println("invalid move");
			return turn;
		}
		return !turn; // white's turn --> true -> false

	}

	public static void initChessBoardMan() {
		// TODO Auto-generated method stub
		chessBoard = new ChessBoard();
		board = new String[8][8];
		
		exception = false;
		String [] whiteSample = {"WR1","WKn1","WV1","WK","WQ","WV2","WKn2","WR2",
		"WP1","WP2","WP3","WP4","WP5","WP6","WP7","WP8"}; 
		for (int i = 0; i < 8; i++) {
			board[7][i] = whiteSample[i];
		}
		for (int i = 0; i < 8 ; i++) {
			board[6][i] = whiteSample[i+8];
		}
		
		String [] blackSample = {"BR1","BKn1","BV1","BK","BQ","BV2","BKn2","BR2",
		"BP1","BP2","BP3","BP4","BP5","BP6","BP7","BP8"}; 
		for (int i = 0; i < 8; i++) {
			board[0][i] = blackSample[i];
		}
		for (int i = 0; i < 8; i++) {
			board[1][i] = blackSample[i+8];
		}
		whiteSample = null;
		blackSample = null;
		
	}
	public void printBoard() {
		int black = 8;
		for (int i = 0; i < board.length; i ++) {
			
			System.out.print(black + " ");
			for (int k = 0; k < board.length; k ++) {
				
				if (board[i][k] == null ) System.out.print("ㅁ\t");
				else System.out.print(board[i][k]+"\t");
			}
			System.out.println();
			black --;
		}
		System.out.print("  a");
		char initChar = 'a';
		for (int i = 1; i < board.length; i++) {
			System.out.print("\t"+(char)(initChar+i));
			 
		}
		System.out.println();
	}
	
	
	public static void setException(boolean ex) {
		exception = ex;
	}


	public static String[][] getBoard() {
		return board;
	}

	public static ChessBoard getChessBoard() {
		return chessBoard;
	}
	
	
	
}
