import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	// rocketship stuff kekw
	Rocketship(int x,int y,int width,int height) {
		super(x, y, width, height);
		speed = 10;
	}

	// draw
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	
	// change speed for up
	 public void up() {
	        y-=speed;
	    }
	 
	 // change speed for down
	 public void down() {
	        y+=speed;
	    }
	 
	 // change speed for left
	 public void left() {
	        x-=speed;
	    }
	 
	 // change speed for right
	 public void right() {
	        x+=speed;
	    }

}
