import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Projectile extends GameObject {

	// idk pt 3
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	// projectile stuff
	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		if (needImage) {
		    loadImage ("bullet.png");
		}
	}

	// move the projectile down
	public void update() {
		y -= speed;
        super.update();
	}

	// create the projectile
	public void draw(Graphics g) {
		// g.setColor(Color.YELLOW);
		// g.fillRect(x, y, width, height);
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}

	// load bullet
	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}

}
