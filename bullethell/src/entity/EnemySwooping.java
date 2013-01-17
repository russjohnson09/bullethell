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

	}

	@Override
	public void update(float delta) {
		x += MOVEMENT * delta;
		y -= MOVEMENT * delta;
		delay -= delta;
		addBullet();
		updateBullets(delta);

	}

}
