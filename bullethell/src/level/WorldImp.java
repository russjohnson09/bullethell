package level;

import utils.LinkedList;

public class WorldImp implements World {

	private Level level = new Level01();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(float delta) {
		level.update(delta);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LinkedList getEntities() {
		// TODO Auto-generated method stub
		return null;
	}

}
