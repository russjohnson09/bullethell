package entity;

import path.Path;
import path.Path01;
import render.Renderer;
import states.PosNegZero;
import utils.Textures;

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
	private float hitBox;
	private float grazeBox;
	// radius of bullet
	private float bulletR;
	private float bulletSpeed;
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
	private static Array<Bullet> bullets = new Array<Bullet>();
	private boolean isSlow = false;

	public PlayerImp() {
		x = 5;
		y = 2;
		r = 1;
		hitBox = 1;
		grazeBox = 2;
		speed = 20;
		stateX = PosNegZero.ZERO;
		stateY = PosNegZero.ZERO;
		timeTilFire = 0.2f;
		health = totalHealth = 10;
		invincible = 3;
		lives = 3;
		texture = null;

		bulletR = 0.1f;
		bulletSpeed = 50;
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

	private void fire(float delta) {
		if (timeTilFire < 0) {
			Path path = new Path01(0, 0, 40, 0);
			bullets.add(new BulletImp(x, y, 0.5f, path, Textures.BULLET01));
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
