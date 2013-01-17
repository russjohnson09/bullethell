package parametric;

/**
 * Parametric equation of the form <x,y> = <a1*t^2 + b1*t + c1, a2*t^2 + b2*t +
 * c2>
 * 
 * @author russ
 * 
 */
public class Para01 implements Parametric {

	protected float a1;
	protected float a2;
	protected float b1;
	protected float b2;
	protected float c1;
	protected float c2;
	protected float x = 0;
	protected float y = 0;
	protected float t = 0;
	protected float speed;

	/**
	 * Parametric equation of the form <x,y> = <b1*t, b2*t>
	 * 
	 * @param b1
	 * @param b2
	 */
	public Para01(float b1, float b2) {
		a1 = 0;
		a2 = 0;
		this.b1 = b1;
		this.b2 = b2;
		c1 = 0;
		c2 = 0;
		speed = 1;
	}

	/**
	 * Parametric equation of the form <x,y> = <a1*t^2 + b1*t, a2*t^2 + b2*t>
	 * 
	 * @param a1
	 * @param b1
	 * @param a2
	 * @param b2
	 */
	public Para01(float a1, float b1, float a2, float b2) {
		this.a1 = a1;
		this.b1 = b1;
		this.a2 = a2;
		this.b2 = b2;
		c1 = 0;
		c2 = 0;
		speed = 1;
	}

	/**
	 * Parametric equation of the form <x,y> = <a1*t^2 + b1*t + c1, a2*t^2 +
	 * b2*t + c2>
	 * 
	 * @param a1
	 * @param b1
	 * @param c1
	 * @param a2
	 * @param b2
	 * @param c2
	 */
	public Para01(float a1, float b1, float c1, float a2, float b2, float c2) {
		this.a1 = a1;
		this.b1 = b1;
		this.c1 = c1;
		this.a2 = a2;
		this.b2 = b2;
		this.c2 = c2;
		speed = 1;
	}

	@Override
	public void update(float delta) {
		t += delta;
		updateX();
		updateY();

	}

	private void updateX() {
		x = speed * (float) (a1 * Math.pow(t, 2) + b1 * t + c1);

	}

	private void updateY() {
		y = speed * (float) (a2 * Math.pow(t, 2) + b2 * t + c1);

	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public void setX(float x) {
		this.x = x;

	}

	@Override
	public void setY(float y) {
		this.y = y;

	}

	@Override
	public void setSpeed(float speed) {
		this.speed = speed;

	}

}
