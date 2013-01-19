package barrage;

import path.PathList;
import utils.LinkedList;
import utils.Node;
import entity.Enemy;

public class Wave {

	public static LinkedList basic() {
		LinkedList list = new LinkedList();
		list.add(new Node(Enemies.Swooping(), 0));
		list.add(new Node(new Enemy(), 0));
		list.add(new Node(Enemies.Swooping(), 1));
		list.add(new Node(new Enemy(), 1));
		return list;
	}

	public static Enemy kaguya() {
		PathList path = new PathList();
		path.add(Paths.basic(3, 45, 12, 30, 1), 0);

		path.add(Paths.basic(12, 30, 5, 30, 0.5f), 1);
		path.add(Paths.basic(5, 30, 5, 20, 0.2f), 0.5f);
		path.add(Paths.basic(5, 20, 20, 20, 1.5f), 0.2f);
		path.add(Paths.basic(20, 20, 20, 30, 0.5f), 1.5f);
		path.add(Paths.basic(20, 30, 12, 30, 0.2f), 0.5f);

		path.add(Paths.basic(12, 30, 5, 30, 0.5f), 0.2f);
		path.add(Paths.basic(5, 30, 5, 20, 0.2f), 0.5f);
		path.add(Paths.basic(5, 20, 20, 20, 1.5f), 0.2f);
		path.add(Paths.basic(20, 20, 20, 30, 0.5f), 1.5f);
		path.add(Paths.basic(20, 30, 12, 30, 0.2f), 0.5f);

		path.add(Paths.basic(20, 30, 20, 50, 0.5f), 0.2f);

		return new Enemy(3, 45, 1, 10, path, new LinkedList());

	}

}
