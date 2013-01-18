package entity;

import path.Path;
import path.Path01;
import render.Renderer;
import utils.Textures;

import com.badlogic.gdx.graphics.Texture;

/**
 * Basic implementation of bullet goes down from (x,y)
 * 
 * @author russ
 * 
 */
public class Bullet implements Entity {

	public static final float X_BOUND = Renderer.CAMERA_WIDTH;
	public static final float Y_BOUND = Renderer.CAMERA_HEIGHT;
	public static final float X_MARGIN = X_BOUND * 1.1f;
	public static final float Y_MARGIN = Y_BOUND * 1.1f;

	// number of bullets grazed (used in score)
	protected static int numberGraze = 0;

	protected float ox;
	protected float oy;

	protected float x;
	protected float y;
	protected float r;
	protected Path path;
	protected float w;
	protected float h;
	protected Texture texture;

	protected boolean isGrazed = false;

	protected boolean isFin = false;

	public Bullet(float x, float y, float r, Path path, Texture texture) {
		this.x = ox = x;
		this.y = oy = y;
		this.r = r;
		this.path = path;
		this.texture = texture;

	}

	public Bullet() {
		x = ox = 5;
		y = oy = 40;
		r = 1;
		path = new Path01(0, 0, -10, 0);
		texture = Textures.BULLET01;

	}

	@Override
	public void update(float delta) {
		path.update(delta);

		x = ox + path.getX();
		y = oy + path.getY();

	}

	@Override
	public boolean isFin() {
		return isFin || (x > X_BOUND + X_MARGIN || y > Y_BOUND + Y_MARGIN)
				|| (x < -X_MARGIN || y < -Y_MARGIN);
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

	public float getOx() {
		return ox;
	}

	public void setOx(float ox) {
		this.ox = ox;
	}

	public float getOy() {
		return oy;
	}

	public void setOy(float oy) {
		this.oy = oy;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getR() {
		return r;
	}

	public void setR(float r) {
		this.r = r;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public float getW() {
		return w;
	}

	public void setW(float w) {
		this.w = w;
	}

	public float getH() {
		return h;
	}

	public void setH(float h) {
		this.h = h;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public boolean isGrazed() {
		return isGrazed;
	}

	public void setGrazed(boolean isGrazed) {
		this.isGrazed = isGrazed;
	}

	@Override
	public String toString() {
		return String.format("x: %.2f\ty: %.2f\tTexture: " + texture, x, y);
	}
}
