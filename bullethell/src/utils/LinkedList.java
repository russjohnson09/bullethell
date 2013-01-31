package utils;

/**
 * Implementation of LinkedList
 * 
 * @author russ
 * 
 */
public class LinkedList<D> {

	public Node<D> head;
	public Node<D> tail;

	public LinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * Updates the linked list returning an entity if it is time to spawn it and
	 * null if we are doing nothing.
	 */
	public D update(float delta) {
		if (head != null) {
			head.update(delta);
			if (head.delay < 0) {

				D data = head.data;
				head = head.next;
				return data;
			}
		}

		return null;

	}

	public void add(Node<D> node) {
		if (head == null)
			head = tail = node;
		else {
			tail.next = node;
			tail = node;
		}

	}

	public void add(LinkedList<D> list) {
		if (list != null && list.tail != null)
			if (head == null) {
				head = list.head;
				tail = list.tail;
			} else {
				tail.next = list.head;
				tail = list.tail;
			}

	}

}
