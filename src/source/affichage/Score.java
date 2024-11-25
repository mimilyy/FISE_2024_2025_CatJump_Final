package source.affichage;

public class Score {

	 // Variables
	private final int NBRE_TOTAL_PIECES = 10;
	private int nbrePieces;
		
	// Constructeur
	public Score(){
		this.nbrePieces = 0;
	}

	// Getters
	public int getNbrePieces() {return nbrePieces;}

	public int getNBRE_TOTAL_PIECES() {return NBRE_TOTAL_PIECES;}

	// Setter
	public void setNbrePieces(int nbrePieces) {this.nbrePieces = nbrePieces;}
}
