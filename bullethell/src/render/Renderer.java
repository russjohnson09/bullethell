package render;

import java.util.Random;

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

	public void render(Entity e) {
		renderer.begin(ShapeType.Rectangle);
		renderer.setColor(Color.RED);
		renderer.identity();
		renderer.translate(e.getX(), e.getY(), 0);
		renderer.rect(-e.getR(), -e.getR(), e.getR() * 2, e.getR() * 2);

		renderer.end();

	}

	public void renderPlayer(Player e) {
		renderer.begin(ShapeType.Circle);
		renderer.setColor(Color.BLUE);
		renderer.identity();
		renderer.translate(e.getX(), e.getY(), 0);
		renderer.rotate(0, 0, 1, 45);
		renderer.circle(0, 0, e.getR(), 8);
		renderer.circle(0, 0, e.getR2(), 8);

		renderer.end();

	}

	public void render(Entity e, float f) {
		renderer.begin(ShapeType.Rectangle);
		renderer.rect(e.getX() - f, e.getY() - f, f * 2, f * 2);
		renderer.end();
	}

	public void rotatingTriangle(Bullet bullet, float rotation, boolean madRave) {
		if (madRave) {
			Random random = new Random();
			int r = random.nextInt(4);
			if (r == 0) {
				renderer.setColor(Color.MAGENTA);
			} else if (r == 1) {
				renderer.setColor(Color.PINK);
			} else if (r == 2) {
				renderer.setColor(Color.RED);
			} else {

				renderer.setColor(Color.YELLOW);

			}
		} else {
			renderer.setColor(Color.RED);
		}
		renderer.begin(ShapeType.Circle);

		renderer.identity();
		renderer.translate(bullet.getX(), bullet.getY(), 0);
		renderer.rotate(0, 0, 1, rotation);
		renderer.circle(0, 0, bullet.getR(), 3);

		renderer.end();

	}
}
