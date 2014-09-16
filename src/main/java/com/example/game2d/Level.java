package com.example.game2d;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author Michal Leja Game Level
 */
public class Level extends Rectangle {

	private static final long serialVersionUID = 1L;

	/**
	 * defining block
	 * 
	 */
	public Block[][] block = new Block[50][50];

	/**
	 * Constructor fill place
	 * 
	 */
	public Level() {

		for (int x = 0; x < block.length; x++) {

			for (int y = 0; y < block[0].length; y++) {

				block[x][y] = new Block(new Rectangle(x * Tile.tileSize, y
						* Tile.tileSize, Tile.tileSize, Tile.tileSize),
						Tile.air);

			}
		}

		generateLevel();
	}

	public void generateLevel() {
		for (int x = 0; x < block.length; x++) {

			for (int y = 0; y < block[0].length; y++) {

				if (isBlockPlaceable(x, y)) {

					block[x][y].id = Tile.earth;
				}
			}
		}
	}

	private boolean isBlockPlaceable(int x, int y) {
		return 0 == x || 0 == y || (block.length - 1) == x
				|| (block[0].length - 1) == y;
	}

	public void tick() {

	}

	public void render(Graphics g) {
		for (int x = 0; x < block.length; x++) {

			for (int y = 0; y < block[0].length; y++) {

				block[x][y].render(g);

			}
		}
	}

}
