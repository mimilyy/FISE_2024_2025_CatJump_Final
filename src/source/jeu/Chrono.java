package source.jeu;

public class Chrono implements Runnable{

	// Variable
	private final int PAUSE = 3; // temps d'attente entre 2 tours de boucle : 3 millisecondes

	// Méthode
	@Override
	public void run() {

		while(true){ 			
			Main.scene.repaint(); // Appel de la méthode PaintComponent de l'objet scene
			try {Thread.sleep(PAUSE);} // temps de pause (3 ms)
			catch (InterruptedException e) {}
		}
	}
}