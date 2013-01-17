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

	protected float delay;

	protected static Array<Bullet> bullets = new Array<Bullet>();
	protected static int kills = 0;

	protected float x;
	protected float y;
	protected float r;
	protected int health;
	protected float speed;
	protected Texture texture;

	public EnemyImp() {
		health = 10;
		x = 0;
		y = 40;
		r = 1;
		speed = 5;
		texture = Textures.ENEMY01;

		delay = 0.5f;

	}

	public EnemyImp(float x, float y) {
		this();
		this.x = x;
		this.y = y;

	}

	public EnemyImp(float x, float y, float r, int health, float speed) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.health = health;
		this.speed = speed;
		texture = Textures.ENEMY01;
		delay = 0.5f;

	}

	@Override
	public boolean isFin() {
		if (health < 0) {
			kills++;
			return true;
		}
		return outOfBounds();
	}

	protected boolean outOfBounds() {
		return (x > BOUNDARY_X + MARGIN || y > BOUNDARY_Y + MARGIN)
				|| (x < -MARGIN || y < -MARGIN);
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
		x += speed * delta;
		delay -= delta;
		addBullet();

	}

	protected void addBullet() {
		if (delay < 0) {
			bullets.add(new BulletImp(x, y));
			delay = DELAY;
		}

	}

	public static void updateBullets(float delta) {
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

	@Override
	public String toString() {
		return String.format("x: %.2f\ty: %.2f", x, y);
	}

	@Override
	public int getKills() {
		return kills;
	}

	@Override
	public void setX(float x) {
		this.x = x;

	}

	@Override
	public void setY(float y) {
		this.y = y;

	}

}
