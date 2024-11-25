package source.affichage;

public class Minuteur implements Runnable{

	// Variables
	private final int PAUSE = 1000;	
	private int compteurTemps;
	private String str;

	// Constructeur
	public Minuteur(){

		this.compteurTemps = 100; 
		this.str = "Temps restant : 100";
		
		Thread compteARebours = new Thread(this);
		compteARebours.start();
	}

	// Getters
	public int getCompteurTemps() {return compteurTemps;}
	
    public String getStr() {return str;}

	// Methode
	@Override
	public void run() {		
		
		while(true){ // boucle infinie											
		    try{Thread.sleep(PAUSE);}
			catch (InterruptedException e){}
			this.compteurTemps--;
			this.str = "Temps restant : " + this.compteurTemps;
		}		
	} 
	
}
