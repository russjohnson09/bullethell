package entity;

public class BulletUp extends BulletImp {

	public BulletUp(float x, float y) {
		super(x, y);
	}

	public BulletUp(float x, float y, float r) {
		super(x, y, r);
	}

	public BulletUp(float x, float y, float r, float speed) {
		super(x, y, r, speed);

	}

	@Override
	public void update(float delta) {
		y += speed * delta;
	}

}
