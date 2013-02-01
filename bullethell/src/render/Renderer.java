package render;

import level.World;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import entity.Bullet;
import entity.Enemy;
import entity.Player;

public class Renderer {

	public static final float CAMERA_WIDTH = 24f;
	public static final float CAMERA_HEIGHT = 42.7f;

	public float ppuX = 10;
	public float ppuY = 10;

	private OrthographicCamera cam;

	ShapeRenderer renderer = new ShapeRenderer();

	SpriteBatch spriteBatch = new SpriteBatch();
	BitmapFont font = new BitmapFont();

	public Renderer() {
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.cam.update();
		renderer.setProjectionMatrix(cam.combined);

	}

	public void enemy(Enemy enemy) {
		renderer.begin(ShapeType.Circle);
		renderer.setColor(Color.RED);
		renderer.identity();

		renderer.translate(enemy.pos.x, enemy.pos.y, 0);

		renderer.circle(0, 0, enemy.r, 8);

		renderer.end();

	}

	public void player(Player player) {
		renderer.begin(ShapeType.Circle);
		renderer.setColor(Color.BLUE);
		renderer.identity();
		renderer.translate(player.pos.x, player.pos.y, 0);

		renderer.circle(0, 0, player.R1, 6);
		renderer.circle(0, 0, player.R2, 6);

		renderer.end();

	}

	public void enemyBullet(Bullet bullet, float rotation) {
		renderer.begin(ShapeType.Circle);
		renderer.setColor(Color.RED);

		renderer.identity();
		renderer.translate(bullet.pos.x, bullet.pos.y, 0);

		renderer.rotate(0, 0, 1, rotation);
		renderer.circle(0, 0, bullet.r, 3);

		renderer.end();

	}

	public void playerBullet(Bullet bullet, float rotation) {
		renderer.begin(ShapeType.Circle);
		renderer.setColor(Color.WHITE);
		renderer.identity();
		renderer.translate(bullet.pos.x, bullet.pos.y, 0);
		renderer.rotate(0, 0, 1, rotation);
		renderer.circle(0, 0, bullet.r, 3);
		renderer.end();
	}

	public void drawScore(int graze, int kills, int lives, int fps) {
		spriteBatch.begin();
		font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		font.setScale(0.8f);
		font.draw(spriteBatch, "Graze: " + graze, ppuX, (CAMERA_HEIGHT - 2)
				* ppuY);
		font.draw(spriteBatch, "Kills: " + kills, ppuX, (CAMERA_HEIGHT - 4)
				* ppuY);
		font.draw(spriteBatch, "Lives: " + lives, ppuX, (CAMERA_HEIGHT - 6)
				* ppuY);

		font.draw(spriteBatch, "FPS: " + fps, 18 * ppuX, (CAMERA_HEIGHT - 2)
				* ppuY);
		spriteBatch.end();
	}

	public void drawEnemyHealth(int health) {
		renderer.begin(ShapeType.FilledRectangle);

		renderer.identity();
		renderer.filledRect(12 - health / 10f, 41, health / 5f, 1);

		renderer.end();

	}

	public void win(World world) {
		spriteBatch.begin();
		font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		font.setScale(3f);
		font.draw(spriteBatch, "You win!", ppuX * 3, 21 * ppuY);
		font.draw(spriteBatch, "Graze: " + world.grazedBullets, ppuX, (CAMERA_HEIGHT - 2)
				* ppuY);
		font.draw(spriteBatch, "Kills: " + world.enemyKills, ppuX, (CAMERA_HEIGHT - 6)
				* ppuY);
		spriteBatch.end();
		
	}

	public void lose(World world) {
		spriteBatch.begin();
		font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		font.setScale(3f);
		font.draw(spriteBatch, "You lose!", ppuX * 3, 21 * ppuY);
		font.draw(spriteBatch, "Graze: " + world.grazedBullets, ppuX, (CAMERA_HEIGHT - 2)
				* ppuY);
		font.draw(spriteBatch, "Kills: " + world.enemyKills, ppuX, (CAMERA_HEIGHT - 6)
				* ppuY);
		
		spriteBatch.end();
		
	}
}
