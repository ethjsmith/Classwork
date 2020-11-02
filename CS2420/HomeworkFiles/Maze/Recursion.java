/**
 * 
 * @author
 * @version
 *
 */

public class Recursion {

	public static void main(String[] args){

		solveMaze("Maze1-easy.txt");
		solveMaze("Maze2-manyChoices.txt");
		solveMaze("Maze3-Large.txt");
		solveMaze("Maze4-No_Solution.txt");
		solveMaze("Maze5-Larger.txt");

	}
	
	
	//Probably not void, or 0 arguments
	public static void readMazeFromFile() {
		
	}

	//Probably not 0 arguments
	public static void printMaze() {
		
	}
	
	//This method is what the book calls the "driver" method
	public static void solveMaze(String filename){
		//setup all the variables correctly
		System.out.println("Working on maze " + filename);
		
		
		readMazeFromFile();
		printMaze();
		System.out.println("The starting location is: ");
		
		
		//For sure pass the x and y for the "S" location, and whatever data structure you are using to represent the maze
		mazeTraversal();
		
		System.out.println("\n\n");
	}

	/**
	 * You get to set the parameters to this method
	 * Think about what you need.
	 * A few suggestions:
	 * How does the method represent the maze
	 * How does the method know which square to look at?
	 * 
	 * Also - this is not just a single base case and a single recursive case.
	 * If the maze is solved by going left - there is a solution
	 * If the maze is solved by going right - there is a solution
	 * If the maze is solved by going up - there is  a solution
	 * If the maze is solved by going down - there is  a solution
	 * 
	 * Also, depending on how you go up, down, left, and right
	 * there might be several base cases, like, on a wall,
	 * on the start, on the end, on a trail already marked...
	 */

	public static boolean mazeTraversal(/*You probably need the maze, and an int for the current x and an int for the current y*/){
		//Note, you should not need any loops.  Your first instinct might be to add them, but ignore that instinct
		//Loops are for iteration, not recursion
		return false;
	}


}