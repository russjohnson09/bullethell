package entity;

import utils.Textures;

import com.badlogic.gdx.graphics.Texture;

/**
 * Basic implementation of bullet goes upwards from (x,y)
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getR() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public Texture getTexture() {
		// TODO Auto-generated method stub
		return null;
	}

}
