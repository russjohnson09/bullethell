package path;

/**
 * Implementation of path using velocity and acceleration for x and y.
 * 
 * @author russ
 * 
 */
public class Path01 implements Path {

	/* Velocity of x */
	protected float vX;
	/* Velocity of y */
	protected float vY;
	/* x position */
	protected float x = 0;
	/* y position */
	protected float y = 0;

	public Path01(float vX, float vY) {
		this.vX = vX;
		this.vY = vY;
	}

	public void update(float delta) {
		x += vX * delta;
		y += vY * delta;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Path copy() {
		return new Path01(vX, vY);
	}
}
