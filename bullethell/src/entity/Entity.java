package entity;

import path.Path;

import com.badlogic.gdx.graphics.Texture;

/**
 * An Entity is the most basic element in the game.
 * 
 * @author russ
 */
public interface Entity extends Path {

	float getR();

	void setR(float r);

	float getH();

	void setH(float h);

	float getW();

	void setW(float w);

	Texture getTexture();

	void setTexture(Texture texture);

	boolean isFin();

	void setFin(boolean b);

}
