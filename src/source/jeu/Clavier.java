package source.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// La classe Clavier permet de gerer les touches du hero
public class Clavier implements KeyListener {

	// Methodes
	@Override
	public void keyPressed(KeyEvent e) {
		if (Main.scene.cat.isVivant() == true) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // fleche droite
				if (Main.scene.getxPos() == -1) {
					Main.scene.setxPos(0); // Reinitialisation de setxPos
					Main.scene.setxFond1(-50); // Reinitialisation de xFond1
					Main.scene.setxFond2(750); // Reinitialisation de xFond2
				}
				Main.scene.cat.setMarche(true);
				Main.scene.cat.setVersDroite(true);
				Main.scene.setDx(1); // Deplacement du fond vers la gauche lors de l'appui sur la touche "fleche droite"
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // fleche gauche
				if (Main.scene.getxPos() == 4431) {
					Main.scene.setxPos(4430);
					Main.scene.setxFond1(-50);
					Main.scene.setxFond2(750);
				}
				Main.scene.cat.setMarche(true);
				Main.scene.cat.setVersDroite(false);
				Main.scene.setDx(-1); // Deplacement du fond vers la droite lors de l'appui sur la touche "fleche gauche"
			}
			// cat saute
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {Main.scene.cat.setSaut(true);}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Main.scene.cat.setMarche(false);
		Main.scene.setDx(0);// Remise a 0 de la variable dx de l'objet scene lors du relachement des touches
	} 

	@Override
	public void keyTyped(KeyEvent e) {}
}