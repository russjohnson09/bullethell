package level;

import utils.LinkedList;
import utils.LinkedListImp;
import utils.NodeImp;

import com.badlogic.gdx.utils.Array;

import entity.Enemy;
import entity.EnemyImp;

/**
 * Basic implementation of Level. Makes a few things to test.
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
		enemyScript.add(new NodeImp(new EnemyImp(), 1));

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

	public String toString() {
		String str = "";
		for (Enemy enemy : enemies) {
			str += enemy;
		}
		return str + enemies.size;
	}

}
