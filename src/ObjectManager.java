import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

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

	// update the aliens
	public void update() {
		for (int i = 0; i < projectiles.size(); i++) {
		Projectile pj = projectiles.get(i);
			if (pj.y <= 0) {
				pj.isActive = false;
			}
		}
	}

	// draw
	public void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			alien.draw();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectile.draw();
		}
	}
	
	public void purgeObjects() {
		if (isActive = false) {
			
		}
	}

}
