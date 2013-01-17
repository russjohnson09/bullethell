package entity;

import states.PosNegZero;

import com.badlogic.gdx.utils.Array;

public interface Player extends Entity, Viewable, Killable, Invincible {

	PosNegZero getStateX();

	PosNegZero getStateY();

	void setStateX(PosNegZero state);

	void setStateY(PosNegZero state);

	boolean isFiring();

	void setIsFiring(boolean b);

	int getLives();

	void decLives();

	void incLives();

	Array<Bullet> getBullets();

	void setIsSlow(boolean b);

}
