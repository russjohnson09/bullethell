package barrage;

import path.Path01;
import render.Renderer;
import utils.LinkedList;
import utils.Node;
import entity.Bullet;
import entity.Enemy;

/**
 * Contains convenience methods for various enemy types and bullets etc.
 * 
 * @author russ
 * 
 */
public class Barrage {

	/**
	 * Fire bullets every delay seconds.
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public static LinkedList fire(float delay, int numberOfBullets, float r,
			Path01 path) {
		LinkedList list = new LinkedList();
		Bullet b = new Bullet(0, 0, r, path.copy());
		list.add(new Node(b, 0));

		for (int i = 0; i < numberOfBullets - 1; i++) {
			b = new Bullet(0, 0, r, path.copy());
			list.add(new Node(b, delay));
		}
		return list;
	}

	public static LinkedList shikiBarrage() {
		LinkedList list = new LinkedList();
		Bullet b = new Bullet();
		return list;
	}

	/*
	 * A shower of bullets.
	 */
	public static void raining(float x, float r, float speed) {

		for (int i = 1; i < Renderer.CAMERA_WIDTH; i++) {
			if (Math.abs(((float) i) - x) > r) {
				Enemy.getBullets().add(
						new Bullet(i, Renderer.CAMERA_HEIGHT - 1, .9f,
								new Path01(0, speed)));
			}
		}

		// for (int i = 1; i < Renderer.CAMERA_WIDTH * 2; i++) {
		// if (Math.abs(i / 2f - x) > r) {
		// Enemy.getBullets().add(
		// new Bullet(i / 2f, Renderer.CAMERA_HEIGHT - 1, 0.4f,
		// new Path01(0, -speed)));
		// }
		// }
	}
}
