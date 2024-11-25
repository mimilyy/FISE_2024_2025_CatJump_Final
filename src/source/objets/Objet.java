package source.objets;

import java.awt.Image;

import javax.swing.ImageIcon;

import source.jeu.Main;

public class Objet {

	// Variables
	private int largeur, hauteur; //dimensions de l'objet
	private int x, y; //position de l'objet
	
	protected Image imgObjet;
	protected ImageIcon icoObjet;
	
	// Constructeur
	public Objet(int x, int y, int largeur, int hauteur){			
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	// Getters
    public int getX() {return x;}

	public int getY() {return y;}

	public int getLargeur() {return largeur;}

	public int getHauteur() {return hauteur;}
	
	public Image getImgObjet() {return imgObjet;}

	// Setters
	public void setX(int x) {this.x = x;}

	public void setY(int y) {this.y = y;}

	public void setLargeur(int largeur) {this.largeur = largeur;}

	public void setHauteur(int hauteur) {this.hauteur = hauteur;}

	// Méthodes
	public void deplacement(){
		
		if(Main.scene.getxPos() >= 0){
			this.x = this.x - Main.scene.getDx();
		}
	}
}
