package entity;


/**
 * An enemy is an entity that in addition to an x and y position also has
 * health, a hitbox, and a graphic.
 * 
 * @author russ
 */
public interface Enemy extends Entity, Viewable, Killable {

	float DELAY = 1;
	float BOUNDARY_X = 24;
	float BOUNDARY_Y = 42.7f;
	// Enemies can exist slightly off screen
	float MARGIN = 7f;

	int getKills();
}
