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

	LinkedListImp() {
		head = null;
		tail = null;
	}

	/**
	 * Updates the linked list.
	 */
	@Override
	public void update(float delta) {
		Entity entity = head.getEntity();
		entity.update(delta);

		// if the current entity is finished being executed
		// move to the next entity
		if (entity.isFin())
			move();

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
