package entity;

import path.Path;
import render.Renderer;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Player {
	
	public final float SPEED = 28;
	public final float DELAY = 0.1f;

	// radius of hitbox
	public final float R1 = 0.2f;
	public final float R2 = 2;

	public final float BULLET_R = 0.2f;
	public final float BULLET_SPEED = 40;

	// player bullets
	public Array<Bullet> bullets = new Array<Bullet>();

	public float timeTilFire = 0.2f;
	public boolean isFiring = false;

	// velocity vector
	public Vector2 v = new Vector2(0,0); 
	public boolean slow = false;

	// if positive player invincible
	public float invincible = 3;

	public Vector2 pos = new Vector2(5, 2);

	public int lives = 3;


	public Player() {
	}

	public void update(float delta) {
		invincible -= delta;
		timeTilFire -= delta;

		float movement = (slow)? SPEED/3 : SPEED; 
		pos.x += v.x * movement * delta;
		pos.y += v.y * movement * delta;
		
		boundsCheck();

		if (isFiring && timeTilFire < 0) {
			bullets.add(new Bullet(pos.cpy(), 0.5f, new Path(new Vector2(0,
					BULLET_SPEED))));
			timeTilFire = DELAY;
		}

	}

	private void boundsCheck() {
		if (pos.x < 0)
			pos.x = 0;
		else if (pos.x > Renderer.CAMERA_WIDTH)
			pos.x = Renderer.CAMERA_WIDTH;
		if (pos.y < 0)
			pos.y = 0;
		else if (pos.y > Renderer.CAMERA_HEIGHT)
			pos.y = Renderer.CAMERA_HEIGHT;

	}

	@Override
	public String toString() {
		return String.format("x: %.2f\ty: %.2f", pos.x, pos.y);
	}
}
