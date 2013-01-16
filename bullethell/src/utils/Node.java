package utils;

import entity.Entity;

/**
 * A Node containing entities.
 * 
 * @author russ
 * 
 */
public interface Node {

	/**
	 * 
	 * @return entity in node.
	 */
	Entity getEntity();

	/**
	 * @return Node pointed to.
	 */
	Node getNext();

	/**
	 * Set node being pointed to.
	 */
	void setNext(Node node);

}
