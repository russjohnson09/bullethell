package path;

import com.badlogic.gdx.math.Vector2;

import utils.LinkedList;
import utils.Node;

/*
 * The PathList is used for more complex paths such as ones used by bosses.
 */
public class PathList {

	// linked list of paths in path list
	public LinkedList<Path> pathList = new LinkedList<Path>();

	// original pos and current position
	public Vector2 oPos, pos;

	// current path being updated
	Path path = new Path(new Vector2(0, 0));

	public PathList(Vector2 v) {
		oPos = new Vector2(0, 0);
		pos = oPos.cpy();
		pathList.add(new Node<Path>(new Path(v), 0));
	}

	public void update(float delta) {
		Path p = pathList.update(delta);
		if (p != null) {
			oPos.x = pos.x;
			oPos.y = pos.y;
			path = p;
		}
		path.update(delta);

		pos.x = oPos.x + path.pos.x;
		pos.y = oPos.y + path.pos.y;

	}

}
