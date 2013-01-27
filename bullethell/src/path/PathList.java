package path;

import utils.LinkedList;
import utils.Node;

public class PathList implements Path {

	private LinkedList pathList = new LinkedList();
	protected Pos oPos = new Pos(0, 0);
	protected Pos pos = new Pos(0, 0);
	Path path = new Path01(0, 0);

	@Override
	public void update(float delta) {
		Path p = pathList.update(delta);
		if (p != null) {
			oPos.x = pos.x;
			oPos.y = pos.y;
			path = p;
		}
		path.update(delta);
		pos.x = oPos.x + path.getPos().x;
		pos.y = oPos.y + path.getPos().y;

	}

	public void add(Path path, float delay) {
		pathList.add(new Node(path, delay));
	}

	@Override
	public Pos getPos() {
		return pos;
	}

}
