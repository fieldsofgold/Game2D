package com.example.game2d;

import java.awt.Graphics;
import java.awt.Point;

public class Character extends DoubleRectangle {

	public double fallingSpeed = 1.3; // 1 w nagraniu

	/**
	 * moving speed
	 * 
	 */
	public double movementSpeed = 0.5;

	/**
	 * jumping speed variable
	 * 
	 */
	public double jumpingSpeed = 1.3; // 1 w nagraniu

	/**
	 * jumping height variable jumping count
	 */
	public int jumpingHeight = 50, jumpingCount = 0;

	/**
	 * isJumping
	 * 
	 */
	public boolean isJumping = false;

	/**
	 * setting size of object
	 * 
	 * @param width
	 * @param height
	 */
	public Character(int width, int height) {
		setBounds((Component.pixel.width / 2) - (width / 2),
				(Component.pixel.height / 2) - (height / 2), width, height);

	}

	/**
	 * movement method
	 * 
	 */
	public void tick() {
		if (!isJumping
				&& !isCollideingWithBlock(
						new Point((int) x + 2, (int) (y + height)), new Point(  
								(int) (x + width - 2), (int) (y + height)))) {
			//+2    and width   -2  nie bedzie sie przyczepiac do scian
			y += fallingSpeed;
			Component.sY += fallingSpeed;

		} else {

			if (Component.isJumping) {

				isJumping = true;
			}
		}

		if (Component.isMoving) {
			boolean canMove = false;

			if (Component.dir == movementSpeed) {

				canMove = isCollideingWithBlock(new Point((int) (x + width),
						(int) y), new Point((int) (x + width), (int) (y
						+ height - 2)));

			} else if (Component.dir == -movementSpeed) {

				canMove = isCollideingWithBlock(
						new Point((int) x - 1, (int) y), new Point((int) x - 1,
								(int) (y + height - 2)));

			}
			if (!canMove) {
				x += Component.dir;

				Component.sX += Component.dir;
			}
		}

		if (isJumping) {
			if (!isCollideingWithBlock(new Point((int) (x+2), (int) y), new Point(
					(int) (x + width - 2), (int) y))) {
				if (jumpingCount >= jumpingHeight) {

					isJumping = false;
					jumpingCount = 0;
				} else {
					y -= jumpingSpeed;
					Component.sY -= jumpingSpeed;
					jumpingCount += 1;
				}
			} else {
				isJumping = false;
				jumpingCount = 0;
			}
		}
	}

	public boolean isCollideingWithBlock(Point pt1, Point pt2) {

		for (int x = (int) (this.x / Tile.tileSize); x < (int) (this.x / Tile.tileSize) + 3; x++) {
			for (int y = (int) (this.y / Tile.tileSize); y < (int) (this.y / Tile.tileSize) + 3; y++) {
				if (x >= 0 && y >= 0 && x < Component.level.block.length
						&& y < Component.level.block[0].length)
					if (Component.level.block[x][y].id != Tile.air) {
						if (Component.level.block[x][y].contains(pt1)
								|| Component.level.block[x][y].contains(pt2)) {
							return true;
						}
					}
			}
		}
		return false;
	}

	public void render(Graphics g) {
		g.drawImage(Tile.tileset_terrain, (int) x - (int) Component.sX, (int) y
				- (int) Component.sY, (int) (x + width) - (int) Component.sX,
				(int) (y + height) - (int) Component.sY, Tile.character[0]
						* Tile.tileSize, Tile.character[1] * Tile.tileSize,
				Tile.character[0] * Tile.tileSize + (int) width,
				Tile.character[1] * Tile.tileSize + (int) height, null);
	}

}
