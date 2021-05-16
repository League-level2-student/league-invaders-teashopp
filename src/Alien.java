import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Alien extends GameObject {

	// idk pt 2
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	// alien stuff
	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 1;
		if (needImage) {
			loadImage("alien.jpg");
		}
	}

	// move the alien down
	public void update() {
		y += speed;
	}

	// create the alien
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

	// load alien
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
