package path;

import utils.LinkedList;
import utils.Node;

public class PathList implements Path {

	private LinkedList pathList = new LinkedList();
	private float ox = 0;
	private float oy = 0;
	private float x;
	private float y;
	Path path = new Path01(0, 0, 0, 0);

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public void setX(float x) {
		this.x = x;

	}

	@Override
	public void setY(float y) {
		this.y = y;

	}

	@Override
	public void update(float delta) {
		Path p = pathList.update(delta);
		if (path != null) {
			ox = path.getX();
			oy = path.getY();
			path = p;
		}
		x = ox + path.getX();
		y = oy + path.getY();

	}

	public void add(Path path, float delay) {
		pathList.add(new Node(path, delay));
	}

}
