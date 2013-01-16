package utils;

import entity.Updateable;

/**
 * Interface for an lightweight linked list.
 * 
 * @author russjohnson09@gmail.com
 */
public interface LinkedList extends Updateable {

	/**
	 * Gets the current node
	 */
	Node getCurrent();

	/**
	 * Adds Entity to end of list.
	 * 
	 * @param node
	 *            to be added
	 */
	void add(Node node);

	/**
	 * 
	 * @return is the list empty
	 */
	boolean isEmpty();

}
