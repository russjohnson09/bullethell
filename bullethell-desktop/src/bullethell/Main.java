package bullethell;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class Main {
	public static void main(String[] args) {
		new LwjglApplication(new BulletHell(), "Bullet Hell", 240, 427, true);
	}
}