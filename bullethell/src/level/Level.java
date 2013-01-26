package level;

import path.Path01;
import path.PathList;
import utils.LinkedList;
import utils.Node;
import barrage.Enemies;
import barrage.Wave;

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
		enemyScript.add(new Node(Wave.kaguya(), 1));

	}

	private void demo2() {
		PathList path;
		path = new PathList();
		path.add(new Path01(0, 0, -10, 0), 0f);
		path.add(new Path01(0, 0, 10, 0), 2f);

		Enemy enemy;
		enemy = new Enemy(10, 30, 1, 5, path, new LinkedList());
		enemyScript.add(new Node(enemy, 1));

	}

	/**
	 * Demonstration of enemies with paths.
	 */
	private void demo() {
		enemyScript.add(new Node(Enemies.Swooping(), 0));
		enemyScript.add(new Node(new Enemy(), 0));
		enemyScript.add(new Node(Enemies.Swooping(), 1));
		enemyScript.add(new Node(new Enemy(), 1));

		PathList path;
		path = new PathList();
		path.add(new Path01(0, 0, -10, 0), 0f);
		path.add(new Path01(0, 0, 10, 0), 5f);

		Enemy enemy;
		enemy = new Enemy(10, 50, 1, 5, path, new LinkedList());
		enemyScript.add(new Node(enemy, 1));

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
