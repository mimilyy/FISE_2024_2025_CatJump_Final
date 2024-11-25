package source.jeu;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import source.affichage.Minuteur;
import source.affichage.Score;
import source.objets.Bloc;
import source.objets.Objet;
import source.objets.Piece;
import source.objets.Barrel;
import source.personnages.Villain1;
import source.personnages.Cat;
import source.personnages.Villain2;

// Scene gere la partie graphique.
@SuppressWarnings("serial")
public class Scene extends JPanel {

	// Variables
	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;
	
	private ImageIcon icoChateau1;  
	private Image imgChateau1;  
	private ImageIcon icoDepart;  
	private Image imgDepart;
	
	private int xFond1;
	private int xFond2;
	private int dx;   // deplacement du fond d'ecran
	private int xPos; // position absolue dans le jeu
	private int ySol; // hauteur courante du sol
	private int hauteurPlafond; // hauteur courante du plafond
	
	public Cat cat;
	
	public Barrel barrel1;
	public Barrel barrel2;
	public Barrel barrel3;
	public Barrel barrel4;
	public Barrel barrel5;
	public Barrel barrel6;
	public Barrel barrel7;
	public Barrel barrel8;
	
	public Bloc bloc1;
	public Bloc bloc2;
	public Bloc bloc3;
	public Bloc bloc4;
	public Bloc bloc5;
	public Bloc bloc6;
	public Bloc bloc7;
	public Bloc bloc8;
	public Bloc bloc9;
	public Bloc bloc10;
	public Bloc bloc11;
	public Bloc bloc12;
	
	public Piece piece1;
	public Piece piece2;
	public Piece piece3;
	public Piece piece4;
	public Piece piece5;
	public Piece piece6;
	public Piece piece7;
	public Piece piece8;
	public Piece piece9;
	public Piece piece10;
	
	public Villain1 villain11;
	public Villain1 villain12;
	public Villain1 villain13;
	public Villain1 villain14;
	public Villain1 villain15;
	public Villain1 villain16;
	public Villain1 villain17;
	public Villain1 villain18;
	
	public Villain2 villain21;
	public Villain2 villain22;
	public Villain2 villain23;
	public Villain2 villain24;
	public Villain2 villain25;
	public Villain2 villain26;
	public Villain2 villain27;
	public Villain2 villain28;
	public Villain2 villain29;
	
	private ImageIcon icoDrapeau;
	private Image imgDrapeau;
	private ImageIcon icoChateauFin;
	private Image imgChateauFin;
	
	private ArrayList<Objet> tabObjets; // tableau qui enregistre tous les objets du jeu
	private ArrayList<Piece> tabPieces; // tableau qui enregistre toutes les pieces du jeu
	private ArrayList<Villain2> tabVillain2s; // tableau qui enregistre tous les villain2s du jeu
	private ArrayList<Villain1> tabVillain1s; // tableau qui enregistre tous les villain1s du jeu
	
	private Score score;
	private Font police;
	private Minuteur minuteur;
	
