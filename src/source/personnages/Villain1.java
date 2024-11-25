package source.personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

import source.objets.Objet;

public class Villain1 extends Personnage implements Runnable{
	
	private Image imgVillain1;
	private ImageIcon icoVillain1;
	
	private final int PAUSE = 15; // temps d'attente en ms entre 2 tours de boucle
	private int dxVillain1; // pas de deplacement du villain1

	// Constructeur
	public Villain1(int x, int y) {
		
		super(x, y, 27, 30);
		super.setVersDroite(true);
		super.setMarche(true);
		this.dxVillain1 = 1;
		
		this.icoVillain1 = new ImageIcon(getClass().getResource("/images/villain1ArretDroite.png"));
		this.imgVillain1 = this.icoVillain1.getImage();
		
		Thread chronoVillain1 = new Thread(this);
		chronoVillain1.start();
	}

	// Getters
	public Image getImgVillain1() {return imgVillain1;}

	// Methodes
	public void bouge(){ // Deplacement du villain1
    	if(super.isVersDroite() == true){this.dxVillain1 = 1;}
    	else{this.dxVillain1 = -1;}
        super.setX(super.getX() + this.dxVillain1);
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

	// Methodes pour détecter les contacts
	public void contact(Objet objet) {			
		if(super.contactAvant(objet) == true && this.isVersDroite() == true){					
            super.setVersDroite(false);
	    	this.dxVillain1 = -1;
	    }else if(super.contactArriere(objet) == true && this.isVersDroite() == false){
	    	super.setVersDroite(true);
	    	this.dxVillain1 = 1;
	    }	
	}
	
	public void contact(Personnage personnage) {		
	    if(super.contactAvant(personnage) == true && this.isVersDroite() == true){					
            super.setVersDroite(false);
    	    this.dxVillain1 = -1;
        }else if(super.contactArriere(personnage) == true && this.isVersDroite() == false){
    	    super.setVersDroite(true);
    	    this.dxVillain1 = 1;
        }	
    }
	
	public Image meurt(){		
		String str;
    	ImageIcon ico;
		Image img;	
		
        if(this.isVersDroite() == true){str = "/images/villain1EcraseDroite.png";}
        else{str = "/images/villain1EcraseGauche.png";}
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img; 
	} 
}