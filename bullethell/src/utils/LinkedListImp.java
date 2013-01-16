package utils;

import entity.Entity;

/**
 * Implementation of LinkedList
 * 
 * @author russ
 * 
 */
public class LinkedListImp implements LinkedList {

	Node head;
	Node tail;

	public LinkedListImp() {
		head = null;
		tail = null;
	}

	/**
	 * Updates the linked list returning an entity if it is time to spawn it and
	 * null if we are doing nothing.
	 */
	@Override
	public Entity update(float delta) {
		head.update(delta);

		if (head.getDelay() < 0) {
			Entity entity = head.getEntity();
			move();
			return entity;
		}

		return null;

	}

	private void move() {
		if (head != null)
			head = head.getNext();

	}

	@Override
	public Node getCurrent() {
		return head;
	}

	@Override
	public void add(Node node) {
		if (head == null)
			head = tail = node;
		else {
			tail.setNext(node);
			tail = node;
		}

	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

}
