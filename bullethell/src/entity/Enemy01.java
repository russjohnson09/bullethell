package entity;

import utils.LinkedListImp;
import utils.NodeImp;

public class Enemy01 extends EnemyImp {

	// bullets to be spawned
	private LinkedListImp listOfBullets = new LinkedListImp();

	public Enemy01(float x, float y) {
		super(x, y);
	}

	@Override
	public void update(float delta) {
		x += speed * delta;
		delay -= delta;
		updateListOfBullets(delta);
		updateBullets(delta);

	}

	private void updateListOfBullets(float delta) {
		Bullet bullet = (Bullet) listOfBullets.update(delta);
		if (bullet != null) {
			bullets.add(bullet);
		}

	}

	public void addListOfBullets(Bullet bullet, float delay) {
		listOfBullets.add(new NodeImp(bullet, delay));
	}

}
