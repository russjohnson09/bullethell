package utils;

import path.Path;

/**
 * Implementation of Node.
 * 
 * @author russ
 * 
 */
public class Node {

	private Path path;
	private Node next;
	private float delay;

	public Node(Path path, float delay) {
		this.path = path;
		this.delay = delay;
	}

	public Path getPath() {
		return path;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node node) {
		next = node;

	}

	public void update(float delta) {
		delay -= delta;

	}

	public float getDelay() {
		return delay;
	}

}
