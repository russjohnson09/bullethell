package level;

import com.badlogic.gdx.utils.Array;

import entity.Enemy;
import entity.Updateable;

public interface Level extends Updateable {

	/**
	 * 
	 * @return the enemies
	 */
	Array<Enemy> getEnemies();

	/**
	 * 
	 * @return
	 */
	boolean getIsFin();

}
