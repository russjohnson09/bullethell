package entity;

import path.Path;
import path.Path01;
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

	// the original position of the enemy
	protected final float ox;
	protected final float oy;
	protected float x;
	protected float y;
	protected float r;
	protected Path path;
	protected int health;
	protected Texture texture;

	public EnemyImp() {
		health = 10;
		x = ox = 0;
		y = oy = 40;
		r = 1;
		path = new Path01(10, 0, 10, -5);
		texture = Textures.ENEMY01;

		delay = 0.5f;

	}

	@Override
	public boolean isFin() {
		if (health < 0) {
			kills++;
			return true;
		}
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
		path.update(delta);
		x = ox + path.getX();
		y = oy + path.getY();

		delay -= delta;
		addBullet();
		updateBullets(delta);

	}

	protected void addBullet() {
		if (delay < 0) {
			Path path = new Path01(0, 0, -5, 0);
			bullets.add(new BulletImp(x, y, 0.5f, path, Textures.BULLET01));
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
