package entity;

/**
 * An Enemy that makes a swooping pattern.
 * 
 * @author russ
 * 
 */
public class EnemySwooping extends EnemyImp {

	public EnemySwooping() {
		super();

	}

	public EnemySwooping(float x, float y) {
		super();
		this.x = x;
		this.y = y;

	}

	@Override
	public void update(float delta) {
		x += speed * delta;
		y -= speed * delta;
		delay -= delta;
		addBullet();
		updateBullets(delta);

	}

}
