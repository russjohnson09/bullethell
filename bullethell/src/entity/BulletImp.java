package entity;

import path.Path;

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
	protected final float ox;
	protected final float oy;
	protected float r;
	protected Path path;
	protected Texture texture;

	protected boolean isGrazed = false;

	public BulletImp(float x, float y, float r, Path path, Texture texture) {
		super();
		this.x = ox = x;
		this.y = oy = y;
		this.r = r;
		this.path = path;
		this.texture = texture;
	}

	@Override
	public boolean isFin() {
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
		path.update(delta);

		x = ox + path.getX();
		y = oy + path.getY();

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
}
