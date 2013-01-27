package entity;

import path.Path;
import path.Path01;
import path.Pos;
import render.Renderer;

/**
 * Basic implementation of bullet goes down from (x,y)
 * 
 * @author russ
 * 
 */
public class Bullet implements Entity {

	public static final float X_BOUND = Renderer.CAMERA_WIDTH;
	public static final float Y_BOUND = Renderer.CAMERA_HEIGHT;
	public static final float X_MARGIN = X_BOUND * .1f;
	public static final float Y_MARGIN = Y_BOUND * .1f;

	// number of bullets grazed (used in score)
	protected static int numberGraze = 0;

	protected Pos oPos;

	protected Pos pos;
	protected float r;
	protected Path path;

	protected boolean isGrazed = false;

	protected boolean isFin = false;

	public Bullet(float x, float y, float r, Path path) {
		pos = oPos = new Pos(x, y);
		this.r = r;
		this.path = path;

	}

	public Bullet() {
		pos = oPos = new Pos(5, 40);
		r = 1;
		path = new Path01(0, -10);

	}

	@Override
	public void update(float delta) {
		path.update(delta);

		pos.x = oPos.y + path.getPos().x;
		pos.y = oPos.y + path.getPos().y;

	}

	@Override
	public boolean isFin() {
		return isFin
				|| (pos.x > X_BOUND + X_MARGIN || pos.y > Y_BOUND + Y_MARGIN)
				|| (pos.x < -X_MARGIN || pos.y < -Y_MARGIN);
	}

	@Override
	public void setFin(boolean b) {
		isFin = b;
	}

	public static int getNumberGraze() {
		return numberGraze;
	}

	public static void setNumberGraze(int numberGraze) {
		Bullet.numberGraze = numberGraze;
	}

	@Override
	public float getR() {
		return r;
	}

	@Override
	public void setR(float r) {
		this.r = r;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public boolean isGrazed() {
		return isGrazed;
	}

	public void setGrazed(boolean isGrazed) {
		this.isGrazed = isGrazed;
	}

	@Override
	public String toString() {
		return String.format("x: %.2f\ty: %.2f\t", pos.x, pos.y);
	}

	@Override
	public Pos getPos() {
		return pos;
	}
}
