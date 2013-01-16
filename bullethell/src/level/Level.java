package level;

import java.util.ArrayList;

import utils.LinkedList;
import entity.Updateable;

public interface Level extends Updateable {

	/**
	 * 
	 * @return all of the linked lists representing actions.
	 */
	ArrayList<LinkedList> getActions();
}
