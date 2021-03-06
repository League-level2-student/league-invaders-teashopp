import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	// variables
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont0;
	Font titleFont1;
	Timer frameDraw;
	Timer alienSpawn;
	Rocketship rs = new Rocketship(250, 700, 50, 50);
	ObjectManager om = new ObjectManager(rs);
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	// game panel stuff
	GamePanel() {
		// set fonts
		titleFont0 = new Font("Arial", Font.PLAIN, 45);
		titleFont1 = new Font("Arial", Font.PLAIN, 30);
		// set timers
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
		// set space
		if (needImage) {
			loadImage("space.png");
		}
	}

	// check current state and draw
	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	// update menu state
	void updateMenuState() {

	}

	// update game state
	void updateGameState() {
		om.update();
		if (!rs.isActive) {
			currentState = END;
		}
	}

	// update end state
	void updateEndState() {

	}

	// establish window at menu
	void drawMenuState(Graphics g) {
		// blue at menu
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		// set text at menu
		g.setFont(titleFont0);
		g.setColor(Color.WHITE);
		g.drawString("LEAGUE INVADERS", 30, 150);
		g.setFont(titleFont1);
		g.drawString("Press ENTER to start", 90, 325);
		g.drawString("Press SPACE for instructions", 40, 500);
	}

	// establish window during game
	void drawGameState(Graphics g) {
		// black during game
		// g.setColor(Color.BLACK);
		// g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		om.draw(g);
		g.setFont(titleFont0);
		g.setColor(Color.WHITE);
		g.drawString("Score: " + om.getscore(), 10, 40);
	}

	// establish window at end
	void drawEndState(Graphics g) {
		// red at end
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont1);
		g.setColor(Color.BLACK);
		g.drawString("You finished the game with: " + om.getscore() + " points!", 10, 400);
	}

	// action when timer is triggered
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		// System.out.println("Action");
		repaint();
	}

	// stuff that happens when key is pressed
	@Override
	public void keyPressed(KeyEvent e) {

		// check which key is pressed when in end state
		if (currentState == END) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				rs = new Rocketship(250, 700, 50, 50);
				om = new ObjectManager(rs);
			}
		}

		// change to next game state when key is pressed
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == MENU) {
				currentState = GAME;
				startGame();
			} else if (currentState == END) {
				currentState = MENU;
				alienSpawn.stop();
			} else {
				currentState++;
			}
		}

		// check which key is pressed when in menu state
		if (currentState == MENU) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				System.out.println(
						"Use your arrow keys to move and your space bar to shoot the aliens! Each alien you hit adds a point! Don't let your rocket touch the aliens!");
			}
		}

		// check which key is pressed when in game state
		if (currentState == GAME) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				System.out.println("UP");
				if (rs.y >= 0) {
					rs.up();
				}
			}

			else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				System.out.println("DOWN");
				if (rs.y <= 700) {
					rs.down();
				}
			}

			else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				System.out.println("LEFT");
				if (rs.x >= 0) {
					rs.left();
				}
			}

			else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				System.out.println("RIGHT");
				if (rs.x <= 430) {
					rs.right();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				om.addProjectile(rs.getProjectile());
			}
		}

	}

	// load space
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

	public void startGame() {
		alienSpawn = new Timer(1000, om);
		alienSpawn.start();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
