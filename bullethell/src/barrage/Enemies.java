package barrage;

import level.World;

import com.badlogic.gdx.math.Vector2;

import path.Path;
import path.PathList;
import render.Renderer;
import utils.LinkedList;
import utils.Node;
import entity.Bullet;
import entity.Enemy;

/**
 * Static methods and constants for different enemy types.
 * 
 * @author russ
 * 
 */
public class Enemies {

	/**
	 * The doomBot goes across the screen at a freighting speed and leaves only
	 * a small gap for safety.
	 * 
	 * @return
	 */
	public static Enemy doomBot(float y, boolean left) {

		// for where to leave gap
		int r = (int) (22 * Math.random() + 1);

		Vector2 pos;

		PathList path;

		if (left) {
			pos = new Vector2(-2, y);
			path = new PathList(new Path(10, 0));
		} else {
			pos = new Vector2(Renderer.CAMERA_WIDTH + 2, y);
			path = new PathList(new Path(-10, 0));
		}

		LinkedList<Bullet> bullets = new LinkedList<Bullet>();

		Enemy e = new Enemy(pos, 2, 3, path, bullets);

		for (int i = 0; i < 25; i++) {
			if (i > r + 1 || i < r - 1) {
				bullets.add(new Node<Bullet>(new Bullet(new Vector2(i, y),
						0.5f, new Path(0, -5)), 0.1f));
			}
		}

		return e;

	}

	/**
	 * Boss 1 uses mainly wall bullets.
	 * 
	 * @return
	 */
	public static Enemy boss1() {
		LinkedList<Bullet> bullets = new LinkedList<Bullet>();

		PathList path = Paths.boss1();

		Enemy e = new Enemy(new Vector2(12, 45), 1, 100, path, bullets);

		bullets.add(Barrage.boss1(e));

		e.isBoss = true;

		return e;

	}

	public static Enemy boss2(World world) {
		LinkedList<Bullet> bullets = new LinkedList<Bullet>();

		PathList path = Paths.boss1();

		Enemy e = new Enemy(new Vector2(12, 45), 1, 100, path, bullets);

		bullets.add(Barrage.boss2(e, world.player));

		e.isBoss = true;

		return e;
	}

}
