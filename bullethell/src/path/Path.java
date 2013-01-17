package path;

/**
 * Interface used for updating the location of a person.
 * 
 * @author russ
 * 
 */
public interface Path {

	void update(float delta);

	float getX();

	float getY();

	void setX(float x);

	void setY(float y);

}
