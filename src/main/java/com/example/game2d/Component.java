package com.example.game2d;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

/**
 * @author Michal Leja class with components to draw
 */

public class Component extends Applet implements Runnable {
	

	private static final long serialVersionUID = 1L;

	/**
	 * size of pixel
	 * 
	 */
	private static int pixelSize = 2;
		
	/**sX, sY side scrolling coordinates
	 * 
	 */
	//public static int moveFromBorder = 0; !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! mieszal pod koniec Tutka1
	public static double sX = 0, sY = 0;
	
	/**movement direction variable
	 * 
	 */
	public static double dir=0;
	
	public static int moveFromBorder = 0;
	
	/**
	 * Screen resolution
	 * 
	 */
	public static Dimension size = new Dimension(700, 560);

	/**
	 * creating pixel 2.2
	 * 
	 */
	public static Dimension pixel = new Dimension(size.width / pixelSize, size.height
			/ pixelSize);

	/**
	 * Name of game/frame
	 * 
	 */
	public static String name = "Minecraft 2D Adventure";

	/**
	 * (this)Thread running boolean
	 * 
	 */
	public boolean isRunning = false;
	
	/** checking is moving
	 * 
	 */
	public static boolean isMoving = false;

	/**
	 * ver 1 1L
	 * 
	 */

	public static boolean isJumping = false;
	
	private Image screen;

	
	/** creating Level named level
	 * 
	 */
	public static Level level;

	/**creating Character named character
	 * 
	 */
	public static Character character;
	
	/**
	 * Component constructor
	 * 
	 */
	public Component() {

		setPreferredSize(size);
		addKeyListener(new Listening());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.applet.Applet#start()
	 */
	public void start() {
		// Defining objects etc.
		new Tile();
		level = new Level();
		character = new Character(Tile.tileSize,Tile.tileSize*2);
		
		
		// starting game loops
		isRunning = true;
		new Thread(this).start();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.applet.Applet#stop()
	 */
	public void stop() {
		isRunning = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		screen = createVolatileImage(pixel.width, pixel.height);

		while (isRunning) {

			tick();
			render();

			try {
				Thread.sleep(5);
			} catch (Exception e) {
			}
		}
	}

	/**
	 * drawing pictures on screen Class: Graphics.
	 */
	public void render() {
		Graphics g = screen.getGraphics();

		g.setColor(new Color(100, 100, 255));
		g.fillRect(0, 0, pixel.width, pixel.height);
		
		level.render(g);
		character.render(g);

		g = getGraphics();

		g.drawImage(screen, 0, 0, size.width, size.height, 0, 0, pixel.width,
				pixel.height, null);

		g.dispose();

	}

	/**
	 * etc. moving player, monster
	 * 
	 */
	public void tick() {
		level.tick();
		character.tick();
	}
}
