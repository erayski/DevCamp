package GreenVsRedGame;
import java.util.*;


class Game {
	/**
	 *     @author EraySeyhan
	 *
	 *    The method play  is to find cells to update and add to the coordinatesToUpdate
	 *    find neighbours , restrictions: when adding or subtracting RESULT cannot be negative or bigger than y1 and x1  and update the grid and print ceellGreenCount
	 *
	 *
	 *
	 *      @param grid This is the first paramter to class game
	 * 		@param x1  This is the second paramter
	 * 		@param y1  This is paramter
	 * 	    @param x  This is paramter
	 * 		@param y  This is paramter
	 * 		@param generationCount  This is paramter
	 * 		@param cellGreenCount  This is paramter
	 * 		@param ArrayList with  coordinatesToUpdate
	 *
	 * 	**/
	private int[][] grid;
	private int x1;
    private int y1;
    private int x;
    private int y;
    private int generationCount;
	private int cellGreenCount;
	private ArrayList<Integer> coordinatesToUpdate;
	
	Game(int[][] grid, int x1, int y1, int generationCount, int x, int y) {
		this.grid = grid;
		this.x1 = x1;
		this.y1 = y1;
		this.generationCount = generationCount;
		this.x = x;
		this.y = y;
		this.coordinatesToUpdate = new ArrayList<>();
	}
	
	public void play() {
		for (int i = 0; i <= generationCount; i++) {
			if (grid[y1][x1] == 1){
				cellGreenCount++;
			}
			// find cells to update and add to the coordinatesToUpdate
			for (int j = 0; j < y; j++) {
				for (int k = 0; k < x; k++) {
					int item = grid[j][k];
					int greencount = 0;
					//find neighbours 
					//(j, x-1), (j-1, x-1), (j-1, x), (j-1, x+1), (j, x+1), (j+1, x+1), (j+1, x), (j+1, x-1)
					//restrictions: when adding or subtracting RESULT cannot be negative or bigger than y1 and x1 
					if (k-1 >= 0) {
						int neighbour = grid[j][k-1];
						if (neighbour == 1) {
							greencount++;
						}
					}
					if (j-1 >= 0 && k-1 >= 0){
						int neighbour = grid[j-1][k-1];
						if (neighbour == 1) {
							greencount++;
						}
					}
					if (j-1 >= 0){
						int neighbour = grid[j-1][k];
						if (neighbour == 1) {
							greencount++;
						}
					}
					if (j-1 >= 0 && k+1 < x){
						int neighbour = grid[j-1][k+1];
						if (neighbour == 1) {
							greencount++;
						}
					}
					if (k+1 < x){
						int neighbour = grid[j][k+1];
						if (neighbour == 1) {
							greencount++;
						}
					}
					if (j+1 < y && k+1 < x){
						int neighbour = grid[j+1][k+1];
						if (neighbour == 1) {
							greencount++;
						}
					}
					if (j+1 < y){
						int neighbour = grid[j+1][k];
						if (neighbour == 1) {
							greencount++;
						}
					}
					if (j+1 < y && k-1 >= 0){
						int neighbour = grid[j+1][k-1];
						if (neighbour == 1) {
							greencount++;
						}
					}
					//check if update needed
					if (item == 0){
						if (greencount == 3 || greencount == 6) {
							coordinatesToUpdate.add(j);
							coordinatesToUpdate.add(k);
						}
					} else {
						if(greencount != 2 && greencount != 3 && greencount != 6) {
							coordinatesToUpdate.add(j);
							coordinatesToUpdate.add(k);
						}
					}
				}
			}
			// update the grid
			for (int a = 0; a < coordinatesToUpdate.size(); a += 2) {
				if (grid[coordinatesToUpdate.get(a)][coordinatesToUpdate.get(a+1)] == 1) {
					grid[coordinatesToUpdate.get(a)][coordinatesToUpdate.get(a+1)] = 0;
				} else {
					grid[coordinatesToUpdate.get(a)][coordinatesToUpdate.get(a+1)] = 1;
				}
			}
			coordinatesToUpdate.clear();
		}
		System.out.print(cellGreenCount);
	}
}
