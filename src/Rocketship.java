import java.awt.Color;

public class Rocketship extends GameObject {

	// rocketship stuff kekw
	Rocketship() {
		super(x, y, width, height);
	}

	// draw
	void draw() {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
}
