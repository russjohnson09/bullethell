package path;

/**
 * Interface used for updating the location of an object.
 * 
 * @author russ
 * 
 */
public interface Path {

	float getX();

	float getY();

	void setX(float x);

	void setY(float y);

	void update(float delta);

}
