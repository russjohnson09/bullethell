package level;

import path.Path;
import path.PathList;
import utils.LinkedList;
import utils.Node;
import barrage.Enemies;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import entity.Bullet;
import entity.Enemy;

/**
 * Most basic level.
 * 
 * @author russ
 * 
 */
public class Level {

	// the linkedlist contains all actions to be performed.
	private LinkedList<Enemy> enemyScript = new LinkedList<Enemy>();
	// Array of active enemies
	private Array<Enemy> enemies = new Array<Enemy>();

	public Level() {

		Enemy sakyun = new Enemy(new Vector2(0, 30), 1, 5, new PathList(
				new Vector2(5, 0)), new LinkedList<Bullet>());

		sakyun.pathlist.pathList.add(new Node<Path>(new Path(-5, 0), 1f));
		
		sakyun.pathlist.pathList.add(new Node<Path>(new Path(1, 0), 0.5f));
		
		for (int i = 0; i < 100; i++){
			sakyun.pathlist.pathList.add(new Node<Path>(new Path(10, 0), 0.5f));
			sakyun.pathlist.pathList.add(new Node<Path>(new Path(-10, 0), 0.5f));
		}
			
		
		LinkedList<Bullet> bullets = new LinkedList<Bullet>();
		
		for (int i = 0; i < 100; i++)
			bullets.add(new Node<Bullet>(new Bullet(sakyun, 0.5f, new Path(new Vector2(0,
					-5))),0.1f));
		
		sakyun.bulletScript = bullets;

		enemyScript.add(new Node<Enemy>(sakyun, 1f));

		enemyScript.add(new Node<Enemy>(new Enemy(new Vector2(0, 40), 1, 5,
				new PathList(new Vector2(5, 0)), new LinkedList<Bullet>()), 1));

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
