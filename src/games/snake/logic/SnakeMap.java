package games.snake.logic;

import java.util.Random;

import general.logic.Cell;
import general.logic.GraphicCell;
import general.logic.Map;

public class SnakeMap extends Map{

	protected Cell food;
	protected Random rndRow;
	protected Random rndColumn;
	protected int totalOccupiedCells;
	
	public SnakeMap(SnakeGame snakeGame) {
		super(snakeGame);
		rndRow = new Random();
		rndColumn = new Random();
		totalOccupiedCells = 3;
	}
	
	public boolean isFood(Cell cell) {
		return food.equals(cell);
	}
	
	public void putFood() {
		int r = 0;
		int c = 0;
		boolean stop = false;
		
		if(totalOccupiedCells == ROW * COLUMN)
			game.win();
		else {
			while(!stop) { 
				r = Math.abs(rndRow.nextInt()) % 9;
				c = Math.abs(rndColumn.nextInt()) % 16;
				if(matrix[r][c].isFree()) {
					food = matrix[r][c];
					food.put(new GraphicCell(game.getImageFactory().getSquircle(), game.getImageFactory().getColorRandom()));
					stop = true;
					totalOccupiedCells++;
				}
			}
		}
	}
	
}