package barrage;

import path.Path01;
import path.PathList;
import utils.LinkedList;
import utils.Node;
import entity.Bullet;
import entity.BulletScript;
import entity.Enemy;

/**
 * Static methods and constants for different enemy types.
 * 
 * @author russ
 * 
 */
public class Enemies {

	public static Enemy shiki() {
		PathList path = new PathList();
		LinkedList bullets = new LinkedList();

		Enemy shiki = new Enemy(3, 45, 1, 10, path, bullets);

		path.add(Paths.basic3(3, 45, 12, 30), 0);
		path.add(Paths.basic3(12, 30, 2, 30), 1f);
		path.add(Paths.basic3(2, 30, 15, 40), 1f);
		path.add(Paths.basic3(15, 40, 6, 35), 1f);

		for (int i = 0; i < 100; i++) {
			path.add(Paths.basic3(0, 0, 10, 0), 1.5f);
			path.add(Paths.basic3(0, 0, -10, 0), 1.5f);
		}

		bullets.add(new Node(new Bullet(shiki.pos.x, shiki.pos.y, 1,
				new Path01(0, -5)), 3));

		float j;

		for (int i = 0; i < 100; i++) {
			j = (float) ((21 * Math.random()) + 2);
			bullets.add(Barrage.raining(j, 2, -2, 2f));
		}

		return shiki;

	}

	public static BulletScript bulletRain() {
		LinkedList bullets = new LinkedList();
		return new BulletScript(new LinkedList());

	}

}
