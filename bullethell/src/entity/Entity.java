package entity;

import path.Path;

/**
 * An Entity is the most basic element in the game.
 * 
 * @author russ
 */
public interface Entity extends Path {

	float getR();

	void setR(float r);

	boolean isFin();

	void setFin(boolean b);

}
