package utils;

import entity.Entity;

/**
 * Implementation of Node.
 * 
 * @author russ
 * 
 */
public class NodeImp implements Node {

	Entity entity;
	Node next;

	@Override
	public Entity getEntity() {
		return entity;
	}

	@Override
	public Node getNext() {
		return next;
	}

	@Override
	public void setNext(Node node) {
		next = node;

	}

}
