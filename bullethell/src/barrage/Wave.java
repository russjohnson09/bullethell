package barrage;

import path.PathList;
import utils.LinkedList;
import utils.Node;
import entity.Bullet;
import entity.Enemy;

/**
 * This class defines waves of enemies and bosses.
 * 
 * @author russ
 * 
 */
public class Wave {

	public static LinkedList basic() {
		LinkedList list = new LinkedList();
		list.add(new Node(Enemies.Swooping(), 0));
		list.add(new Node(new Enemy(), 0));
		list.add(new Node(Enemies.Swooping(), 1));
		list.add(new Node(new Enemy(), 1));
		return list;
	}

	public static Enemy kaguya() {
		PathList path = new PathList();
		path.add(Paths.basic2(3, 45, 12, 30), 0);
		path.add(Paths.basic2(12, 30, 2, 30), 1f);
		path.add(Paths.basic2(2, 30, 15, 40), 1f);
		path.add(Paths.basic2(15, 40, 6, 35), 1f);

		LinkedList bullets = new LinkedList();

		bullets.add(new Node(new Bullet(), 2f));

		return new Enemy(3, 45, 1, 10, path, bullets);

	}
}
