package render;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import entity.Bullet;
import entity.Entity;
import entity.Player;

public class Renderer {

	public static final float CAMERA_WIDTH = 24f;
	public static final float CAMERA_HEIGHT = 42.7f;

	private OrthographicCamera cam;

	ShapeRenderer debugRenderer = new ShapeRenderer();

	private SpriteBatch spriteBatch;
	private boolean debug = false;

	private float ppuX; // pixels per unit on the X axis
	private float ppuY; // pixels per unit on the Y axis

	public Renderer(boolean debug) {
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.cam.update();
		this.debug = debug;
		spriteBatch = new SpriteBatch();

	}

	public void render(Entity e) {
		if (debug) {
			debugRenderer.setProjectionMatrix(cam.combined);
			debugRenderer.begin(ShapeType.Rectangle);
			debugRenderer.identity();
			debugRenderer.translate(e.getX(), e.getY(), 0);
			debugRenderer.rotate(0, 0, 1, 45);
			debugRenderer
					.rect(-e.getR(), -e.getR(), e.getR() * 2, e.getR() * 2);

			debugRenderer.end();
		}

	}

	public void renderPlayer(Player e) {
		if (debug) {
			debugRenderer.setProjectionMatrix(cam.combined);
			debugRenderer.begin(ShapeType.Rectangle);
			debugRenderer.identity();
			debugRenderer.translate(e.getX(), e.getY(), 0);
			debugRenderer.rotate(0, 0, 1, 45);
			debugRenderer
					.rect(-e.getR(), -e.getR(), e.getR() * 2, e.getR() * 2);
			debugRenderer.rect(-e.getR2(), -e.getR2(), e.getR2() * 2,
					e.getR2() * 2);

			debugRenderer.end();
		}

	}

	public void render(Entity e, float f) {
		if (debug) {
			debugRenderer.setProjectionMatrix(cam.combined);
			debugRenderer.begin(ShapeType.Rectangle);
			debugRenderer.rect(e.getX() - f, e.getY() - f, f * 2, f * 2);
			debugRenderer.end();
		}
	}

	public void setSize(int width, int height) {
		ppuX = width / CAMERA_WIDTH;
		ppuY = height / CAMERA_HEIGHT;

	}

	public void rotatingTriangle(Bullet bullet, float rotation) {
		debugRenderer.setProjectionMatrix(cam.combined);
		debugRenderer.begin(ShapeType.Triangle);
		debugRenderer.identity();
		debugRenderer.translate(bullet.getX(), bullet.getY(), 0);
		debugRenderer.rotate(0, 0, 1, rotation);
		debugRenderer.triangle(-bullet.getR(), -bullet.getR(), 0,
				bullet.getR(), bullet.getR(), bullet.getR());

		debugRenderer.end();

	}

}
