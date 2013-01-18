package entity;

import path.Path;
import path.Path01;
import render.Renderer;
import utils.LinkedList;
import utils.Textures;
import barrage.Barrage;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

/**
 * Most basic implementation of Enemy. Moves from left to right across the
 * screen.
 * 
 * @author russ
 * 
 */
public class Enemy implements Entity {

	public static final float X_BOUND = Renderer.CAMERA_WIDTH;
	public static final float Y_BOUND = Renderer.CAMERA_HEIGHT;
	public static final float X_MARGIN = X_BOUND * 1.1f;
	public static final float Y_MARGIN = Y_BOUND * 1.1f;

	protected static Array<Bullet> bullets = new Array<Bullet>();
	protected static int kills = 0;

	// the original position of the enemy
	protected float ox;
	protected float oy;

	protected float x;
	protected float y;
	protected float r;
	protected int health;
	protected Path path;
	protected float w;
	protected float h;
	protected Texture texture;

	protected LinkedList bulletScript = new LinkedList();

	protected boolean isFin = false;

	public Enemy() {
		x = ox = 0;
		y = oy = 40;
		r = 2;
		health = 3;
		path = new Path01(10, 0, -10, 5);
		w = h = r;
		texture = Textures.ENEMY01;
		this.bulletScript = Barrage.fire(0.5f, 100, 0.5f, new Path01(0, 0, -10,
				0), Textures.BULLET01);

	}

	@Override
	public void update(float delta) {
		path.update(delta);
		x = ox + path.getX();
		y = oy + path.getY();

		Bullet b = (Bullet) bulletScript.update(delta);
		if (b != null) {
			b.setOx(x);
			b.setOy(y);
			bullets.add(b);
		}
	}

	public static Array<Bullet> getBullets() {
		return bullets;
	}

	public static void setBullets(Array<Bullet> bullets) {
		Enemy.bullets = bullets;
	}

	public static int getKills() {
		return kills;
	}

	public static void setKills(int kills) {
		Enemy.kills = kills;
	}

	public float getOx() {
		return ox;
	}

	public void setOx(float ox) {
		this.ox = ox;
	}

	public float getOy() {
		return oy;
	}

	public void setOy(float oy) {
		this.oy = oy;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getR() {
		return r;
	}

	public void setR(float r) {
		this.r = r;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public float getW() {
		return w;
	}

	public void setW(float w) {
		this.w = w;
	}

	public float getH() {
		return h;
	}

	public void setH(float h) {
		this.h = h;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public LinkedList getBulletScript() {
		return bulletScript;
	}

	public void setBulletScript(LinkedList bulletScript) {
		this.bulletScript = bulletScript;
	}

	public boolean isFin() {
		if (health < 0) {
			kills++;
			return true;
		} else {
			return isFin || (x > X_BOUND + X_MARGIN || y > Y_BOUND + Y_MARGIN)
					|| (x < -X_MARGIN || y < -Y_MARGIN);
		}

	}

	public void setFin(boolean isFin) {
		this.isFin = isFin;
	}

	@Override
	public String toString() {
		return String.format("x: %.2f\ty: %.2f", x, y);
	}

}
