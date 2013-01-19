package barrage;

import path.Path01;
import entity.Enemy;

/**
 * Static methods and constants for different enemy types.
 * 
 * @author russ
 * 
 */
public class Enemies {

	public static Enemy Swooping() {
		return new Enemy(-1, Enemy.Y_BOUND + 1, 1, 3,
				new Path01(10, 0, -10, 5), Barrage.fire(0.3f, 10000, 0.5f,
						new Path01(0, 0, -10, 0)));
	}

}
