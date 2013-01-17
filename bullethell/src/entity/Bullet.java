package entity;

public interface Bullet extends Entity {

	float BOUNDARY_X = 24;
	float BOUNDARY_Y = 42.7f;
	// bullets can exist slightly off screen
	float MARGIN = 7f;

	void setIsFin(boolean b);

	void incGraze();

	int getGraze();

	// can only change from false to true
	void setIsGrazed();

	boolean getIsGrazed();

	boolean getIsAbsolute();

	void setIsAbsolute(boolean b);

}
