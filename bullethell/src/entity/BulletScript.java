package entity;

import utils.LinkedList;

public class BulletScript implements Entity {

	protected LinkedList bulletScript = new LinkedList();

	public BulletScript(LinkedList bulletScript) {
		this.bulletScript = bulletScript;
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
	public void setX(float x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setY(float y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(float delta) {
		Bullet b = (Bullet) bulletScript.update(delta);
		Enemy.getBullets().add(b);
		b = (Bullet) bulletScript.update(0);
		while (b != null) {
			Enemy.getBullets().add(b);
			b = (Bullet) bulletScript.update(0);
		}

	}

	@Override
	public float getR() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setR(float r) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isFin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFin(boolean b) {
		// TODO Auto-generated method stub

	}

}
