package level;

import render.Renderer;

import com.badlogic.gdx.utils.Array;

import entity.Bullet;
import entity.Enemy;
import entity.EnemyImp;
import entity.Player;
import entity.PlayerImp;

public class WorldImp implements World {

	private Level level;
	private Renderer renderer;
	private Player player = new PlayerImp();

	public WorldImp(Renderer renderer) {
		level = new LevelImp();
		this.renderer = renderer;

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
		render();

	}

	/**
	 * Checks for collision between player bullets and enemy. Decrements health
	 * if collision takes place.
	 */
	private void checkEnemyCollision() {
		Array<Enemy> enemies = level.getEnemies();
		Array<Bullet> bullets = player.getBullets();
		Bullet bullet;
		for (Enemy enemy : enemies) {
			for (int i = bullets.size - 1; i >= 0; i--) {
				bullet = bullets.get(i);
				if (isCollision(enemy.getX(), enemy.getY(), enemy.getR(),
						bullet.getX(), bullet.getY(), bullet.getR())) {
					enemy.decrementHealth();
					bullets.removeIndex(i);
				}
			}
		}

	}

	private void checkPlayerCollision() {
		Array<Bullet> bullets = EnemyImp.getBullets();
		Bullet bullet;
		for (int i = bullets.size - 1; i >= 0; i--) {
			bullet = bullets.get(i);
			if (isCollision(player.getX(), player.getY(), player.getR(),
					bullet.getX(), bullet.getY(), bullet.getR())) {
				if (!player.getInvincible()) {
					player.decrementHealth();
				}
				bullets.removeIndex(i);
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
		for (Bullet bullet : EnemyImp.getBullets()) {
			renderer.render(bullet);
		}

	}

	private void renderPlayerBullet() {
		for (Bullet bullet : player.getBullets()) {
			renderer.render(bullet);
		}

	}

	private void renderEnemy() {
		for (Enemy enemy : level.getEnemies()) {
			renderer.render(enemy);
		}

	}

	private void renderPlayer() {
		renderer.render(player);

	}

	private boolean isCollision(float x, float y, float r, float x2, float y2,
			float r2) {
		return Math.pow(x - x2, 2) + Math.pow(y - y2, 2) < Math.pow(r + r2, 2);
	}

	public String toString() {
		String str = "";
		str += "Player: ";
		str += player;
		str += "\nLevel: ";
		str += level;
		return str;
	}

}