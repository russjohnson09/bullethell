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
		if (head != null) {
			head.update(delta);
			if (head.getDelay() < 0) {

				Entity entity = head.getEntity();
				head = head.getNext();

				return entity;
			}
		}

		return null;

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
