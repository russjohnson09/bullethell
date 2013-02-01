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
		Enemy teruyo = new Enemy(new Vector2(0, 30), 1, 50, new PathList(
				new Vector2(5, 0)), new LinkedList<Bullet>());
		
		teruyo.isBoss = true;

		teruyo.pathlist.pathList.add(new Node<Path>(new Path(-5, 0), 1f));
		
		teruyo.pathlist.pathList.add(new Node<Path>(new Path(1, 0), 0.5f));
		
		for (int i = 0; i < 100; i++){
			teruyo.pathlist.pathList.add(new Node<Path>(new Path(10, 0), 0.5f));
			teruyo.pathlist.pathList.add(new Node<Path>(new Path(-10, 0), 0.5f));
		}
		
		LinkedList<Bullet> bullets = teruyo.bulletScript;
		
		for (int i = 0; i < 100; i++) {
			bullets.add(new Node<Bullet>(new Bullet(teruyo, 1, new Path(0,-5)),1));
			bullets.add(new Node<Bullet>(new Bullet(teruyo, 1, new Path(2,-5)),0.5f));
		}

		
		enemyScript.add(new Node<Enemy>(teruyo, 1f));
		
	}
}
