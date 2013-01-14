package bullethell;

import org.junit.Test;

import bullethell.bullets.Bullet01;
import bullethell.screens.GameScreen;

public class UnitTest {
	private GameScreen stage1;

	@Test
	public void test() {
		stage1 = new GameScreen();
	}

	@Test
	public void collision() {

	}

	@Test
	public void bulletCollision() {
		Bullet01 bullet = new Bullet01();
		// System.out.println(bullet);
	}

}
