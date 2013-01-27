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
	/* position */
	protected Pos pos = new Pos(0, 0);

	public Path01(float vX, float vY) {
		this.vX = vX;
		this.vY = vY;
	}

	public void update(float delta) {
		pos.x += vX * delta;
		pos.y += vY * delta;
	}

	public Path copy() {
		return new Path01(vX, vY);
	}

	@Override
	public Pos getPos() {
		return pos;
	}
}
