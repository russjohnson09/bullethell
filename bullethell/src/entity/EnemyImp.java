package entity;

import utils.Textures;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

/**
 * Most basic implementation of Enemy. Moves from left to right across the
 * screen.
 * 
 * @author russ
 * 
 */
public class EnemyImp implements Enemy {

	public static final float MOVEMENT = 1;
	public static final float BOUNDARY = 10;

	private int health;
	private float x;
	private float y;
	private float r;
	private Texture texture;
	private static Array<Entity> list = new Array<Entity>();

	public EnemyImp() {
		health = 10;
		x = 0;
		y = 10;
		r = 1;
		texture = Textures.ENEMY01;

	}

	@Override
	public boolean isFin() {
		return x > BOUNDARY;
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
		x += MOVEMENT;

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
	public Array<Entity> getList() {
		return list;
	}

	@Override
	public void add(Entity entity) {
		list.add(entity);

	}

	@Override
	public float getR() {
		return r;
	}

	@Override
	public void decrementHealth() {
		health--;

	}

}
