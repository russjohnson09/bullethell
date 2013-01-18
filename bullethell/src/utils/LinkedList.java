package utils;

import entity.Entity;

/**
 * Implementation of LinkedList
 * 
 * @author russ
 * 
 */
public class LinkedList {

	Node head;
	Node tail;

	public LinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * Updates the linked list returning an entity if it is time to spawn it and
	 * null if we are doing nothing.
	 */
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

	public Node getCurrent() {
		return head;
	}

	public void add(Node node) {
		if (head == null)
			head = tail = node;
		else {
			tail.setNext(node);
			tail = node;
		}

	}

	public boolean isEmpty() {
		return head == null;
	}

}
