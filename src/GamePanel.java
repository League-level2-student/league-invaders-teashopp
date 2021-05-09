import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	Rocketship rs = new Rocketship(250, 700, 50, 50);

	// game panel stuff
	GamePanel() {
		// set fonts
		titleFont0 = new Font("Arial", Font.PLAIN, 45);
		titleFont1 = new Font("Arial", Font.PLAIN, 30);
		// set timers
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		rs.draw(g);
	}

	// establish window at end
	void drawEndState(Graphics g) {
		// red at end
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
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
		// change to next game state when key is pressed
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
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
		}
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
