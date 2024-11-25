package source.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import source.jeu.Main;
import source.objets.Objet;
import source.objets.Piece;

public class Cat extends Personnage{

	// Variables
	private Image imgCat;
	private ImageIcon icoCat;
    private boolean saut; // vrai si cat saute
    private int compteurSaut; // duree du saut et hauteur du saut
    private int compteurMort;
	
	// Constructeur
	public Cat(int x, int y) {

	super(x, y, 28, 50);		
	this.icoCat = new ImageIcon(getClass().getResource("/images/catMarcheDroite.png"));
	this.imgCat = this.icoCat.getImage();
	
	this.saut = false;
	this.compteurSaut = 0;
	this.compteurMort = 0;
	}

	// Getters
	public Image getImgCat() {return imgCat;}

	public boolean isSaut() {return saut;}

	// Setter
	public void setSaut(boolean saut) {this.saut = saut;}

	// Methodes
	@Override
	public Image marche(String nom, int frequence) {
    	String str;
    	ImageIcon ico;
		Image img;			
		if (this.marche == false || Main.scene.getxPos() <= 0 || Main.scene.getxPos() > 4430) {
			if(this.versDroite == true){str = "src/images/" + nom + "ArretDroite.png";}
			else{str = "src/images/" + nom + "ArretGauche.png";}				
		}else{
		    this.compteur++;
		    if (this.compteur / frequence == 0) { // quotient de la division euclidienne de compteur par frequence
		    	if(this.versDroite == true){str = "src/images/" + nom + "ArretDroite.png";}
		    	else{str = "src/images/" + nom + "ArretGauche.png";}					
		    }else{
		    	if(this.versDroite == true){str = "src/images/" + nom + "MarcheDroite.png";}
		    	else{str = "src/images/" + nom + "MarcheGauche.png";}	
		    }		    
		    if (this.compteur == 2 * frequence) {this.compteur = 0;}
		}
		// Affichage de l'image du personnage
		ico = new ImageIcon(str);
		img = ico.getImage();
		return img;
	}
	
    public Image saute(){		
	    ImageIcon ico;
	    Image img;
	    String str;
	
		this.compteurSaut++;
		// Montee du saut
		if(this.compteurSaut <= 40){
			if(this.getY() > Main.scene.getHautPlafond()){this.setY(this.getY() - 4);}
			else{this.compteurSaut = 41;}			
			if(this.isVersDroite() == true){str = "/images/catSautDroite.png";}
			else{str = "/images/catSautGauche.png";}
			
		// Retombee du saut
		}else if(this.getY() + this.getHauteur() < Main.scene.getySol()){this.setY(this.getY() + 1);
			if(this.isVersDroite() == true){str = "/images/catSautDroite.png";}
			else{str = "/images/catSautGauche.png";}
			
		// Saut termine
		}else{				
			if(this.isVersDroite() == true){str = "/images/catArretDroite.png";}
			else{str = "/images/catArretGauche.png";}
			this.saut = false;
			this.compteurSaut = 0;
		}
		// Affichage de l'image de cat
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
    
	public void contact(Objet objet) {
		// contact horizontal
		if((super.contactAvant(objet) == true && this.isVersDroite() == true) || (super.contactArriere(objet) == true && this.isVersDroite() == false)){
			Main.scene.setDx(0);
		    this.setMarche(false);
		}
		// contact avec un objet en dessous
        if(super.contactDessous(objet) == true && this.saut == true){ // cat saute sur un objet
			Main.scene.setySol(objet.getY());			
		}else if(super.contactDessous(objet) == false){ // cat tombe sur le sol initial
			Main.scene.setySol(293); // altitude du sol initial
			if(this.saut == false){this.setY(243);} // altitude initiale de cat
		}
        // contact avec un objet au-dessus
        if(super.contactDessus(objet) == true){
			Main.scene.setHautPlafond(objet.getY() + objet.getHauteur()); // le plafond devient le dessous de l'objet
		}else if(super.contactDessus(objet) == false && this.saut == false){
			Main.scene.setHautPlafond(0);// altitude du plafond initial (ciel)
		}     
	}
	
	public boolean contactPiece(Piece piece){
		// Le contact avec une piece n'a aucune repercussion sur cat
		if(this.contactArriere(piece) == true || this.contactAvant(piece) == true || this.contactDessous(piece) == true || 
		   this.contactDessus(piece) == true){
			return true;			
		}else{return false;}
	}	

	public void contact(Personnage personnage) {		
		if((super.contactAvant(personnage) == true) || (super.contactArriere(personnage) == true)){
			this.setMarche(false);
		    this.setVivant(false);
		}else if(super.contactDessous(personnage) == true){
			personnage.setMarche(false);
			personnage.setVivant(false);
		}
    }
	
	public Image meurt(){		
		String str;
    	ImageIcon ico;
		Image img;	
		
        str = "/images/boom.png";
        this.compteurMort++;
        if(this.compteurMort > 100){
        	str = "/images/catMeurt.png";
        	this.setY(this.getY() - 1);
        }
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img; 
	} 
}