import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject {

	// idk
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	// rocketship stuff kekw
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		if (needImage) {
			loadImage("rocket.png");
		}
	}

	// draw
	void draw(Graphics g) {
		// g.setColor(Color.BLUE);
		// g.fillRect(x, y, width, height);
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}

	// change speed for up
	public void up() {
		y -= speed;
	}

	// change speed for down
	public void down() {
		y += speed;
	}

	// change speed for left
	public void left() {
		x -= speed;
	}

	// change speed for right
	public void right() {
		x += speed;
	}

	// load rocket
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

	// shoot projectile
	public Projectile getProjectile() {
		return new Projectile(x + width / 2, y, 10, 10);
	}
}
