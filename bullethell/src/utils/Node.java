package utils;

import entity.Entity;
import entity.Updateable;

/**
 * An updateable Node.
 * 
 * @author russ
 * 
 */
public interface Node extends Updateable {

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

	/**
	 * 
	 * @return the delay
	 */
	float getDelay();

}
