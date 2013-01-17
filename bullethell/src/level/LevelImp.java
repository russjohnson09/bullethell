package level;

import path.Para01;
import path.Path;
import path.Path01;
import utils.LinkedList;
import utils.LinkedListImp;
import utils.NodeImp;

import com.badlogic.gdx.utils.Array;

import entity.BulletImp;
import entity.Enemy;
import entity.Enemy01;
import entity.EnemyImp;
import entity.EnemyPath;
import entity.EnemySwooping;

/**
 * Basic implementation of Level. Makes a few things for testing purposes.
 * 
 * @author russ
 * 
 */
public class LevelImp implements Level {

	// the linkedlist contains all actions to be performed.
	private LinkedList enemyScript = new LinkedListImp();
	private boolean isFin = false;
	// Array of active enemies
	private Array<Enemy> enemies = new Array<Enemy>();

	public LevelImp() {
		// demo01();
		// demo02();
		demoPath();

	}

	/**
	 * Demonstration of enemies with paths.
	 */
	private void demoPath() {
		EnemyPath enemy = new EnemyPath();
		enemyScript.add(new NodeImp(enemy, 1));
		Path path = new Para01(1, -1);
		((Para01) path).setSpeed(10);
		enemy = new EnemyPath(-5, 40, 0.5f, 3, 0.2f, path);
		enemyScript.add(new NodeImp(enemy, 1));
		path = new Path01(5, 0, -5, 5);
		enemy = new EnemyPath(3, 40, 0.5f, 3, 0.2f, path);
		enemyScript.add(new NodeImp(enemy, 0));
		// enemy = new EnemyPath(10, float y, float r, int health, float speed,
		// Parametric path);

	}

	private void demo02() {
		Enemy01 enemy = new Enemy01(0, 40);
		enemy.addListOfBullets(new BulletImp(0, 40), 1);

	}

	private void demo01() {
		enemyScript.add(new NodeImp(new EnemyImp(0, 40), 1));
		enemyScript.add(new NodeImp(new EnemySwooping(0, 40), 3));
		enemyScript.add(new NodeImp(new EnemyImp(0, 40), 1));
		enemyScript.add(new NodeImp(new EnemyImp(0, 40), 1));
		Enemy enemy = new EnemyImp(0, 40);
		enemyScript.add(new NodeImp(new EnemyImp(0, 40), 1));

	}

	@Override
	public void update(float delta) {
		if (enemyScript.isEmpty())
			isFin = true;
		else {
			Enemy enemy = (Enemy) enemyScript.update(delta);
			if (enemy != null) {
				enemies.add(enemy);
			}
		}

		updateEnemies(delta);
		EnemyImp.updateBullets(delta);

	}

	private void updateEnemies(float delta) {
		for (int i = enemies.size - 1; i >= 0; i--) {
			Enemy enemy = enemies.get(i);
			enemy.update(delta);
			if (enemy.isFin())
				enemies.removeIndex(i);
		}

	}

	@Override
	public Array<Enemy> getEnemies() {
		return enemies;
	}

	@Override
	public boolean getIsFin() {
		return isFin;
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
