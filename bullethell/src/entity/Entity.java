package entity;

import com.badlogic.gdx.utils.Array;

/**
 * An Entity is the most basic element in the game.
 * 
 * @author russ
 */
public interface Entity extends Updateable, Viewable {

	/**
	 * Returns true when an entity has finished doing what it was set out to do
	 * and can be removed.
	 * 
	 * @return status of entity
	 */
	boolean isFin();

	/**
	 * 
	 * @return x position on xy plane
	 */
	float getX();

	/**
	 * 
	 * @return y position on xy plane
	 */
	float getY();

	/**
	 * 
	 * @return radius of object
	 */
	float getR();

	/**
	 * 
	 * @return array of entities that are in action
	 */
	Array<Entity> getList();

	/**
	 * Adds to the array of entities in action.
	 */
	void add(Entity entity);

}
