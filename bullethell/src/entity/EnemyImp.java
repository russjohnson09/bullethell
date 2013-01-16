package entity;

import utils.Textures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

/**
 * Most basic implementation of Enemy. Moves from left to right across the
 * screen.
 * 
 * @author russ
 * 
 */
public class EnemyImp implements Enemy {

	public static final float MOVEMENT = 1;
	public static final float BOUNDARY = 20;
	private final float DELAY = 1;
	private float delay;

	private static Array<Bullet> bullets = new Array<Bullet>();

	private int health;
	private float x;
	private float y;
	private float r;
	private Texture texture;

	public EnemyImp() {
		health = 10;
		x = 0;
		y = 10;
		r = 1;
		texture = Textures.ENEMY01;

		delay = 0.5f;

	}

	@Override
	public boolean isFin() {
		return x > BOUNDARY;
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public void update(float delta) {
		x += MOVEMENT;
		delay -= delta;

		if (delay < 0) {
			bullets.add(new BulletImp(x, y));
			delay = DELAY;
		}

		updateBullets(delta);

	}

	private void updateBullets(float delta) {
		Bullet bullet;
		for (int i = bullets.size - 1; i >= 0; i--) {
			bullet = bullets.get(i);
			bullet.update(delta);
			if (bullet.isFin()) {
				bullets.removeIndex(i);
			}
		}
	}

	@Override
	public Texture getTexture() {
		return texture;
	}

	@Override
	public float getHealth() {
		return health;
	}

	@Override
	public float getRadius() {
		return r;
	}

	@Override
	public float getR() {
		return r;
	}

	@Override
	public void decrementHealth() {
		health--;

	}

	public static Array<Bullet> getBullets() {
		return bullets;
	}

}
