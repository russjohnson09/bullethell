package entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

/**
 * A null entity that acts as a delay.
 * 
 * @author russ
 * 
 */
public class NullEntity implements Entity {

	float delay;

	NullEntity(float delay) {
		this.delay = delay;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isFin() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Always return 0.
	 */
	@Override
	public float getX() {
		return 0;
	}

	/**
	 * Always return 0.
	 */
	@Override
	public float getY() {
		return 0;
	}

	/**
	 * Decrements the delay.
	 * 
	 * @param delta
	 *            time passed in seconds
	 */
	@Override
	public void update(float delta) {
		delay -= delta;

	}

	@Override
	public Array<Entity> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Entity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public float getR() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return null;
	}

}
