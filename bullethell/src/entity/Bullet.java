package entity;

import com.badlogic.gdx.math.Vector2;

import path.Path;

/**
 * Basic implementation of bullet goes down from (x,y)
 * 
 * @author russ
 * 
 */
public class Bullet {

	// number of bullets grazed (used in score)
	public static int numberGraze = 0;

	public Vector2 oPos, pos;

	// enemy that spawned bullet
	public Enemy spawner;
	public float r;
	public Path path;

	public boolean isGrazed = false;

	public Bullet(Vector2 pos, float r, Path path) {
		this.pos = pos.cpy();
		oPos = pos.cpy();
		this.r = r;
		this.path = path;
		spawner = null;

	}

	public Bullet(Enemy spawner, float r, Path path) {
		this.spawner = spawner;
		pos = oPos = new Vector2(0, 0);
		this.r = r;
		this.path = path;

	}

	public void update(float delta) {

		// set the location of the bullet to the entity that
		// spawned it and set spawner to null
		if (spawner != null) {
			pos = oPos = spawner.pos;
			spawner = null;
		}

		path.update(delta);

		pos.x = oPos.x + path.pos.x;
		pos.y = oPos.y + path.pos.y;

	}

	@Override
	public String toString() {
		return String.format("x: %.2f\ty: %.2f\t", pos.x, pos.y);
	}
}
