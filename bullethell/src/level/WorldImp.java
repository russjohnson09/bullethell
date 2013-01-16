package level;

import render.Renderer;

import com.badlogic.gdx.utils.Array;

import entity.Enemy;
import entity.Entity;
import entity.Player;
import entity.PlayerImp;

public class WorldImp implements World {

	private Level level;
	private Renderer render;
	private Player player = new PlayerImp();
	private Array<Entity> enemyBullets;
	private Array<Entity> playerBullets;
	private Array<Entity> enemies;

	public WorldImp() {
		level = new Level01();

	}

	/**
	 * Update the entities within our world.
	 */
	@Override
	public void update(float delta) {
		checkPlayerCollision();
		checkEnemyCollision();
		player.update(delta);
		level.update(delta);

	}

	/**
	 * Checks for collision between player bullets and enemy. Decrements health
	 * if collision takes place.
	 */
	private void checkEnemyCollision() {
		for (Entity enemy : enemies) {
			for (Entity bullet : playerBullets) {
				if (isCollision(enemy.getX(), enemy.getY(), enemy.getR(),
						bullet.getX(), bullet.getY(), bullet.getR())) {
					((Enemy) enemy).decrementHealth();
				}
			}
		}

	}

	private void checkPlayerCollision() {
		for (Entity bullet : enemyBullets) {
			if (isCollision(player.getX(), player.getY(), player.getR(),
					bullet.getX(), bullet.getY(), bullet.getR())) {
				player.decrementHealth();
			}
		}

	}

	@Override
	public void render() {
		renderPlayer();
		renderEnemy();
		renderPlayerBullet();
		renderEnemyBullet();

	}

	private void renderEnemyBullet() {
		// TODO Auto-generated method stub

	}

	private void renderPlayerBullet() {
		// TODO Auto-generated method stub

	}

	private void renderEnemy() {
		// TODO Auto-generated method stub

	}

	private void renderPlayer() {
		// TODO Auto-generated method stub

	}

	private boolean isCollision(float x, float y, float r, float x2, float y2,
			float r2) {
		return Math.pow(x - x2, 2) + Math.pow(y - y2, 2) < Math.pow(r + r2, 2);
	}

}
