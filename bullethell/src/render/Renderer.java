package render;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import entity.Entity;

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
			debugRenderer.rect(e.getX() - e.getR(), e.getY() - e.getR(),
					e.getR() * 2, e.getR() * 2);
			debugRenderer.end();
		}

	}

	public void setSize(int width, int height) {
		ppuX = width / CAMERA_WIDTH;
		ppuY = height / CAMERA_HEIGHT;

	}

}
