package source.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Piece extends Objet implements Runnable{
	
	// Variables
	private int compteur;
	private final int PAUSE = 15; //temps d'attente entre 2 tours de boucle

	// Constructeur
    public Piece(int x, int y){
	    super(x, y, 30, 30);
	    
	    super.icoObjet = new ImageIcon(getClass().getResource("/images/piece1.png"));
	    super.imgObjet = super.icoObjet.getImage();
    }

    // Methodes
    public Image bouge(){ // Mouvement de la piece
    	String str;
    	ImageIcon ico;
		Image img;
			
        this.compteur++;
		if (this.compteur / 100 == 0) {str = "/images/piece1.png";}
		else{str = "/images/piece2.png";}							    
		if (this.compteur == 200) {this.compteur = 0;}
		
		// Affichage de l'image du personnage
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;   	
	}

	@Override
	public void run() {
		try{Thread.sleep(20);} // on attend 20 ms avant d'appeler bouge pour que tous les objets soient completement crees
		catch (InterruptedException e){}		
			
		while(true){ // boucle infinie											
			this.bouge();
			try{Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
		}			
	}
}
