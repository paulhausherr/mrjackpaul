package ft.groupe.MrJackPaul;

public class Mrjack {
	public Perso persoMrjack;
	public int nbSablier;
	public Perso[] carte = new Perso[4];
	
	public Mrjack(Perso persoMrjack) {
		this.carte[0] = new Perso("X", -1);
		this.carte[1] = new Perso("X", -1);
		this.carte[2] = new Perso("X", -1);
		this.carte[3] = new Perso("X", -1);
		this.persoMrjack = persoMrjack;
		this.nbSablier = 0;
	}
}
