package barrage;

import path.Path01;

public class Paths {

	public static Path01 basic(float x1, float y1, float x2, float y2,
			float time) {
		return new Path01((x2 - x1) / time, (y2 - y1) / time);
	}

	public static Path01 basic2(float x1, float y1, float x2, float y2) {
		return new Path01((x2 - x1), (y2 - y1));
	}

}
