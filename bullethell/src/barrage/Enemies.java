package barrage;

import path.PathList;
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

	public static Enemy shiki() {
		PathList path = new PathList();
		LinkedList bullets = new LinkedList();

		Enemy shiki = new Enemy(3, 45, 1, 10, path, bullets);

		path.add(Paths.basic3(3, 45, 12, 30), 0);
		path.add(Paths.basic3(12, 30, 2, 30), 1f);
		path.add(Paths.basic3(2, 30, 15, 40), 1f);
		path.add(Paths.basic3(15, 40, 6, 35), 1f);

		bullets.add(new Node(new Bullet(), 2f));

		Barrage.raining(4, 1, -7);

		return shiki;

	}

}
