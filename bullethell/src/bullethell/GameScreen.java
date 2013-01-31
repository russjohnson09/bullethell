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

	private Map<Key, Boolean> key = new HashMap<Key, Boolean>();

	private enum Key {
		LEFT, RIGHT, UP, DOWN, FIRE, BOMB, SLOW
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		world.update(delta);

		System.out.println(world);

		updatePlayerState(delta);

	}

	private void updatePlayerState(float delta) {
		Player player = world.getPlayer();

		if (key.get(Key.FIRE))
			player.isFiring = true;
		else
			player.isFiring = false;

		updatePosition(player, delta);

	}

	private void updatePosition(Player player, float delta) {
		float movement = (key.get(Key.SLOW)) ? player.SPEED / 2 : player.SPEED;
		Vector2 pos = player.pos;
		if (key.get(Key.LEFT)) {
			pos.x -= movement * delta;
		}
		if (key.get(Key.RIGHT)) {
			pos.x += movement * delta;

		}

		if (key.get(Key.DOWN)) {
			pos.y -= movement * delta;
		}
		if (key.get(Key.UP)) {
			pos.y += movement * delta;

		}

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

		key.put(Key.UP, false);
		key.put(Key.DOWN, false);
		key.put(Key.LEFT, false);
		key.put(Key.RIGHT, false);
		key.put(Key.FIRE, false);
		key.put(Key.BOMB, false);
		key.put(Key.SLOW, false);

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
		if (keycode == Keys.LEFT)
			key.put(Key.LEFT, true);
		if (keycode == Keys.RIGHT)
			key.put(Key.RIGHT, true);
		if (keycode == Keys.DOWN)
			key.put(Key.DOWN, true);
		if (keycode == Keys.UP)
			key.put(Key.UP, true);
		if (keycode == Keys.Z)
			key.put(Key.FIRE, true);
		if (keycode == Keys.SHIFT_LEFT)
			key.put(Key.SLOW, true);
		if (keycode == Keys.SPACE)
			key.put(Key.BOMB, true);
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.LEFT)
			key.put(Key.LEFT, false);
		if (keycode == Keys.RIGHT)
			key.put(Key.RIGHT, false);
		if (keycode == Keys.DOWN)
			key.put(Key.DOWN, false);
		if (keycode == Keys.UP)
			key.put(Key.UP, false);
		if (keycode == Keys.Z)
			key.put(Key.FIRE, false);
		if (keycode == Keys.SHIFT_LEFT)
			key.put(Key.SLOW, false);
		if (keycode == Keys.SPACE)
			key.put(Key.BOMB, false);
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
