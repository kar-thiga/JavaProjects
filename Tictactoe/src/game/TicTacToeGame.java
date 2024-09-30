package game;

import java.util.Scanner;

public class TicTacToeGame {
	
	private char board[][];
	private char currentPlayer;
	
	public TicTacToeGame() {
		board = new char[3][3];
		currentPlayer = 'X';
		initializeBoard();
	}
	
	public void initializeBoard() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j]='-';
			}
			
		}
			
	}
	
	public void printBoard() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
			
	}
	
	public boolean isValidMove(int row , int col) {
		return row >= 0 && row < 3 && col >=0 && col <3 && board[row][col] == '-';
	}
	
	public void makeMove(int row,int col) {
		if(isValidMove(row,col)) {
		  
			board[row][col] = currentPlayer;
			if(isWin()) {
				System.out.println("Game is won by " + currentPlayer);
				printBoard();
				System.exit(0);
			}else if(isBoardFull(board)) {
				System.out.println("Game is Tie!!");
				printBoard();
				System.exit(0);
			}
			switchPlayer();
			
		}else {
			System.out.print("Move is Invalid ,Please Enter Valid move");
		}
	}

	
	
	public boolean isWin() {
		
		for(int i=0;i<3;i++) {
			if(board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer ||
		       board[i][0] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer	) {
				return true;
			}
		}
		
		if(board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer ||
		   board[2][0] == currentPlayer && board[1][1] == currentPlayer && board[0][2] == currentPlayer	) {
		    return true;
		}
		return false;
	}
	
	public boolean isBoardFull(char[][] board){
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(board[i][j] == '-')
					return false;
			}
		}
		return true;
	}
	
	public void switchPlayer() {
		currentPlayer = (currentPlayer == 'X') ? 'O': 'X';
	}
	

	public static void main(String[] args) {

		
		Scanner scanner = new Scanner(System.in);
		TicTacToeGame game = new TicTacToeGame();
		game.printBoard();
        while (true) {
            System.out.println("Player " + game.currentPlayer + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            game.makeMove(row, col);
            game.printBoard();
        }
	}

}


