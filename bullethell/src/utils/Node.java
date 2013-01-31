package utils;

import path.Path;

/**
 * Implementation of Node.
 * 
 * @author russ
 * 
 */
public class Node<D> {

	public D data;
	public Node<D> next;
	public float delay;

	public Node(D data, float delay) {
		this.data = data;
		this.delay = delay;
	}

	public void update(float delta) {
		delay -= delta;

	}

}
