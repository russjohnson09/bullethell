package level;

import entity.Updateable;

/**
 * Interface for the world that contains all of the entities of the game as well
 * as handles the games logic.
 * 
 * @author russ
 */
public interface World extends Updateable {

	void render();

}
