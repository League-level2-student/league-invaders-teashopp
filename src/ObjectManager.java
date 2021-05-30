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
	int score = 0;

	int getscore() {
		return score;
	}
	
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
		rocket.update();
		checkCollision();
		purgeObjects();
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
			if (!alien.isActive) {
				aliens.remove(i);
			}
		}
		for (int i = projectiles.size() - 1; i >= 0; i--) {
			Projectile pj = projectiles.get(i);
			if (!pj.isActive) {
				projectiles.remove(i);
			}
		}
	}

	// check collision
	void checkCollision() {
		for (int i = aliens.size() - 1; i >= 0; i--) {
			Alien ai = aliens.get(i);
			if (rocket.collisionBox.intersects(ai.collisionBox)) {
				rocket.isActive = false;
			}
			for (int j = projectiles.size() - 1; j >= 0; j--) {
				Projectile pj = projectiles.get(j);				
				if (ai.collisionBox.intersects(pj.collisionBox)) {
					pj.isActive = false;
					ai.isActive = false;
					score += 1;
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		addAlien();
	}

}
