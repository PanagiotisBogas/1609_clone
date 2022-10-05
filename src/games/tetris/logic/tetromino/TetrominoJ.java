package games.tetris.logic.tetromino;

import factory.Factory;
import games.tetris.logic.TetrisMap;
import general.logic.Map;

public class TetrominoJ extends Tetromino{
	
	/**
	* Create a new tetromino in the shape of an "J" with the TetrisMap and a factory.
	*/
	public TetrominoJ(TetrisMap tetrisMap, Factory factory) {
		super(tetrisMap, factory);
		tetromino[0] = this.tetrisMap.getCell(Map.COLUMN -2, 4);
		tetromino[1] = this.tetrisMap.getCell(Map.COLUMN -2, 5);
		tetromino[2] = this.tetrisMap.getCell(Map.COLUMN -2, 3);
		tetromino[3] = this.tetrisMap.getCell(Map.COLUMN -1, 3);
	}
	
	@Override
	protected void moveA() {
		this.movements[0].setRyC(0, 0);
		this.movements[1].setRyC(-1, -1);
		this.movements[2].setRyC(1, 1);
		this.movements[3].setRyC(0, 2);
	}
	
	@Override
	protected void moveB() {
		this.movements[0].setRyC(0, 0);
		this.movements[1].setRyC(1, -1);
		this.movements[2].setRyC(-1, 1);
		this.movements[3].setRyC(-2, 0);
	}
	
	@Override
	protected void moveC() {
		this.movements[0].setRyC(0, 0);
		this.movements[1].setRyC(1, 1);
		this.movements[2].setRyC(-1, -1);
		this.movements[3].setRyC(0, -2);
	}
	
	@Override
	protected void moveD() {
		this.movements[0].setRyC(0, 0);
		this.movements[1].setRyC(-1, 1);
		this.movements[2].setRyC(1, -1);
		this.movements[3].setRyC(2, 0);
	}
	
}
