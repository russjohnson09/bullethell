package path;

import com.badlogic.gdx.math.Vector2;

import utils.LinkedList;
import utils.Node;

/*
 * The PathList is used for more complex paths such as ones used by bosses.
 */
public class PathList {

	// linked list of paths in path list
	public LinkedList<Path> pathlist = new LinkedList<Path>();

	// original pos and current position
	public Vector2 oPos = new Vector2(0, 0);
	public Vector2 pos = new Vector2(0, 0);

	// current path being updated
	Path path;

	public PathList(Vector2 v) {
		pathlist.add(new Node<Path>(new Path(v), 0));
	}

	public PathList(Path path) {
		pathlist.add(new Node<Path>(path, 0));
	}

	public PathList() {
	}

	public void update(float delta) {
		Path p = pathlist.update(delta);
		if (p != null) {
			oPos.x = pos.x;
			oPos.y = pos.y;
			path = p;
		}
		path.update(delta);

		pos.x = oPos.x + path.pos.x;
		pos.y = oPos.y + path.pos.y;

	}

	public void add(Node<Path> node) {
		pathlist.add(node);
	}

}
