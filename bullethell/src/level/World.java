package level;

import render.Renderer;

import com.badlogic.gdx.utils.Array;

import entity.Bullet;
import entity.Enemy;
import entity.Player;

public class World {

	private Level level;
	private Renderer renderer;
	private Player player;

	// used for spinning bullets
	private float rotation = 0;

	public World(Renderer renderer) {
		level = new Level();
		this.renderer = renderer;
		player = new Player();

	}

	/**
	 * Update the entities within our world.
	 */
	public void update(float delta) {
		checkPlayerCollision();
		checkEnemyCollision();
		updateEnemies(delta);
		player.update(delta);
		updatePlayerBullets(delta);
		updateEnemyBullets(delta);
		level.update(delta);
		render();

		rotation += delta * 6000f;

	}

	private void updateEnemyBullets(float delta) {
		Array<Bullet> bullets = Enemy.getBullets();
		Bullet bullet;
		for (int i = bullets.size - 1; i >= 0; i--) {
			bullet = bullets.get(i);
			bullet.update(delta);
			if (bullet.isFin()) {
				bullets.removeIndex(i);
			}
		}

	}

	private void updatePlayerBullets(float delta) {
		Array<Bullet> bullets = player.getBullets();
		Bullet bullet;
		for (int i = bullets.size - 1; i >= 0; i--) {
			bullet = bullets.get(i);
			bullet.update(delta);
			if (bullet.isFin()) {
				bullets.removeIndex(i);
			}
		}

	}

	private void updateEnemies(float delta) {
		Array<Enemy> enemies = level.getEnemies();
		for (int i = enemies.size - 1; i >= 0; i--) {
			Enemy enemy = enemies.get(i);
			enemy.update(delta);
			if (enemy.isFin())
				enemies.removeIndex(i);
		}

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
				if (isCollision(enemy.getPos().x, enemy.getPos().y,
						enemy.getR(), bullet.getPos().x, bullet.getPos().y,
						bullet.getR())) {
					enemy.setHealth(enemy.getHealth() - 1);
					bullets.removeIndex(i);
				}
			}
		}

	}

	private void checkPlayerCollision() {
		Array<Bullet> bullets = Enemy.getBullets();
		Bullet bullet;
		for (int i = bullets.size - 1; i >= 0; i--) {
			bullet = bullets.get(i);
			if (isCollision(player.getPos().x, player.getPos().y,
					player.getR(), bullet.getPos().x, bullet.getPos().y,
					bullet.getR())) {
				if (player.getInvincible() < 0) {
					player.setHealth(player.getHealth() - 1);
				}
				bullets.removeIndex(i);
			}
		}

	}

	public void render() {
		renderPlayer();
		renderEnemy();
		renderPlayerBullet();
		renderEnemyBullet();

	}

	private void renderEnemyBullet() {
		for (Bullet bullet : Enemy.getBullets()) {
			renderer.enemyBullet(bullet, rotation);
		}

	}

	private void renderPlayerBullet() {
		for (Bullet bullet : player.getBullets()) {
			renderer.playerBullet(bullet, rotation);
		}

	}

	private void renderEnemy() {
		for (Enemy enemy : level.getEnemies()) {
			renderer.enemy(enemy);
		}

	}

	private void renderPlayer() {
		renderer.player(player);

	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	private boolean isCollision(float x, float y, float r, float x2, float y2,
			float r2) {
		return Math.pow(x - x2, 2) + Math.pow(y - y2, 2) < Math.pow(r + r2, 2);
	}

	@Override
	public String toString() {
		String str = "";
		str += "Player: ";
		str += player;
		str += "Player bullets: ";
		str += player.getBullets();
		str += "\nLevel: ";
		str += level;
		return str;
	}

}
