package entity;

import path.PathList;
import render.Renderer;
import utils.LinkedList;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/**
 * Most basic implementation of Enemy. Moves from left to right across the
 * screen.
 * 
 * @author russ
 * 
 */
public class Enemy {

	// Enemy array of bullets
	public static Array<Bullet> bullets = new Array<Bullet>();

	// the original position of the enemy and current position
	public Vector2 oPos, pos;

	public float r;
	public int health;

	public PathList pathlist;

	public LinkedList<Bullet> bulletScript = new LinkedList<Bullet>();

	public boolean isBoss = false;

	public Enemy() {
	}

	public Enemy(Vector2 pos, float r, int health, PathList pathlist,
			LinkedList<Bullet> bulletScript) {
		this.oPos = pos.cpy();
		this.pos = pos.cpy();
		this.r = r;
		this.health = health;
		this.pathlist = pathlist;
		this.bulletScript = bulletScript;
	}

	public void update(float delta) {
		pathlist.update(delta);
		pos.x = oPos.x + pathlist.pos.x;
		pos.y = oPos.y + pathlist.pos.y;

		if (inBounds()) {
			Bullet b = (Bullet) bulletScript.update(delta);
			if (b != null) {
				bullets.add(b);
			}
			// enemies can fire more than one bullet at a time
			// bulletScript has negative numbers for this
			b = (Bullet) bulletScript.update(0);
			while (b != null) {
				bullets.add(b);
				b = (Bullet) bulletScript.update(0);
			}
		}
	}

	private boolean inBounds() {
		return 0 < pos.x && pos.x < Renderer.CAMERA_WIDTH && 0 < pos.y
				&& pos.y < Renderer.CAMERA_HEIGHT;
	}

	@Override
	public String toString() {
		return String.format("x: %.2f\ty: %.2f", pos.x, pos.y);
	}

}
