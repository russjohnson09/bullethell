package path;

/**
 * Interface used for updating the location of an object.
 * 
 * @author russ
 * 
 */
public interface Path {

	Pos getPos();

	void update(float delta);

}
