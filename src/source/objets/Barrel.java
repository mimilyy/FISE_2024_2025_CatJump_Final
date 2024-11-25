package source.objets;

import javax.swing.ImageIcon;

public class Barrel extends Objet{
	
	// Constructeur
	public Barrel(int x, int y) {

		super(x, y, 43, 65);		
		super.icoObjet = new ImageIcon(getClass().getResource("/images/barrel.png"));
		super.imgObjet = this.icoObjet.getImage();
	}
}
