package level;

import path.Para01;
import path.Path;
import path.Path01;
import utils.LinkedList;
import utils.LinkedListImp;
import utils.NodeImp;

import com.badlogic.gdx.utils.Array;

import entity.Enemy;
import entity.EnemyImp;

/**
 * Most basic level.
 * 
 * @author russ
 * 
 */
public class Level {

	// the linkedlist contains all actions to be performed.
	private LinkedList enemyScript = new LinkedListImp();
	// Array of active enemies
	private Array<Enemy> enemies = new Array<Enemy>();

	public Level() {
		demoPath();

	}

	/**
	 * Demonstration of enemies with paths.
	 */
	private void demoPath() {
		Enemy enemy = new EnemyImp();
		enemyScript.add(new NodeImp(enemy, 1));
		Path path = new Para01(1, -1);
		((Para01) path).setSpeed(10);
		enemy = new EnemyImp();
		enemyScript.add(new NodeImp(enemy, 1));
		path = new Path01(5, 0, -5, 5);
		enemy = new EnemyImp();
		enemyScript.add(new NodeImp(enemy, 1));
		// enemy = new EnemyPath(10, float y, float r, int health, float speed,
		// Parametric path);

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
