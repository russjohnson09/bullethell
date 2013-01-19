package bullethell;

import java.util.HashMap;
import java.util.Map;

import level.World;
import render.Renderer;
import states.PosNegZero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;

import entity.Player;

public class GameScreen implements Screen, InputProcessor {

	World world;
	Renderer renderer;

	private enum Key {
		LEFT, RIGHT, UP, DOWN, FIRE, BOMB, SLOW
	}

	private Map<Key, Boolean> key = new HashMap<Key, Boolean>();

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		world.update(delta);
		System.out.println(world);

		updatePlayerState();

	}

	private void updatePlayerState() {
		Player player = world.getPlayer();
		if (key.get(Key.LEFT)) {
			if (key.get(Key.RIGHT)) {
				player.setStateX(PosNegZero.ZERO);
			} else {
				player.setStateX(PosNegZero.NEG);
			}
		} else if (key.get(Key.RIGHT)) {
			player.setStateX(PosNegZero.POS);
		} else {
			player.setStateX(PosNegZero.ZERO);
		}

		if (key.get(Key.DOWN)) {
			if (key.get(Key.UP)) {
				player.setStateY(PosNegZero.ZERO);
			} else {
				player.setStateY(PosNegZero.NEG);
			}
		} else if (key.get(Key.UP)) {
			player.setStateY(PosNegZero.POS);
		} else {
			player.setStateY(PosNegZero.ZERO);
		}

		if (key.get(Key.SLOW))
			player.setSlow(true);
		else
			player.setSlow(false);

		if (key.get(Key.FIRE))
			player.setFiring(true);
		else
			player.setFiring(false);

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
