import java.util.*;

/**
 * I put some codes I wrote in ticTacToe.java file which can give some tips I
 * think. You can just delete codes or functions I wrote if you come up with
 * some other methods to finish the requirements.
 */

public class ticTacToe {

	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

	public static void main(String[] args) {
		// create a game board as 2d array
		char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' }, 
				               { '-', '+', '-', '+', '-' }, 
				               { ' ', '|', ' ', '|', ' ' },
				               { '-', '+', '-', '+', '-' }, 
				               { ' ', '|', ' ', '|', ' ' }, };

		printGameBoard(gameBoard);

		// loop to repeat the game
		while (true) {
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter your placement (1-9): ");
			int playerPos = scan.nextInt();
			// write your code here
			while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
				playerPos = scan.nextInt();
			}
			placePiece(gameBoard, playerPos, "player");
			String result = checkWinner();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}
			Random rand = new Random();
			int cpuPos = rand.nextInt(9) + 1;
			// loop randomizes cpu position
			while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
				System.out.println("position taken!");
				cpuPos = rand.nextInt(9) + 1;
			}
			placePiece(gameBoard, cpuPos, "cpu");

			printGameBoard(gameBoard);

			String result1 = checkWinner();
			if (result1.length() > 0) {
				System.out.println(result1);
				break;
			}

		}

	}

	public static void printGameBoard(char[][] gameBoard) {
		// write your code here
		for (char[] row : gameBoard) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

	public static void placePiece(char[][] gameBoard, int pos, String user) {

		char symbol = ' ';
		if (user.equals("player")) {
			symbol = 'X';
			playerPositions.add(pos);
		} else if (user.equals("cpu")) {
			symbol = 'O';
			cpuPositions.add(pos);
		}

		// write your code here
		switch(pos){
		case 1: 
			gameBoard[0][0] = symbol;
			break;
		case 2: 
			gameBoard[0][2] = symbol;
			break;
		case 3: 
			gameBoard[0][4] = symbol;
			break;
		case 4: 
			gameBoard[2][0] = symbol;
			break;
		case 5: 
			gameBoard[2][2] = symbol;
			break;
		case 6: 
			gameBoard[2][4] = symbol;
			break;
		case 7: 
			gameBoard[4][0] = symbol;
			break;
		case 8: 
			gameBoard[4][2] = symbol;
			break;
		case 9: 
			gameBoard[4][4] = symbol;
			break;
		default:
			break;
}
	}

	public static String checkWinner() {
		// write your code here
		List<Integer> topRow = Arrays.asList(1, 2, 3);
		List<Integer> midRow = Arrays.asList(4, 5, 6);
		List<Integer> botmRow = Arrays.asList(7, 8, 9);
		List<Integer> leftCol = Arrays.asList(1, 4, 7);
		List<Integer> midCol = Arrays.asList(2, 5, 8);
		List<Integer> rightCol = Arrays.asList(3, 6, 9);
		List<Integer> cross1 = Arrays.asList(1, 5, 9);
		List<Integer> cross2 = Arrays.asList(7, 5, 3);
		
		List<List<Integer>>winning = new ArrayList<List<Integer>>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botmRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List<Integer> l: winning) {
			if(playerPositions.containsAll(l)) {
				return "Congratulations you won!";
			}else if(cpuPositions.containsAll(l)) {
				return "CPU wins! Sorry:(";
			}else if(playerPositions.size() + cpuPositions.size() == 0) {
				return "CAT!";
			}
		}
		return "";
	}

}