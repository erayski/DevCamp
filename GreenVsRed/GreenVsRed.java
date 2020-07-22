package GreenVsRedGame;
import java.io.*;
/** @author EraySeyhan
 *  @class GreenVsRed implements an application that create grid with elements **/
class GreenVsRed {
	public static void main(String[] args) throws IOException{
		/**
		 *  @exception IOException On input error.
		 * 	@see IOException
		 *
		 * 	@First reading entries from console and save then in String dimensions
		 * 	@param X This is the first paramter to dimensions
		 * 	@param Y  This is the second parameter to dimensions
		 * 	@param We create a grid parameter with the values of X , Y
		 *  @through method  for we create rowItems and read console and save in param grid item
		 *
 		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] dimensions = br.readLine().split(", ");

		int x = Integer.parseInt(dimensions[0]);
		int y = Integer.parseInt(dimensions[1]);
		
		int[][] grid = new int[y][x];
		
		for (int i = 0; i < y; i++) {
			String[] rowItems = br.readLine().split("");
			for (int j = 0; j < x; j++) {
				int item = Integer.parseInt(rowItems[j]);
				grid[i][j] = item;
			}
		}
		/** @method String create coordinatesAndGenerationCount reading entrities from console
		 * @param X1 This is paramter to coordinatesAndGenerationCount
		 * @param Y2  This is paramter to coordinatesAndGenerationCount
		 * */
		String[] coordinatesAndGenerationCount = br.readLine().split(", ");
		int x1 = Integer.parseInt(coordinatesAndGenerationCount[0]);
		int y1 = Integer.parseInt(coordinatesAndGenerationCount[1]);
		int generationCount = Integer.parseInt(coordinatesAndGenerationCount[2]);
		
		Game game = new Game(grid, x1, y1, generationCount, x, y);
		game.play();
	}
}
