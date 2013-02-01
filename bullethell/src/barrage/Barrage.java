package barrage;

import com.badlogic.gdx.math.Vector2;

import path.Path;
import render.Renderer;
import utils.LinkedList;
import utils.Node;
import entity.Bullet;
import entity.Enemy;
import entity.Player;

/**
 * Contains convenience methods for various enemy types and bullets etc.
 * 
 * @author russ
 * 
 */
public class Barrage {

	/**
	 * Fire bullets every delay seconds downward at some speed.
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public static LinkedList<Bullet> fire(float delay, int numberOfBullets,
			float r, float speed, Enemy spawner) {
		LinkedList<Bullet> list = new LinkedList<Bullet>();
		list.add(new Node<Bullet>(new Bullet(spawner, r, new Path(new Vector2(
				0, -speed))), 0));

		for (int i = 0; i < numberOfBullets - 1; i++) {
			list.add(new Node<Bullet>(new Bullet(spawner, r, new Path(
					new Vector2(0, -speed))), 0));
		}
		return list;
	}

	/**
	 * 
	 * @param x
	 *            where the gap is
	 * @param r
	 *            radius of gap
	 * @return
	 */
	public static LinkedList<Bullet> wall(int x, int r, float speed) {
		LinkedList<Bullet> bullets = new LinkedList<Bullet>();
		for (int i = 0; i <= Renderer.CAMERA_WIDTH; i++) {
			if (x + r < i || i < x - r) {
				bullets.add(new Node<Bullet>(new Bullet(new Vector2(i,
						Renderer.CAMERA_HEIGHT), 0.5f, new Path(0, -speed)), -1));
			}
		}
		return bullets;
	}

	public static LinkedList<Bullet> boss1(Enemy e) {
		int random;
		LinkedList<Bullet> bullets = new LinkedList<Bullet>();

		for (int i = 0; i < 100; i++) {

			// random integer 2-21
			random = (int) (Math.random() * 20 + 2);
			bullets.add(wall(random, 1, 2));

			// null bullet
			bullets.add(new Node<Bullet>(new Bullet(new Vector2(-100, -100), 0,
					new Path(0, 0)), 3));
		}

		return bullets;
	}

	/**
	 * Barrage of seeking bullets.
	 * 
	 * @param e
	 * @param player
	 * @return
	 */
	public static LinkedList<Bullet> boss2(Enemy e, Player player) {
		LinkedList<Bullet> bullets = new LinkedList<Bullet>();

		for (int i = 0; i < 1000; i++) {
			Bullet seeking = new Bullet(e, 0.5f, null);
			seeking.target = player;
			seeking.speed = 10f;
			bullets.add(new Node<Bullet>(seeking, 0.1f));
		}

		return bullets;
	}

	//
	// public static LinkedList shikiBarrage() {
	// LinkedList list = new LinkedList();
	// Bullet b = new Bullet();
	// return list;
	// }
	//
	// /*
	// * A shower of bullets.
	// */
	// public static LinkedList raining(float x, float r, float speed, float
	// delay) {
	//
	// LinkedList list = new LinkedList();
	//
	// int j = 1;
	// if (Math.abs(((float) j) - x) > r) {
	// list.add(new Node(new Bullet(j, Renderer.CAMERA_HEIGHT - 1, .9f,
	// new Path01(0, speed)), delay));
	// }
	//
	// for (int i = 2; i < Renderer.CAMERA_WIDTH; i++) {
	// if (Math.abs(((float) i) - x) > r) {
	// list.add(new Node(new Bullet(i, Renderer.CAMERA_HEIGHT - 1,
	// .9f, new Path01(0, speed)), -1));
	// }
	// }
	//
	// return list;
	// }
}
