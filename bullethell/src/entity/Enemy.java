package entity;


/**
 * An enemy is an entity that in addition to an x and y position also has
 * health, a hitbox, and a graphic.
 * 
 * @author russ
 */
public interface Enemy extends Entity, Viewable, Killable {
}
