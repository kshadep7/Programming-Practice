package Hard;

import java.util.HashSet;

interface Robot {
	// returns true if next cell is open and robot moves into the cell.
	// returns false if next cell is obstacle and robot stays on the current cell.
	boolean move();

	// Robot will stay on the same cell after calling turnLeft/turnRight.
	// Each turn will be 90 degrees.
	void turnLeft();

	void turnRight();

	// Clean the current cell.
	void clean();
}

public class RoomRobotCleaner {

	Robot robot;
	//				 up 	  right   down 	  left		in this order
	int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) {

	}

	/*
	Idea:
	1. directions -> up right down left -> this order is important -> spiral movement
		1.1. always turn right thats y the above direction if you go always right the order of
			those directions are maintained
	2. using simple dfs will do the trick
	3. backtracking can be tricky
		3.1. we have to backtrack mmaintaing the same direction, like going back to previous cell
			and maintaining same direction of the robot.
		3.2. this can be achieved by doing this;
		3.3. go right -> right -> move -> right -> right
	4. dfs the entire thing untill all the cells are visited
	 */
	public void cleanRoom() {
		// start with (0,0) as starting cell and 0 as starting dir
		// dirs -> 0(up) 1(right) 2(down) 3(left)
		clean(robot, 0, 0, 0, new HashSet<String>());
	}

	private void clean(Robot robot, int x, int y, int d, HashSet<String> visited) {
		// mark visited curr cell
		visited.add(x + "," + y);
		//clean cell
		robot.clean();
		//check in all four dirs
		for (int i = 0; i < 4; i++) {
			// check new dir
//			move forward - move; orientation x
//			move right - turnRight, move; orientation (x + 1) % 4
//			move backward - turnRight, turnRight, move; orientation (x + 2) % 4
//			move left - turnRight, turnRight, turnRight, move;  orientation (x + 3) % 4

			int nx = dirs[d][0] + x;
			int ny = dirs[d][1] + y;
			// check if new cell is not visited and move to that cell
			if (!visited.contains(nx + "," + ny) && robot.move()) {
				//dfs
				clean(robot, nx, ny, d, visited);
				// if all dirs are visited go back to pre cell and maintain the dir
				goBack(robot);
			}
			// turn right
			robot.turnRight();
			//change dir, as we are always turning right so just adding 1 will do
			d = (d + 1) % 4;
		}

	}

	private void goBack(Robot robot) {
		robot.turnRight();
		robot.turnRight();
		robot.move();
		robot.turnRight();
		robot.turnRight();
	}
}
