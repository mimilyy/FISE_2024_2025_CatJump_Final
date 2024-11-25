package source.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import source.objets.Objet;

public class Villain2 extends Personnage implements Runnable{

	private Image imgVillain2;
	private ImageIcon icoVillain2;
	
	private final int PAUSE = 15; // temps d'attente en ms entre 2 tours de boucle
	private int dxVillain2; // pas de deplacement de la villain2
	
	// Constructeur
	public Villain2(int x, int y) {
			
		super(x, y, 43, 50);
		super.setVersDroite(true);
		super.setMarche(true);
		this.dxVillain2 = 1;
			
		this.icoVillain2 = new ImageIcon(getClass().getResource("/images/villain2ArretGauche.png"));
		this.imgVillain2 = this.icoVillain2.getImage();
			
		Thread chronoVillain2 = new Thread(this);
		chronoVillain2.start();
		}
	// Getters
	public Image getImgVillain2() {return imgVillain2;}


	// Méthodes
	public void bouge(){ // Deplacement de Villain2
	    if(super.isVersDroite() == true){this.dxVillain2 = 1;}
	    else{this.dxVillain2 = -1;}
	    super.setX(super.getX() + this.dxVillain2);
	}
	
	@Override
	public void run() {
		try{Thread.sleep(20);} // on attend 20 ms avant d'appeler bouge pour que tous les objets soient completement crees
		catch (InterruptedException e){}		
		
		while(true){ // boucle infinie
			if(this.vivant == true){
		    this.bouge();
		    try{Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
			}
		}
	}

	public void contact(Objet objet) {			
		if(super.contactAvant(objet) == true && this.isVersDroite() == true){					
            super.setVersDroite(false);
	    	this.dxVillain2 = -1;
	    }else if(super.contactArriere(objet) == true && this.isVersDroite() == false){
	    	super.setVersDroite(true);
	    	this.dxVillain2 = 1;
	    }	
	}
	
	public void contact(Personnage personnage) {		
	    if(super.contactAvant(personnage) == true && this.isVersDroite() == true){					
            super.setVersDroite(false);
    	    this.dxVillain2 = -1;
        }else if(super.contactArriere(personnage) == true && this.isVersDroite() == false){
    	    super.setVersDroite(true);
    	    this.dxVillain2 = 1;
        }	
    }
	
    public Image meurt(){		
		String str;
    	ImageIcon ico;
		Image img;	
		
        str = "/images/villain2Fermee.png";
        ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
}