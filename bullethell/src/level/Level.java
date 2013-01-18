package level;

import utils.LinkedList;
import utils.Node;
import barrage.Enemies;

import com.badlogic.gdx.utils.Array;

import entity.Enemy;

/**
 * Most basic level.
 * 
 * @author russ
 * 
 */
public class Level {

	// the linkedlist contains all actions to be performed.
	private LinkedList enemyScript = new LinkedList();
	// Array of active enemies
	private Array<Enemy> enemies = new Array<Enemy>();

	public Level() {
		demo();

	}

	/**
	 * Demonstration of enemies with paths.
	 */
	private void demo() {
		enemyScript.add(new Node(Enemies.Swooping(), 0));
		enemyScript.add(new Node(new Enemy(), 0));
		enemyScript.add(new Node(Enemies.Swooping(), 1));
		enemyScript.add(new Node(new Enemy(), 1));

	}

	public void update(float delta) {
		Enemy enemy = (Enemy) enemyScript.update(delta);
		if (enemy != null) {
			enemies.add(enemy);
		}

	}

	public Array<Enemy> getEnemies() {
		return enemies;
	}

	@Override
	public String toString() {
		String str = "";
		for (Enemy enemy : enemies) {
			str += enemy;
		}
		return str + enemies.size;
	}

}
