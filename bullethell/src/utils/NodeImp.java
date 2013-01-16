package utils;

import entity.Entity;

/**
 * Implementation of Node.
 * 
 * @author russ
 * 
 */
public class NodeImp implements Node {

	private Entity entity;
	private Node next;
	private float delay;

	public NodeImp(Entity entity, float delay) {
		this.entity = entity;
		this.delay = delay;
	}

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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(float delta) {
		delay -= delta;

	}

	@Override
	public float getDelay() {
		return delay;
	}

}
