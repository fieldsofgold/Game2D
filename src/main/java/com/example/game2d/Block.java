package com.example.game2d;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author Michal Leja Blocks
 */
public class Block extends Rectangle {

	private static final long serialVersionUID = 1L;

	/**
	 * Block placement id
	 * 
	 */
	public int[] id = { -1, -1 };

	/**
	 * @param size
	 *            - block size
	 * @param id
	 *            - placement
	 */
	public Block(Rectangle size, int[] id) {

		setBounds(size);

		this.id = id;

	}

	public void render(Graphics g) {

		if (id != Tile.air) {
			g.drawImage(Tile.tileset_terrain, x - (int)Component.sX, y - (int)Component.sY, x + width - (int)Component.sX, y + height - (int)Component.sY,
					id[0] * Tile.tileSize, id[1] * Tile.tileSize, id[0]
							* Tile.tileSize + Tile.tileSize, id[1]
							* Tile.tileSize + Tile.tileSize, null);
		}
	}
}
