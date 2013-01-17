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

	// number of bullets grazed (used in score)
	protected static int graze = 0;

	protected float x;
	protected float y;
	protected float r;
	protected float speed;
	protected Texture texture;
	// is the bullet location absolute
	protected boolean isAbsolute = false;

	// there has been a collision
	protected boolean isFin = false;

	protected boolean isGrazed;

	public BulletImp(float x, float y) {
		this.x = x;
		this.y = y;
		r = 0.25f;
		speed = 20;
		texture = Textures.BULLET01;
	}

	public BulletImp(float x, float y, float r) {
		this(x, y);
		this.x = x;
		this.y = y;
		this.r = r;
	}

	public BulletImp(float x, float y, float r, float speed) {
		this(x, y, r);
		this.speed = speed;

	}

	@Override
	public void setIsFin(boolean b) {
		isFin = b;
	}

	@Override
	public boolean isFin() {
		return isFin || outOfBounds();
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
	public float getR() {
		return r;
	}

	@Override
	public void update(float delta) {
		y -= speed * delta;

	}

	@Override
	public Texture getTexture() {
		return texture;
	}

	@Override
	public String toString() {
		return String.format("x: %.2f\ty: %.2f\tTexture: " + texture, x, y);
	}

	/**
	 * Increment the total grazes by one.
	 */
	@Override
	public void incGraze() {
		graze++;

	}

	@Override
	public int getGraze() {
		return graze;
	}

	@Override
	public void setIsGrazed() {
		isGrazed = true;

	}

	@Override
	public boolean getIsGrazed() {
		return isGrazed;
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
	public boolean getIsAbsolute() {
		return isAbsolute;
	}

	@Override
	public void setIsAbsolute(boolean b) {
		this.isAbsolute = b;

	}
}
