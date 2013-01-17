package entity;

import render.Renderer;
import states.PosNegZero;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class PlayerImp implements Player {

	private Texture texture;
	private float timeTilFire;
	// delay for fire
	private final float delay = 0.1f;
	private boolean isFiring = false;
	private float x;
	private float y;
	private float r;
	// radius of bullet
	private float bulletR;
	private PosNegZero stateX;
	private PosNegZero stateY;
	// current health of player
	private int health;
	private final int totalHealth;
	private float speed;
	private int lives;
	// if greater than zero player is invincible
	private float invincible;
	// players bullets
	private Array<Bullet> bullets = new Array<Bullet>();
	private boolean isSlow = false;

	public PlayerImp() {
		x = 5;
		y = 2;
		r = 1;
		speed = 7;
		stateX = PosNegZero.ZERO;
		stateY = PosNegZero.ZERO;
		timeTilFire = 0.2f;
		health = totalHealth = 10;
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
		float move = (isSlow) ? speed / 2 : speed;
		updateBullets(delta);
		invincible -= delta;
		if (stateX == PosNegZero.POS && x < Renderer.CAMERA_WIDTH)
			x += move * delta;
		if (stateX == PosNegZero.NEG && x > 0)
			x -= move * delta;
		if (stateY == PosNegZero.POS && y < Renderer.CAMERA_HEIGHT)
			y += move * delta;
		if (stateY == PosNegZero.NEG && y > 0)
			y -= move * delta;
		if (isFiring)
			fire(delta);
		if (health < 0) {
			health = totalHealth;
			lives--;
		}

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

	private void fire(float delta) {
		if (timeTilFire < 0) {
			bullets.add(new BulletUp(x, y, ));
			timeTilFire = delay;
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

	@Override
	public void setX(float x) {
		this.x = x;

	}

	@Override
	public void setY(float y) {
		this.y = y;

	}

	@Override
	public boolean isFiring() {
		return isFiring;
	}

	@Override
	public void setIsFiring(boolean b) {
		isFiring = b;

	}

	@Override
	public void decLives() {
		lives--;

	}

	@Override
	public void incLives() {
		lives++;

	}

	@Override
	public void setIsSlow(boolean b) {
		isSlow = b;

	}

	@Override
	public String toString() {
		return String.format("x: %.2f\ty: %.2f", x, y);
	}

}
