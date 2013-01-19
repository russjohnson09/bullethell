package barrage;

import path.Path01;
import utils.LinkedList;
import utils.Node;
import entity.Bullet;

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

}
