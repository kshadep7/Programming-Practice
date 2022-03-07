import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GravityBoxSimulation {

	public static void main(String[] args) {

		char[][] board = {
				{'#', '.', '#', '#', '*'},
				{'#', '.', '.', '#', '#'},
				{'.', '#', '.', '#', '.'},
				{'.', '.', '#', '.', '#'},
				{'#', '*', '.', '.', '.'},
				{'.', '.', '*', '#', '.'}
		};

		char[][] out = fallAndCrush(board);
		for (char[] arr : out)
			System.out.println(Arrays.toString(arr));
	}


	public static char[][] fallAndCrush(char[][] board) {
		char[][] outBoard = new char[board.length][board[0].length];
		Queue<Coordinate> queue = new LinkedList<>();
		int programCounter = board[0].length * board.length * 2;
		for (int j = 0; j < board[0].length; j++) {
			for (int i = board.length - 1; i >= 0; i--) {
				Coordinate curr = new Coordinate(i, j);
				if (board[i][j] == '#') {
					queue.add(curr);
				}
				outBoard[i][j] = board[i][j];
			}
		}

//		for (int i = 0; i < outBoard.length; i++) {
//			System.out.println(Arrays.toString(outBoard[i]));
//		}
//		System.out.println(queue);

		while (programCounter > 0) {
			Coordinate curr = queue.remove();
			if (outBoard[curr.i][curr.j] == '.') {
				continue;
			}
			if (outBoard[curr.i][curr.j] == '*' && !curr.isMoving) { //when a 'pound' hits a bomb we still put it in the queue, then when everything is not moving we evaluate what gets eliminated
				eliminate(outBoard, curr.i, curr.j);
			} else if (outBoard[curr.i][curr.j] == '#' && curr.isMoving && (curr.i != board.length - 1 && outBoard[curr.i + 1][curr.j] != '#')) { //if the current 'pound' block is not blocked and everything else is moving
				outBoard[curr.i][curr.j] = '.';
				if (outBoard[curr.i + 1][curr.j] != '#') {
					curr.i++;
				}
				if (outBoard[curr.i][curr.j] == '.') {
					outBoard[curr.i][curr.j] = '#';
				}
			}
			if (outBoard[curr.i][curr.j] == '#' || (outBoard[curr.i][curr.j] == '*' && curr.isMoving)) {
				curr.isMoving = !curr.isMoving; //everything moves and stops moving at the same time with this flag as everything is put into the queue in order
				queue.add(curr);
			}
			programCounter--;
		}
		return outBoard;
	}

	protected static void eliminate(char[][] board, int i, int j) {
		if (j > 0 && board[i][j - 1] == '#') {
			board[i][j - 1] = '.';
		}
		if (j < board[0].length - 1 && board[i][j + 1] == '#') {
			board[i][j + 1] = '.';
		}
		if (j > 0 && i > 0 && board[i - 1][j - 1] == '#') {
			board[i - 1][j - 1] = '.';
		}
		if (j < board[0].length - 1 && i > 0 && board[i - 1][j + 1] == '#') {
			board[i - 1][j + 1] = '.';
		}
		if (i < board.length - 1 && board[i + 1][j] == '#') {
			board[i + 1][j] = '.';
		}
		if (j > 0 && i < board.length - 1 && board[i + 1][j - 1] == '#') {
			board[i + 1][j - 1] = '.';
		}
		if (j < board[0].length - 1 && i < board.length - 1 && board[i + 1][j + 1] == '#') {
			board[i + 1][j + 1] = '.';
		}
	}
}

class Coordinate {
	int i;
	int j;
	boolean isMoving = true;

	Coordinate(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
