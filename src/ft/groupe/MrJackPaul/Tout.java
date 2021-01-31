package ft.groupe.MrJackPaul;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Tout {
	public Case[][] plateauDeJeu; // Plateau de jeu
	public HolmesWatsonChien holmesWatsonChien; // Les detectuves autour du plateau (dedans c'est du 3 par 3)
	public Jetons[] jetons; // Les 4 jetons
	public Mrjack mrjack; // MrJack
	public ArrayList<Perso> carte; // Pile de carte
	public Random rand = new Random();
	public int tour; // Tour
	public int tourTour; // Phases dans le tour
	
	public Tout() {
		tour = 1;
		tourTour = 0;
		plateauDeJeu = new Case[3][3];
		holmesWatsonChien = new HolmesWatsonChien();
		jetons = new Jetons[4];
		
		jetons[0] = new Jetons("Tourner", "Echanger");
		jetons[1] = new Jetons("Chien", "Watson");
		jetons[2] = new Jetons("Holmes", "Piocher");
		jetons[3] = new Jetons("Tourner", "Jocker");
		addCarte();
		
		plateauDeJeu[0][0] = new Case(carte.get(0), 3);
		plateauDeJeu[0][1] = new Case(carte.get(1), rand.nextInt(4));
		plateauDeJeu[0][2] = new Case(carte.get(2), 1);
		plateauDeJeu[1][0] = new Case(carte.get(3), rand.nextInt(4));
		plateauDeJeu[1][1] = new Case(carte.get(4), rand.nextInt(4));
		plateauDeJeu[1][2] = new Case(carte.get(5), rand.nextInt(4));
		plateauDeJeu[2][0] = new Case(carte.get(6), rand.nextInt(4));
		plateauDeJeu[2][1] = new Case(carte.get(7), 2);
		plateauDeJeu[2][2] = new Case(carte.get(8), rand.nextInt(4));
		Collections.shuffle(carte);
		
		mrjack = new Mrjack(carte.get(0));
		carte.remove(0);
	}
	
	public void addCarte() {
		carte = new ArrayList<Perso>();
		carte.add(new Perso("Rose", 2));
		carte.add(new Perso("Noir", 0));
		carte.add(new Perso("Orange", 1));
		carte.add(new Perso("Violet", 1));
		carte.add(new Perso("Vert", 1));
		carte.add(new Perso("Jaune", 1));
		carte.add(new Perso("Bleu", 0));
		carte.add(new Perso("Blanc", 1));
		carte.add(new Perso("Gris", 1));
		Collections.shuffle(carte);
	}
}
