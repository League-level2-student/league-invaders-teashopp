import javax.swing.JFrame;

public class LeagueInvaders {
	
	//initial variables
	JFrame primaryframe;
	static final int WIDTH = 500;
	static final int HEIGHT = 800;
	
	
	// main method
	public static void main(String[] args) {
		LeagueInvaders LI = new LeagueInvaders();
		LI.initialize();
		LI.setup();
	}

	
	// initialize primaryframe
	public void initialize() {
		primaryframe = new JFrame("League Invaders");
	}
	
	
	// set up primaryframe
	public void setup() {
		primaryframe.setSize(WIDTH,HEIGHT);
		primaryframe.setVisible(true);
		primaryframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
