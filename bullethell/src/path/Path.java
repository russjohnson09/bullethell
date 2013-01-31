package path;

import com.badlogic.gdx.math.Vector2;

/**
 * Implementation of path using velocity and acceleration for x and y.
 * 
 * @author russ
 * 
 */
public class Path {

	/* Velocity of vector */
	public Vector2 v;
	/* position vertor */
	public Vector2 pos = new Vector2(0f, 0f);

	public Path() {
	}

	public Path(Vector2 v) {
		this.v = v;
	}

	public Path(float x, float y) {
		this.v = new Vector2(x, y);
	}

	public void update(float delta) {
		pos.x += v.x * delta;
		pos.y += v.y * delta;
	}

	public Path cpy() {
		return new Path(v.cpy());
	}
}