	// Constructeur
	public Scene(){
		
		super();
		
		this.xFond1 = -50;
		this.xFond2 = 750;
		this.dx = 0;
		this.xPos = -1;
		this.ySol = 293;
		this.hauteurPlafond = 0;
		
		icoFond = new ImageIcon(getClass().getResource("/images/background2.png"));
		this.imgFond1 = this.icoFond.getImage();
		this.imgFond2 = this.icoFond.getImage();
		
		this.icoChateau1 = new ImageIcon(getClass().getResource("/images/house.png"));
		this.imgChateau1 = this.icoChateau1.getImage();  
		this.icoDepart = new ImageIcon(getClass().getResource("/images/fleche.png"));
		this.imgDepart = this.icoDepart.getImage();
		
		cat = new Cat(300, 245);

		barrel1 = new Barrel(600, 230);
		barrel2 = new Barrel(1000, 230);
		barrel3 = new Barrel(1600, 230);
		barrel4 = new Barrel(1900, 230);
		barrel5 = new Barrel(2500, 230);
		barrel6 = new Barrel(3000, 230);
		barrel7 = new Barrel(3800, 230);
		barrel8 = new Barrel(4500, 230);
		
		bloc1 = new Bloc(400, 180);
		bloc2 = new Bloc(1200, 180);
		bloc3 = new Bloc(1270, 170);
		bloc4 = new Bloc(1340, 160);
		bloc5 = new Bloc(2000, 180);
		bloc6 = new Bloc(2600, 160);
		bloc7 = new Bloc(2650, 180);
		bloc8 = new Bloc(3500, 160);
		bloc9 = new Bloc(3550, 140);
		bloc10 = new Bloc(4000, 170);
		bloc11 = new Bloc(4200, 200);
		bloc12 = new Bloc(4300, 210);
		
		piece1 = new Piece(402, 145);
		piece2 = new Piece(1202, 140);
		piece3 = new Piece(1272, 95);
		piece4 = new Piece(1342, 40);
		piece5 = new Piece(1650, 145);
		piece6 = new Piece(2650, 145);
		piece7 = new Piece(3000, 135);
		piece8 = new Piece(3400, 125);
		piece9 = new Piece(4200, 145);
		piece10 = new Piece(4600, 140);
		
		villain11 = new Villain1(800, 263);
		villain12 = new Villain1(1100, 263);
		villain13 = new Villain1(2100, 263);
		villain14 = new Villain1(2400, 263);
		villain15 = new Villain1(3200, 263);
		villain16 = new Villain1(3500, 263);
		villain17 = new Villain1(3700, 263);
		villain18 = new Villain1(4500, 263);
		
		villain21 = new Villain2(950, 243);
		villain22 = new Villain2(1500, 243);
		villain23 = new Villain2(1800, 243);
		villain24 = new Villain2(2400, 243);
		villain25 = new Villain2(3100, 243);
		villain26 = new Villain2(3600, 243);
		villain27 = new Villain2(3900, 243);
		villain28 = new Villain2(4200, 243);
		villain29 = new Villain2(4400, 243);
		
		this.icoChateauFin = new ImageIcon(getClass().getResource("/images/house.png"));
		this.imgChateauFin = this.icoChateauFin.getImage(); 
		
		this.icoDrapeau = new ImageIcon(getClass().getResource("/images/drapeau.png")); 
		this.imgDrapeau = this.icoDrapeau.getImage(); 
		
		tabObjets = new ArrayList<Objet>();			
		this.tabObjets.add(this.barrel1);
		this.tabObjets.add(this.barrel2);
		this.tabObjets.add(this.barrel3);
		this.tabObjets.add(this.barrel4);
		this.tabObjets.add(this.barrel5);
		this.tabObjets.add(this.barrel6);
		this.tabObjets.add(this.barrel7);
		this.tabObjets.add(this.barrel8);
		
		this.tabObjets.add(this.bloc1);
		this.tabObjets.add(this.bloc2);
		this.tabObjets.add(this.bloc3);
		this.tabObjets.add(this.bloc4);
		this.tabObjets.add(this.bloc5);
		this.tabObjets.add(this.bloc6);
		this.tabObjets.add(this.bloc7);
		this.tabObjets.add(this.bloc8);
		this.tabObjets.add(this.bloc9);
		this.tabObjets.add(this.bloc10);
		this.tabObjets.add(this.bloc11);
		this.tabObjets.add(this.bloc12);
			
		tabPieces = new ArrayList<Piece>();			
		this.tabPieces.add(this.piece1);
		this.tabPieces.add(this.piece2);
		this.tabPieces.add(this.piece3);
		this.tabPieces.add(this.piece4);
		this.tabPieces.add(this.piece5);
		this.tabPieces.add(this.piece6);
		this.tabPieces.add(this.piece7);
		this.tabPieces.add(this.piece8);
		this.tabPieces.add(this.piece9);
		this.tabPieces.add(this.piece10);
		
		tabVillain1s = new ArrayList<Villain1>();
		this.tabVillain1s.add(this.villain11);
		this.tabVillain1s.add(this.villain12);
		this.tabVillain1s.add(this.villain13);
		this.tabVillain1s.add(this.villain14);
		this.tabVillain1s.add(this.villain15);
		this.tabVillain1s.add(this.villain16);
		this.tabVillain1s.add(this.villain17);
		this.tabVillain1s.add(this.villain18);
		
		tabVillain2s = new ArrayList<Villain2>();
		this.tabVillain2s.add(this.villain21);
		this.tabVillain2s.add(this.villain22);
		this.tabVillain2s.add(this.villain23);
		this.tabVillain2s.add(this.villain24);
		this.tabVillain2s.add(this.villain25);
		this.tabVillain2s.add(this.villain26);
		this.tabVillain2s.add(this.villain27);
		this.tabVillain2s.add(this.villain28);
		this.tabVillain2s.add(this.villain29);
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		
		score = new Score();
		police = new Font("Arial", Font.PLAIN, 18);
		minuteur = new Minuteur();
				
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
	}

	// Getters
	public int getDx() {return dx;}
	
	public int getxPos() {return xPos;}

	public int getySol() {return ySol;}

	public int getHautPlafond(){return hauteurPlafond;}

	// Setters
	public void setDx(int dx) {this.dx = dx;}
	
	public void setxPos(int xPos) {this.xPos = xPos;}

	public void setySol(int ySol) {this.ySol = ySol;}

	public void setHautPlafond(int hauteurPlafond) {this.hauteurPlafond = hauteurPlafond;}

	public void setxFond1(int xFond1) {this.xFond1 = xFond1;}

