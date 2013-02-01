package bullethell;

import java.util.HashMap;
import java.util.Map;

import level.World;
import render.Renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Vector2;

import entity.Player;

public class GameScreen implements Screen, InputProcessor {

	private World world;
	private Renderer renderer;
	public float delta;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		world.update(delta);

	}

	@Override
	public void resize(int width, int height) {
		// TODO

	}

	@Override
	public void show() {
		renderer = new Renderer();
		world = new World(renderer);
		Gdx.input.setInputProcessor(this);

	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/**
	 * Only controllable object is the player.
	 */
	@Override
	public boolean keyDown(int keycode) {
		Player player = world.player;
		Vector2 v = player.v;
		if (keycode == Keys.SHIFT_LEFT)
			player.slow = true;
		else if (keycode == Keys.Z)
			player.isFiring = true;
		else if (keycode == Keys.LEFT)
			v.x = -1;
		else if (keycode == Keys.RIGHT)
			v.x = 1;
		else if (keycode == Keys.DOWN)
			v.y = -1;
		else if (keycode == Keys.UP)
			v.y = 1;

		return true;

	}

	@Override
	public boolean keyUp(int keycode) {
		Player player = world.player;
		Vector2 v = player.v;
		if (keycode == Keys.SHIFT_LEFT)
			player.slow = false;
		else if (keycode == Keys.Z)
			player.isFiring = false;
		else if (keycode == Keys.LEFT)
			v.x = (v.x == -1) ? 0 : v.x;
		else if (keycode == Keys.RIGHT)
			v.x = (v.x == 1) ? 0 : v.x;
		else if (keycode == Keys.DOWN)
			v.y = (v.y == -1) ? 0 : v.y;
		else if (keycode == Keys.UP)
			v.y = (v.y == 1) ? 0 : v.y;

		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchMoved(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
