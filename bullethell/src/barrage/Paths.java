package barrage;

import path.Path;

import com.badlogic.gdx.math.Vector2;

public class Paths {

	/**
	 * Goes from (0,0) to (x,y) with speed equal to speed.
	 * 
	 * @param x
	 * @param y
	 * @param speed
	 * @return
	 */
	public static Path basic(float x, float y, float speed) {
		speed /= Math.sqrt(x * x + y * y);
		return new Path(new Vector2(x * speed, y * speed));
	}
	//
	// public static Path01 basic2(float x1, float y1, float x2, float y2,
	// float speed) {
	// return basic(x2 - x1, y2 - y1, speed);
	// }
	//
	// public static Path01 basic3(float x1, float y1, float x2, float y2) {
	// return new Path01(x2 - x1, y2 - y1);
	// }

}
