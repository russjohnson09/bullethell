package entity;

public interface Updateable {

	/**
	 * Updates based on change in time.
	 * 
	 * @param delta
	 *            is the change in time
	 */
	void update(float delta);
}
