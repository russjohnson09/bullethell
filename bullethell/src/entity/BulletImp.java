package entity;

import utils.Textures;

import com.badlogic.gdx.graphics.Texture;

/**
 * Basic implementation of bullet goes down from (x,y)
 * 
 * @author russ
 * 
 */
public class BulletImp implements Bullet {

	public static final float MOVEMENT = 1;
	public static final float BOUNDARY = 15;

	private float x;
	private float y;
	private float r;
	private Texture texture;

	private boolean isFin = false;

	public BulletImp(float x, float y) {
		this.x = x;
		this.y = y;
		r = 1;
		texture = Textures.BULLET01;
	}

	@Override
	public void setIsFin(boolean b) {
		isFin = b;
	}

	@Override
	public boolean isFin() {
		return isFin;
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
	public float getR() {
		return r;
	}

	@Override
	public void update(float delta) {
		y -= MOVEMENT * delta;

	}

	@Override
	public Texture getTexture() {
		return texture;
	}

	@Override
	public String toString() {
		return String.format("x: %.2f\ty: %.2f\tTexture: " + texture, x, y);
	}
}
