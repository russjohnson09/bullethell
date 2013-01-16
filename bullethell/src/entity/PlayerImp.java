package entity;

import states.PosNegZero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class PlayerImp implements Player {

	private static final float MOVEMENT = 1;
	private static final int HEALTH = 10;
	private Texture texture;
	private float timeTilFire;
	private float DELAY_FIRE = 0.2f;
	private float BOUNDARY = 10;
	private boolean isFiring = false;
	private float x;
	private float y;
	private float r;
	private PosNegZero stateX;
	private PosNegZero stateY;
	private int health;
	private int lives;
	// if greater than zero player is invincible
	private float invincible;
	// players bullets
	private Array<Bullet> bullets = new Array<Bullet>();

	private static Array<Entity> list = new Array<Entity>();

	public PlayerImp() {
		x = 5;
		y = 2;
		r = 1;
		stateX = PosNegZero.ZERO;
		stateY = PosNegZero.ZERO;
		timeTilFire = 10;
		health = 10;
		invincible = 3;
		lives = 3;
		texture = null;
	}

	@Override
	public boolean isFin() {
		return false;
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
		updateBullets(delta);
		invincible -= delta;
		if (stateX == PosNegZero.POS && x < BOUNDARY)
			x += MOVEMENT * delta;
		if (stateX == PosNegZero.NEG && x > 0)
			x -= MOVEMENT * delta;
		if (stateY == PosNegZero.POS && y < BOUNDARY)
			y += MOVEMENT * delta;
		if (stateY == PosNegZero.NEG && y > 0)
			y -= MOVEMENT * delta;
		if (isFiring)
			fire(delta);
		if (health < 0) {
			health = HEALTH;
			lives--;
		}

	}

	private void updateBullets(float delta) {
		Bullet bullet;
		for (int i = bullets.size - 1; i >= 0; i--) {
			bullet = bullets.get(i);
			if (bullet.isFin()) {
				bullets.removeIndex(i);
			}
		}

	}

	private void fire(float delta) {
		if (timeTilFire < 0) {
			// TODO fire bullet
			timeTilFire = DELAY_FIRE;
		} else
			timeTilFire -= delta;

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
	public PosNegZero getStateX() {
		return stateX;
	}

	@Override
	public PosNegZero getStateY() {
		return stateY;
	}

	@Override
	public void setStateX(PosNegZero state) {
		stateX = state;

	}

	@Override
	public void setStateY(PosNegZero state) {
		stateY = state;

	}

	@Override
	public boolean getInvincible() {
		return invincible > 0;
	}

	@Override
	public int getLives() {
		return lives;
	}

	@Override
	public void decrementHealth() {
		health--;

	}

	@Override
	public float getR() {
		return r;
	}

	@Override
	public Array<Bullet> getBullets() {
		return bullets;
	}

	public String toString() {
		return String.format("x: %.2f\ty: %.2f", x, y);
	}

}
