package level;

import java.util.ArrayList;

import utils.LinkedList;
import entity.Entity;

/**
 * Basic implementation of Level.
 * 
 * @author russ
 * 
 */
public class LevelImp implements Level {

	private ArrayList<LinkedList> actions;

	@Override
	public ArrayList<LinkedList> getActions() {
		return actions;
	}

	@Override
	public void update(float delta) {
		for (LinkedList l : actions) {
			l.update(delta);
			Entity e = l.getCurrent().getEntity();
			e.update(delta);
		}

	}

}
