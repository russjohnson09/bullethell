package utils;


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
		head.update(delta);

		if (head.getDelay() < 0)
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
