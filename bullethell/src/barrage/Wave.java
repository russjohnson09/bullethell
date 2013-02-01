package barrage;

import path.Path;
import path.PathList;

import com.badlogic.gdx.math.Vector2;

import utils.LinkedList;
import utils.Node;
import entity.Bullet;
import entity.Enemy;

/**
 * This class defines waves of enemies and bosses.
 * 
 * @author russ
 * 
 */
public class Wave {

	public static void wave1(LinkedList<Enemy> enemyScript) {

		LinkedList<Bullet> bullets;
		Enemy e;

		enemyScript.add(new Node<Enemy>(Enemies.doomBot(30, true), 0));

		enemyScript.add(new Node<Enemy>(Enemies.doomBot(40, false), 1));

		enemyScript.add(new Node<Enemy>(Enemies.doomBot(30, true), 1));

		for (int i = 0; i < 10; i++) {
			bullets = new LinkedList<Bullet>();
			e = new Enemy(new Vector2(1, 40), 1, 2, new PathList(),
					new LinkedList<Bullet>());

			e.bulletScript.add(Barrage.fire(0.5f, 100, 1, 1, e));
			e.pathlist.add(new Node<Path>(new Path(new Vector2(5, 0)), 0));

			enemyScript.add(new Node<Enemy>(e, 1));

		}

		for (int i = 0; i < 10; i++) {
			e = new Enemy(new Vector2(10, 30), 1, 50, new PathList(new Vector2(
					5, 0)), new LinkedList<Bullet>());
			enemyScript.add(new Node<Enemy>(e, 1));
		}

		Enemy teruyo = new Enemy(new Vector2(0, 30), 1, 50, new PathList(
				new Vector2(5, 0)), new LinkedList<Bullet>());

		teruyo.isBoss = true;

		teruyo.pathlist.pathlist.add(new Node<Path>(new Path(-5, 0), 1f));

		teruyo.pathlist.pathlist.add(new Node<Path>(new Path(1, 0), 0.5f));

		for (int i = 0; i < 100; i++) {
			teruyo.pathlist.pathlist.add(new Node<Path>(new Path(10, 0), 0.5f));
			teruyo.pathlist.pathlist
					.add(new Node<Path>(new Path(-10, 0), 0.5f));
		}

		bullets = teruyo.bulletScript;

		for (int i = 0; i < 100; i++) {
			bullets.add(new Node<Bullet>(
					new Bullet(teruyo, 1, new Path(0, -5)), 1));
			bullets.add(new Node<Bullet>(
					new Bullet(teruyo, 1, new Path(2, -5)), 0.5f));
		}

		enemyScript.add(new Node<Enemy>(teruyo, 1f));

	}

	/**
	 * An invader type wave.
	 * 
	 * @param enemyScript
	 */
	public static void invaders(LinkedList<Enemy> enemyScript) {
		// TODO Auto-generated method stub

	}
}
