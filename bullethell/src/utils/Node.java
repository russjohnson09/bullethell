package utils;

import entity.Entity;

/**
 * Implementation of Node.
 * 
 * @author russ
 * 
 */
public class Node {

	private Entity entity;
	private Node next;
	private float delay;

	public Node(Entity entity, float delay) {
		this.entity = entity;
		this.delay = delay;
	}

	public Entity getEntity() {
		return entity;
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
