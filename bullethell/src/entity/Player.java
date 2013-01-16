package entity;

import states.PosNegZero;

public interface Player extends Entity, Viewable, Killable, Invincible {

	PosNegZero getStateX();

	PosNegZero getStateY();

	void setStateX(PosNegZero state);

	void setStateY(PosNegZero state);

	int getLives();

	void decrementHealth();

}
