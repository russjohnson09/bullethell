package entity;

import path.Path;
import path.Path01;
import render.Renderer;
import states.PosNegZero;
import utils.Textures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class Player implements Entity {

	private Texture texture;
	private float timeTilFire;
	// delay for fire
	private final float delay = 0.1f;
	private boolean isFiring = false;
	private float x;
	private float y;
	private final float r;
	private final float h;
	private final float w;
	private final float r2;
	private PosNegZero stateX;
	private PosNegZero stateY;
	private int health;
	private final int MAX_HEALTH;
	private final float SPEED;
	private int lives;
	// if greater than zero player is invincible

	private float invincible;
	// players bullets
	private static Array<Bullet> bullets = new Array<Bullet>();
	private boolean isSlow = false;

	public Player() {
		x = 5;
		y = 2;
		r = 1;
		r2 = 2;
		speed = 20;
		stateX = PosNegZero.ZERO;
		stateY = PosNegZero.ZERO;
		timeTilFire = 0.2f;
		health = maxHealth = 10;
		invincible = 3;
		lives = 3;
		texture = Textures.PLAYER;

		bulletR = 0.1f;
		bulletSpeed = 50;
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
		timeTilFire -= delta;
		if (stateX == PosNegZero.POS && x < Renderer.CAMERA_WIDTH)
			x += move * delta;
		if (stateX == PosNegZero.NEG && x > 0)
			x -= move * delta;
		if (stateY == PosNegZero.POS && y < Renderer.CAMERA_HEIGHT)
			y += move * delta;
		if (stateY == PosNegZero.NEG && y > 0)
			y -= move * delta;
		if (isFiring && timeTilFire < 0) {
			Path path = new Path01(0, 0, 40, 0);
			bullets.add(new BulletImp(x, y, 0.5f, path, Textures.BULLET01));
			timeTilFire = delay;
		}
		if (health < 0) {
			health = maxHealth;
			lives--;
		}

	}

	@Override
	public Texture getTexture() {
		return texture;
	}

	public float getHealth() {
		return health;
	}

	public float getRadius() {
		return r;
	}

	public PosNegZero getStateX() {
		return stateX;
	}

	public PosNegZero getStateY() {
		return stateY;
	}

	public void setStateX(PosNegZero state) {
		stateX = state;

	}

	public void setStateY(PosNegZero state) {
		stateY = state;

	}

	public int getLives() {
		return lives;
	}

	@Override
	public float getR() {
		return r;
	}

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

	@Override
	public float getH() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setH(float h) {
		// TODO Auto-generated method stub

	}

	@Override
	public float getW() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setW(float w) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setR(float r) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTexture(Texture texture) {
		// TODO Auto-generated method stub

	}

}
