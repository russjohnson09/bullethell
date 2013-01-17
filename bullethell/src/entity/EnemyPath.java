package entity;

import parametric.Para01;
import parametric.Parametric;

/**
 * An enemy that is updated using a parametric equation.
 * 
 * @author russ
 * 
 */
public class EnemyPath extends EnemyImp {

	protected Parametric path;

	// the original position of the enemy
	protected final float ox;
	protected final float oy;

	public EnemyPath() {
		super();
		ox = x;
		oy = y;
		path = new Para01(1, 0);
	}

	public EnemyPath(float x, float y, float r, int health, float speed,
			Parametric path) {
		super(x, y, r, health, speed);
		ox = x;
		oy = y;
		this.path = path;
	}

	@Override
	public void update(float delta) {
		path.update(delta);
		x = ox + path.getX();
		y = oy + path.getY();

		delay -= delta;
		addBullet();
		updateBullets(delta);

	}

}
