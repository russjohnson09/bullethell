package entity;

import path.Path;
import path.Path01;
import render.Renderer;
import states.PosNegZero;

import com.badlogic.gdx.utils.Array;

public class Player implements Entity {

	public static final float X_BOUND = Renderer.CAMERA_WIDTH;
	public static final float Y_BOUND = Renderer.CAMERA_HEIGHT;

	private Array<Bullet> bullets = new Array<Bullet>();

	private final int MAX_HEALTH;
	private final float SPEED;
	private final float DELAY = 0.1f;
	private float timeTilFire;
	private boolean isFiring = false;

	private PosNegZero stateX;
	private PosNegZero stateY;

	private float invincible;
	private boolean isSlow = false;
	private boolean isFin = false;

	private float x;
	private float y;
	private float r;
	private float r2;
	private int health;
	private int lives;

	private float bulletR = 0.2f;
	private float bulletSpeed = 50;

	public Player() {
		x = 5;
		y = 2;
		r = 0.2f;
		r2 = 2;
		SPEED = 20;
		stateX = PosNegZero.ZERO;
		stateY = PosNegZero.ZERO;
		timeTilFire = 0.2f;
		health = MAX_HEALTH = 10;
		invincible = 3;
		lives = 3;

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
		float move = (isSlow) ? SPEED / 2 : SPEED;
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
			Path path = new Path01(0, 40);
			bullets.add(new Bullet(x, y, 0.5f, path));
			timeTilFire = DELAY;
		}
		if (health < 0) {
			health = MAX_HEALTH;
			lives--;
		}

	}

	public Array<Bullet> getBullets() {
		return bullets;
	}

	public void setBullets(Array<Bullet> bullets) {
		this.bullets = bullets;
	}

	public float getTimeTilFire() {
		return timeTilFire;
	}

	public void setTimeTilFire(float timeTilFire) {
		this.timeTilFire = timeTilFire;
	}

	public boolean isFiring() {
		return isFiring;
	}

	public void setFiring(boolean isFiring) {
		this.isFiring = isFiring;
	}

	public PosNegZero getStateX() {
		return stateX;
	}

	public void setStateX(PosNegZero stateX) {
		this.stateX = stateX;
	}

	public PosNegZero getStateY() {
		return stateY;
	}

	public void setStateY(PosNegZero stateY) {
		this.stateY = stateY;
	}

	public float getInvincible() {
		return invincible;
	}

	public void setInvincible(float invincible) {
		this.invincible = invincible;
	}

	public boolean isSlow() {
		return isSlow;
	}

	public void setSlow(boolean isSlow) {
		this.isSlow = isSlow;
	}

	@Override
	public float getR() {
		return r;
	}

	@Override
	public void setR(float r) {
		this.r = r;
	}

	public float getR2() {
		return r2;
	}

	public void setR2(float r2) {
		this.r2 = r2;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public float getBulletR() {
		return bulletR;
	}

	public void setBulletR(float bulletR) {
		this.bulletR = bulletR;
	}

	public float getBulletSpeed() {
		return bulletSpeed;
	}

	public void setBulletSpeed(float bulletSpeed) {
		this.bulletSpeed = bulletSpeed;
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
	public String toString() {
		return String.format("x: %.2f\ty: %.2f", x, y);
	}

	@Override
	public boolean isFin() {
		return isFin;
	}

	@Override
	public void setFin(boolean b) {
		isFin = b;

	}

}
