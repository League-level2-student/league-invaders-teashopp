import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {

	// variables
	Rocketship rocket;
	ArrayList<Projectile> projectiles;
	ArrayList<Alien> aliens;
	Random rand = new Random();

	// initializing variables
	ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
		projectiles = new ArrayList<Projectile>();
		aliens = new ArrayList<Alien>();
	}

	// add aliens
	public void addAlien() {
		aliens.add(new Alien(rand.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	// add projectiles
	public void addProjectile(Projectile pj) {
		projectiles.add(pj);
	}

	// update the aliens
	public void update() {
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile pj = projectiles.get(i);
			pj.update();
			if (pj.y <= 0) {
				pj.isActive = false;
			}
		}
		for (int i = 0; i < aliens.size(); i++) {
			Alien as = aliens.get(i);
			as.update();
			if (as.y >= LeagueInvaders.HEIGHT) {
				as.isActive = false;
			}
		}
	}

	// draw
	public void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			Alien alien = aliens.get(i);
			alien.draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile pj = projectiles.get(i);
			pj.draw(g);
		}
	}

	public void purgeObjects() {
		for (int i = aliens.size() - 1; i >= 0; i--) {
			Alien alien = aliens.get(i);
			if (alien.isActive = false) {
				aliens.remove(i);
			}
		}
		for (int i = projectiles.size(); i >= 0; i--) {
			Projectile pj = projectiles.get(i);
			if (pj.isActive = false) {
				projectiles.remove(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		addAlien();
	}

}