	public void setxFond2(int xFond2) {this.xFond2 = xFond2;}

	// Methodes
	public void deplacementFond(){ // Deplacement des images "fixes" de l'ecran simulant le deplacement de cat

		if(this.xPos >= 0 && this.xPos <= 4430){
			// Mise a jour des positions des elements du jeu lors du deplacement de cat
			this.xPos = this.xPos + this.dx;		
		    this.xFond1 = this.xFond1 - this.dx;
		    this.xFond2 = this.xFond2 - this.dx;
		}
		// Permanence du fond d'ecran
		if(this.xFond1 == -800){this.xFond1 = 800;}
		else if(this.xFond2 == -800){this.xFond2 = 800;}
		else if(this.xFond1 == 800){this.xFond1 = -800;}
		else if(this.xFond2 == 800){this.xFond2 = -800;}
	}

	private boolean partieGagnee(){		
		if(this.minuteur.getCompteurTemps() > 0 && this.cat.isVivant() == true && this.score.getNbrePieces() == 10
			&& this.xPos > 4400){
			return true;
		}else{return false;}
	}
	
	private boolean partiePerdue(){
		if(this.cat.isVivant() == false || this.minuteur.getCompteurTemps() <= 0){
			return true;
		}else{return false;}
	}
		
	public boolean finDePartie(){
		if(this.partieGagnee() == true || this.partiePerdue() == true){return true;}
		else{return false;}
	}
	
	
	public void paintComponent(Graphics g) { // Dessin de toutes les images visibles a l'ecran (appel toutes les 3 ms environ)
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;

		// Detections des contacts avec des objets
		for(int i = 0; i < this.tabObjets.size(); i++){
		    // cat
		    if(this.cat.proche(this.tabObjets.get(i))){this.cat.contact(this.tabObjets.get(i));}
		    // villain1
 		    for(int j = 0; j < this.tabVillain1s.size(); j++){
 			  if(this.tabVillain1s.get(j).proche(this.tabObjets.get(i))){this.tabVillain1s.get(j).contact(this.tabObjets.get(i));}
 		    }
 		    // villain2
 		    for(int j = 0; j < this.tabVillain2s.size(); j++){
 			  if(this.tabVillain2s.get(j).proche(this.tabObjets.get(i))){this.tabVillain2s.get(j).contact(this.tabObjets.get(i));} 
 		    }
		}
		
    	// Detection des contacts de cat avec des pieces
 	 	for(int i = 0; i < this.tabPieces.size(); i++){
 	 		if(this.cat.proche(this.tabPieces.get(i))){
 	 			if(this.cat.contactPiece(this.tabPieces.get(i))){
 	 				this.tabPieces.remove(i);
 	 				this.score.setNbrePieces(this.score.getNbrePieces() + 1);
 	 			}
 	 	    }
 	 	}
		
 	    // Detections des contacts des villain1 avec les personnages (hors cat)
 	 	for(int i = 0; i < this.tabVillain1s.size(); i++){
 	 		// villain1
 	 		for(int j = 0; j < this.tabVillain1s.size(); j++){
 	 			if(j != i){ 					 				
 	 	 			 if(this.tabVillain1s.get(j).proche(this.tabVillain1s.get(i))){this.tabVillain1s.get(j).contact(this.tabVillain1s.get(i));}
 	 			}
 	 	 	}
 	 		// villain2
 	 		for(int j = 0; j < this.tabVillain2s.size(); j++){
 		 		if(this.tabVillain2s.get(j).proche(this.tabVillain1s.get(i))){this.tabVillain2s.get(j).contact(this.tabVillain1s.get(i));}
 		 	}
 	    }

 	 	// Detections des contacts des villain2 avec les personnages (hors cat)
 	 	for(int i = 0; i < this.tabVillain2s.size(); i++){  
 	 	 	// villain1
 	 	 	for(int j = 0; j < this.tabVillain1s.size(); j++){
 	 	 	 	if(this.tabVillain1s.get(j).proche(this.tabVillain2s.get(i))){this.tabVillain1s.get(j).contact(this.tabVillain2s.get(i));}
 	 	 	}
 	 	 	// villain2
 	 	 	for(int j = 1; j < this.tabVillain2s.size(); j++){
 	 			if(j != i){
 	 		 		if(this.tabVillain2s.get(j).proche(this.tabVillain2s.get(i))){this.tabVillain2s.get(j).contact(this.tabVillain2s.get(i));} 
 	 			}
 	 		}
 	 	}    
 	 	
 	 	// Detection des contacts de cat avec des personnages
 	 	// villain1
 	 	for(int i = 0; i < this.tabVillain1s.size(); i++){
 	 		if(this.cat.proche(this.tabVillain1s.get(i)) && this.tabVillain1s.get(i).isVivant() == true){
 	 			this.cat.contact(this.tabVillain1s.get(i));
 	 		}
 	 	}
 	 	// villain2
 	 	for(int i = 0; i < this.tabVillain2s.size(); i++){
 	 	 	if(this.cat.proche(this.tabVillain2s.get(i)) && this.tabVillain2s.get(i).isVivant() == true){
 	 	 		this.cat.contact(this.tabVillain2s.get(i));
 	 	 	}
 	 	}
 	 	
		// Deplacement de tous les objets "fixes" du jeu
		this.deplacementFond();		
		
		if(this.xPos >= 0 && this.xPos <= 4430){
		    for(int i = 0; i < this.tabObjets.size(); i++){this.tabObjets.get(i).deplacement();}
		    for(int i = 0; i < this.tabPieces.size(); i++){this.tabPieces.get(i).deplacement();}
		    for(int i = 0; i < this.tabVillain1s.size(); i++){this.tabVillain1s.get(i).deplacement();}
	 		for(int i = 0; i < this.tabVillain2s.size(); i++){this.tabVillain2s.get(i).deplacement();}
		}
		
		// Image de fond
		g2.drawImage(this.imgFond1, this.xFond1, 0, null);
		g2.drawImage(this.imgFond2, this.xFond2, 0, null);
		
		// Image du chateau du depart
 		g2.drawImage(this.imgChateau1, 10 - this.xPos, 95, null);
    	// Image du panneau de depart
 		g2.drawImage(this.imgDepart, 220 - this.xPos, 234, null);

     	// Images des objets
 	 	for(int i = 0; i < this.tabObjets.size(); i++){
 	 		g2.drawImage(this.tabObjets.get(i).getImgObjet(), this.tabObjets.get(i).getX(), this.tabObjets.get(i).getY(), null);
 	 	}	
 	 	 
 	 	// Images des pieces
 	 	for(int i = 0; i < this.tabPieces.size(); i++){
 	 		g2.drawImage(this.tabPieces.get(i).bouge(), this.tabPieces.get(i).getX(), this.tabPieces.get(i).getY(), null);
 	 	}
 	 	
 	    // Image du drapeau d'arrivee
 	 	g2.drawImage(imgDrapeau, 4650 - this.xPos, 115, null);
 	    // Image du chateau d'arrivee
 		g2.drawImage(imgChateauFin, 5000 - this.xPos, 115, null);
 	 	
        // Image de cat
 		if(this.cat.isVivant() == true){
 			if(this.cat.isSaut()){g2.drawImage(this.cat.saute(), this.cat.getX(), this.cat.getY(), null);}
 	 		else{g2.drawImage(this.cat.marche("cat", 25), this.cat.getX(), this.cat.getY(), null);}
 		}else{g2.drawImage(this.cat.meurt(), this.cat.getX(), this.cat.getY(), null);}
 				
 	    // Images des villain1
 	 	for(int i = 0; i < this.tabVillain1s.size(); i++){
 	 		if(this.tabVillain1s.get(i).isVivant() == true){
 	 		    g2.drawImage(this.tabVillain1s.get(i).marche("villain1", 45), this.tabVillain1s.get(i).getX(), this.tabVillain1s.get(i).getY(), null);
 	 		}else{
 	 			g2.drawImage(this.tabVillain1s.get(i).meurt(), this.tabVillain1s.get(i).getX(), this.tabVillain1s.get(i).getY() + 20, null);
 	 		}
 	 	}
 	 		
 	 	// Images des villain2
 	    for(int i = 0; i < this.tabVillain2s.size(); i++){
 	 		if(this.tabVillain2s.get(i).isVivant() == true){
 	 		    g2.drawImage(this.tabVillain2s.get(i).marche("villain2", 50), this.tabVillain2s.get(i).getX(), this.tabVillain2s.get(i).getY(), null);
 	 	    }else{
 	 			g2.drawImage(this.tabVillain2s.get(i).meurt(), this.tabVillain2s.get(i).getX(), this.tabVillain2s.get(i).getY() + 30, null);				
 	 		}
 	 	}
 	    // Mise a jour du score
	    g2.setFont(police);
	    g2.drawString(this.score.getNbrePieces() + " pièce(s) trouvée(s) sur " + this.score.getNBRE_TOTAL_PIECES(), 460, 25);
	    
	    // Mise a jour du temps de jeu restant
	    g2.drawString(this.minuteur.getStr(), 5, 25);
	    
	    // Fin de partie
	    if(this.finDePartie() == true){
	    	Font policeFin = new Font("Arial", Font.BOLD, 50);
            g2.setFont(policeFin);
	        if(this.partieGagnee() == true){g2.drawString("Vous avez gagné !!", 120, 180);}
	        else{g2.drawString("Game Over...", 120, 180);}
 	    }
    }
}