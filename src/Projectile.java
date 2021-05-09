import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {

	// projectile stuff
	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
	}

	// move the projectile down
	public void update() {
		y -= speed;
	}
	
	// create the projectile
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
	}
	
}
