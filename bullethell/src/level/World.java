package level;

import render.Renderer;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import entity.Bullet;
import entity.Enemy;
import entity.Player;

public class World {

	private static final float MARGIN = 5;
	public Level level;
	public Renderer renderer;
	public Player player;

	public int fps;

	int enemyKills = 0;

	// used for spinning bullets
	public float rotation = 0;
	public int grazedBullets = 0;

	public float delay = 1f;

	public World(Renderer renderer) {
		player = new Player();
		level = new Level(this);
		this.renderer = renderer;

	}

	/**
	 * Update the entities within our world.
	 */
	public void update(float delta) {
		if (level.isFin) {
		}

		delay -= delta;

		// update fps every second
		if (delay < 0) {
			delay = 1f;
			fps = (int) (1 / delta);
		}

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
		Array<Bullet> bullets = Enemy.bullets;
		Bullet bullet;
		for (int i = bullets.size - 1; i >= 0; i--) {
			bullet = bullets.get(i);
			bullet.update(delta);
			if (outOfBounds(bullet.pos)) {
				bullets.removeIndex(i);
			}
		}

	}

	private boolean outOfBounds(Vector2 pos) {
		return !(0 < pos.x + MARGIN && pos.x < Renderer.CAMERA_WIDTH + MARGIN
				&& 0 < pos.y + MARGIN && pos.y < Renderer.CAMERA_HEIGHT
				+ MARGIN);
	}

	private void updatePlayerBullets(float delta) {
		Array<Bullet> bullets = player.bullets;
		Bullet bullet;
		for (int i = bullets.size - 1; i >= 0; i--) {
			bullet = bullets.get(i);
			bullet.update(delta);
			if (outOfBounds(bullet.pos)) {
				bullets.removeIndex(i);
			}
		}

	}

	private void updateEnemies(float delta) {
		Array<Enemy> enemies = level.getEnemies();
		for (int i = enemies.size - 1; i >= 0; i--) {
			Enemy enemy = enemies.get(i);
			enemy.update(delta);
			if (enemy.health < 0) {
				enemyKills++;
				enemies.removeIndex(i);
			}
			if (outOfBounds(enemy.pos))
				enemies.removeIndex(i);
		}

	}

	/**
	 * Checks for collision between player bullets and enemy. Decrements health
	 * if collision takes place.
	 */
	private void checkEnemyCollision() {
		Array<Enemy> enemies = level.getEnemies();
		Array<Bullet> bullets = player.bullets;
		Bullet bullet;
		for (Enemy enemy : enemies) {
			for (int i = bullets.size - 1; i >= 0; i--) {
				bullet = bullets.get(i);
				if (isCollision(enemy.pos, enemy.r, bullet.pos, bullet.r)) {
					// TODO change to nonkiller bullets
					// enemy.health--;
					enemy.health -= 100000;
					bullets.removeIndex(i);
				}
			}
		}

	}

	private void checkPlayerCollision() {
		Array<Bullet> bullets = Enemy.bullets;
		Bullet bullet;
		for (int i = bullets.size - 1; i >= 0; i--) {
			bullet = bullets.get(i);
			if (isCollision(player.pos, player.R1, bullet.pos, bullet.r)) {
				if (player.invincible < 0) {
					player.lives--;
					player.invincible = 5f;
				}
				bullets.removeIndex(i);
			}

			if (!bullet.isGrazed
					&& isCollision(player.pos, player.R2, bullet.pos, bullet.r)) {
				bullet.isGrazed = true;
				grazedBullets++;
			}
		}

	}

	public void render() {
		renderPlayer();
		renderEnemy();
		renderPlayerBullet();
		renderEnemyBullet();
		renderer.drawScore(grazedBullets, enemyKills, player.lives, fps);

	}

	private void renderEnemyBullet() {
		for (Bullet bullet : Enemy.bullets) {
			renderer.enemyBullet(bullet, rotation);
		}

	}

	private void renderPlayerBullet() {
		for (Bullet bullet : player.bullets) {
			renderer.playerBullet(bullet, rotation);
		}

	}

	private void renderEnemy() {
		for (Enemy enemy : level.getEnemies()) {
			renderer.enemy(enemy);
			if (enemy.isBoss)
				renderer.drawEnemyHealth(enemy.health);
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

	private boolean isCollision(Vector2 pos1, float r, Vector2 pos2, float r2) {
		return Math.pow(pos1.x - pos2.x, 2) + Math.pow(pos1.y - pos2.y, 2) < Math
				.pow(r + r2, 2);
	}

	@Override
	public String toString() {
		String str = "";
		str += enemyKills + "\n";
		str += grazedBullets + "\n";
		str += player.lives + "\n";
		return str;
	}

	// @Override
	// public String toString() {
	// String str = "";
	// str += "Player: ";
	// str += player;
	// str += "Player bullets: ";
	// str += player.bullets;
	// str += "\nLevel: ";
	// str += level;
	// return str;
	// }

}
