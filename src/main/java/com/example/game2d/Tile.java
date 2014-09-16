package com.example.game2d;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * @author Michal Leja Tile
 */
public class Tile {

	/**
	 * Tile defaultSize
	 * 
	 */
	public static int tileSize = 20;

	/**
	 * above block
	 * 
	 */
	public static int[] air = { -1, -1 };

	/**
	 * inside block
	 * 
	 */
	public static int[] earth = { 0, 0 };

	public static int[] character = { 0, 18 };

	/**
	 * graphic variable;
	 * 
	 */
	public static BufferedImage tileset_terrain;

	/**
	 * adding graphic file
	 * 
	 */
	public Tile() {

		try {
			// WROKING ONE !!!
			// Tile.tileset_terrain = ImageIO.read(new File(
			// "src/res/tileset_terrain.png"));

			InputStream inputStream = getClass().getClassLoader()
					.getResourceAsStream("tileset_terrain.png");

			Tile.tileset_terrain = ImageIO.read(inputStream);

			// Tile.tileset_terrain =
			// ImageIO.read(getClass().getClassLoader().getResourceAsStream("/src/res/tileset_terrain.png"));

			// Tile.tileset_terrain = ImageIO.read(new
			// File(Main.class.getResource("src/res/tileset_terrain.png").getPath()));

			// URL k = new
			// URL(getClass().getClassLoader().getResource("src/res/tileset_terrain.png").getPath());
			// Tile.tileset_terrain = ImageIO.read(k);

			// ImageIcon i = new
			// ImageIcon(getClass().getClassLoader().getResource(
			// "Files/Room.png"));

		} catch (Exception e) {
		}
	}
}
