package render;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import entity.Bullet;
import entity.Entity;
import entity.Player;

public class Renderer {

	public static final float CAMERA_WIDTH = 24f;
	public static final float CAMERA_HEIGHT = 42.7f;

	private OrthographicCamera cam;

	ShapeRenderer renderer = new ShapeRenderer();

	public Renderer() {
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.cam.update();
		renderer.setProjectionMatrix(cam.combined);

	}

	public void enemy(Entity e) {
		renderer.begin(ShapeType.Circle);
		renderer.setColor(Color.RED);
		renderer.identity();
		renderer.translate(e.getX(), e.getY(), 0);

		renderer.circle(0, 0, e.getR(), 8);

		renderer.end();

	}

	public void player(Player player) {
		renderer.begin(ShapeType.Circle);
		renderer.setColor(Color.BLUE);
		renderer.identity();
		renderer.translate(player.getX(), player.getY(), 0);

		renderer.circle(0, 0, player.getR(), 6);
		renderer.circle(0, 0, player.getR2(), 6);

		renderer.end();

	}

	public void enemyBullet(Bullet bullet, float rotation) {
		renderer.begin(ShapeType.Circle);
		renderer.setColor(Color.RED);

		renderer.identity();
		renderer.translate(bullet.getX(), bullet.getY(), 0);

		renderer.rotate(0, 0, 1, rotation);
		renderer.circle(0, 0, bullet.getR(), 3);

		renderer.end();

	}

	public void playerBullet(Bullet bullet, float rotation) {
		renderer.begin(ShapeType.Circle);
		renderer.setColor(Color.WHITE);
		renderer.identity();
		renderer.translate(bullet.getX(), bullet.getY(), 0);
		renderer.rotate(0, 0, 1, rotation);
		renderer.circle(0, 0, bullet.getR(), 3);
		renderer.end();
	}
}
