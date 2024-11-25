package source.jeu;

import javax.swing.JFrame;

public class Main {
	
	// Variable
	public static Scene scene;

	// Methode
	public static void main(String[] args) {
		
		// Creation de la fenetre de l'application
		JFrame fenetre = new JFrame("Que du jump");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(700, 360);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		
		// Instanciation de l'objet scene
		scene = new Scene();
				
		fenetre.setContentPane(scene); // On associe la scene a la fenetre de l'application
		fenetre.setVisible(true);		
	}
}