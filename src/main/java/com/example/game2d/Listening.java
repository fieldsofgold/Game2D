package com.example.game2d;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listening implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		switch (key) {
		case KeyEvent.VK_D:

			Component.isMoving = true;

			Component.dir = Component.character.movementSpeed;

			break;

		case KeyEvent.VK_A:

			Component.isMoving = true;

			Component.dir = -Component.character.movementSpeed;

			break;

		case KeyEvent.VK_W:

			Component.isJumping = true;
			
			break;
		//
		// case KeyEvent.VK_S:
		//
		// break;

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		switch (key) {
		case KeyEvent.VK_D:

			if (Component.dir == Component.character.movementSpeed) {

				Component.isMoving = false;

			}
			break;

		case KeyEvent.VK_A:

			if (Component.dir == -Component.character.movementSpeed) {

				Component.isMoving = false;

			}
			break;

		case KeyEvent.VK_W:

			Component.isJumping = false;
			
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
