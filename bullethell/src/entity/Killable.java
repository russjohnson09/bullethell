package entity;

/**
 * A killable object has health and a hitbox.
 */
public interface Killable {

	/**
	 * @return health
	 */
	float getHealth();

	/**
	 * 
	 * @return radius of hitbox
	 */
	float getRadius();

}
