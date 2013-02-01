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
	public LinkedList<Enemy> enemyScript = new LinkedList<Enemy>();
	// Array of active enemies
	public Array<Enemy> enemies = new Array<Enemy>();

	public boolean isFin = false;

	public Enemy boss;
	public Array<Enemy> bosses = new Array<Enemy>();
	public int bossNumber = 0;

	public World world;
	
	public boolean win = false;

	public Level(World world) {

		this.world = world;

		// Wave.wave1(enemyScript);

		boss = Enemies.boss1();

		enemyScript.add(new Node<Enemy>(boss, 0));

		bosses.add(Enemies.boss2(world));

		bosses.add(Enemies.boss3(world.player));

		// world1();

	}

	private void world1() {
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

		LinkedList<Bullet> bullets = teruyo.bulletScript;

		for (int i = 0; i < 100; i++) {
			bullets.add(new Node<Bullet>(
					new Bullet(teruyo, 1, new Path(0, -5)), 1));
			bullets.add(new Node<Bullet>(
					new Bullet(teruyo, 1, new Path(2, -5)), 0.5f));
		}

		enemyScript.add(new Node<Enemy>(teruyo, 1f));

	}

	private void world2() {
		Enemy sakyun = new Enemy(new Vector2(0, 30), 1, 5, new PathList(
				new Vector2(5, 0)), new LinkedList<Bullet>());

		sakyun.isBoss = true;

		sakyun.pathlist.pathlist.add(new Node<Path>(new Path(-5, 0), 1f));

		sakyun.pathlist.pathlist.add(new Node<Path>(new Path(1, 0), 0.5f));

		for (int i = 0; i < 100; i++) {
			sakyun.pathlist.pathlist.add(new Node<Path>(new Path(10, 0), 0.5f));
			sakyun.pathlist.pathlist
					.add(new Node<Path>(new Path(-10, 0), 0.5f));
		}

		LinkedList<Bullet> bullets = new LinkedList<Bullet>();

		for (int i = 0; i < 100; i++)
			bullets.add(new Node<Bullet>(new Bullet(sakyun, 0.5f, new Path(
					new Vector2(0, -5))), 0.1f));

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

		if (boss.health < 0) {
			//TODO effect for erasing bullets
			//erase bullets
			Enemy.bullets = new Array<Bullet>();
			
			//go to next boss;
			if (bossNumber < bosses.size){
				boss = bosses.get(bossNumber);
				enemyScript.add(new Node<Enemy>(boss, 1));
				bossNumber++;
			}
			else
				win = true;

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
