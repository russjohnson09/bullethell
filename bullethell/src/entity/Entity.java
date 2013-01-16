package entity;

/**
 * An Entity is the most basic element in the game.
 * 
 * @author russ
 */
public interface Entity extends Updateable {

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

}
