package ft.groupe.MrJackPaul;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Fenetre extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	public Random rand = new Random();
	public Tout tout;
	public JLayeredPane contentPane;
	public JButton[][] BoutonTab = new JButton[3][3]; // Plateau
	public JButton[] BoutonDetective = new JButton[3]; // Detective
	public JLabel TexteSablier; // texte pour les sabliers
	public JLabel TexteTour; // texte pour le tour
	public JButton CarteMechant; // la carte du mechant en bas a gauche
	public JButton[] CartesMechants = new JButton[4]; // Les cartes du mechant en bas a gauche
	public JButton[] Jetons = new JButton[4]; // les boutons pour les jetons
	public JButton BoutonOk; // bouton ok quand on doit valider le tourner d une case
	public JButton Bouton1; // Avancer de 1
	public JButton Bouton2; // Avancer de 2
	public JButton BoutonC; // Avancer le chien
	public JButton BoutonW; // Avancer Watson
	public JButton BoutonH; // Avancer Holmes
	
	public int flag;
	public int flagi;
	public int flagj;
	
	public Fenetre() {
		tout = new Tout();
		flag = 0;
		flagi = -1;
		flagj = -1;
		
		this.setTitle("MrJack");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setResizable(false);
    	this.setSize(800, 600);
    	this.setLocationRelativeTo(null);
    	
    	contentPane = new JLayeredPane();
    	contentPane.setBounds(0, 0, 800, 600);
    	
    	for (int i = 0 ; i < 3 ; i++) {
    		for (int j = 0 ; j < 3 ; j++) {
		    	BoutonTab[i][j] = new JButton();
		    	BoutonTab[i][j].setIcon(new ImageIcon(Fenetre.class.getResource("/CasePerso/" + tout.plateauDeJeu[i][j].perso.nom + tout.plateauDeJeu[i][j].orientationMur + ".png")));
		        BoutonTab[i][j].setBounds(150 + j * 101, 100 + i * 101, 100, 100);
		        BoutonTab[i][j].addActionListener((ActionListener) this);
		        contentPane.add(BoutonTab[i][j]);
    		}
    	}
    	
    	for (int i = 0 ; i < 3 ; i++) {
    		BoutonDetective[i] = new JButton();
    		BoutonDetective[i].setIcon(new ImageIcon(Fenetre.class.getResource("/Detectives/" + tout.holmesWatsonChien.name[i] + ".png")));
    		BoutonDetective[i].addActionListener((ActionListener) this);
    		if (tout.holmesWatsonChien.position[i] == 0) {
    			BoutonDetective[i].setBounds(175, 50, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 1) {
    			BoutonDetective[i].setBounds(275, 50, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 2) {
    			BoutonDetective[i].setBounds(375, 50, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 3) {
    			BoutonDetective[i].setBounds(450, 125, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 4) {
    			BoutonDetective[i].setBounds(450, 225, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 5) {
    			BoutonDetective[i].setBounds(450, 325, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 6) {
    			BoutonDetective[i].setBounds(375, 400, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 7) {
    			BoutonDetective[i].setBounds(275, 400, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 8) {
    			BoutonDetective[i].setBounds(175, 400, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 9) {
    			BoutonDetective[i].setBounds(100, 325, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 10) {
    			BoutonDetective[i].setBounds(100, 225, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 11) {
    			BoutonDetective[i].setBounds(100, 125, 50, 50);
    		}
    		contentPane.add(BoutonDetective[i]);
    	}
    	
    	TexteSablier = new JLabel(tout.mrjack.nbSablier + " sabliers");
    	TexteSablier.setBounds(700, 0, 100, 40);
    	TexteSablier.setOpaque(true);
    	TexteSablier.setBackground(Color.white);
    	contentPane.add(TexteSablier);
    	
    	TexteTour = new JLabel("Tour du detective - Tour " + tout.tour);
    	TexteTour.setBounds(0, 0, 200, 30);
    	TexteTour.setOpaque(true);
    	TexteTour.setBackground(Color.white);
    	contentPane.add(TexteTour);
    	
    	BoutonOk = new JButton("Ok !");
    	BoutonOk.setBounds(700, 500, 50, 50);
    	BoutonOk.addActionListener((ActionListener) this);
    	contentPane.add(BoutonOk);
    	BoutonOk.setVisible(false);
    	
    	Bouton1 = new JButton("1");
    	Bouton1.setBounds(700, 500, 50, 50);
    	Bouton1.addActionListener((ActionListener) this);
    	contentPane.add(Bouton1);
    	Bouton1.setVisible(false);
    	
    	Bouton2 = new JButton("2");
    	Bouton2.setBounds(750, 500, 50, 50);
    	Bouton2.addActionListener((ActionListener) this);
    	contentPane.add(Bouton2);
    	Bouton2.setVisible(false);
    	
    	BoutonC = new JButton("Chien");
    	BoutonC.setBounds(580, 500, 75, 50);
    	BoutonC.addActionListener((ActionListener) this);
    	contentPane.add(BoutonC);
    	BoutonC.setVisible(false);
    	
    	BoutonW = new JButton("Watson");
    	BoutonW.setBounds(655, 500, 75, 50);
    	BoutonW.addActionListener((ActionListener) this);
    	contentPane.add(BoutonW);
    	BoutonW.setVisible(false);
    	
    	BoutonH = new JButton("Holmes");
    	BoutonH.setBounds(730, 500, 70, 50);
    	BoutonH.addActionListener((ActionListener) this);
    	contentPane.add(BoutonH);
    	BoutonH.setVisible(false);
    	
    	CarteMechant = new JButton();
    	CarteMechant.setIcon(new ImageIcon(Fenetre.class.getResource("/CasePerso/CarteRien.png")));
    	CarteMechant.setBounds(0, 490, 60, 90);
    	CarteMechant.addActionListener((ActionListener) this);
        contentPane.add(CarteMechant);
    	
        for (int i = 0 ; i < 4 ; i++) {
        	CartesMechants[i] = new JButton();
        	CartesMechants[i].setIcon(new ImageIcon(Fenetre.class.getResource("/CasePerso/CarteRien.png")));
        	CartesMechants[i].setBounds(70 * (i + 1), 490, 60, 90);
        	CartesMechants[i].addActionListener((ActionListener) this);
        }
        
        for (int i = 0 ; i < 4 ; i++) {
        	tout.jetons[i].cote = rand.nextInt(2);
        	Jetons[i] = new JButton();
        	Jetons[i].setIcon(new ImageIcon(Fenetre.class.getResource("/Actions/Jeton" + (i + 1) + "" + tout.jetons[i].cote + ".png")));
        	Jetons[i].setBounds(450 + i * 70, 450, 50, 50);
        	Jetons[i].addActionListener((ActionListener) this);
        	contentPane.add(Jetons[i]); 
        }
        
    	this.add(contentPane);
	}
	
	public void changerPlateau() {
		for (int i = 0 ; i < 3 ; i++) {
    		for (int j = 0 ; j < 3 ; j++) {
    			if (tout.plateauDeJeu[i][j].retournee == 0)
    				BoutonTab[i][j].setIcon(new ImageIcon(Fenetre.class.getResource("/CasePerso/" + tout.plateauDeJeu[i][j].perso.nom + tout.plateauDeJeu[i][j].orientationMur + ".png")));
    			else
    				BoutonTab[i][j].setIcon(new ImageIcon(Fenetre.class.getResource("/CasePerso/Vide" + tout.plateauDeJeu[i][j].orientationMur + ".png")));
    		}
    	}
	}

	public void changerDetective() {
		for (int i = 0 ; i < 3 ; i++) {
    		if (tout.holmesWatsonChien.position[i] == 0) {
    			BoutonDetective[i].setBounds(175, 50, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 1) {
    			BoutonDetective[i].setBounds(275, 50, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 2) {
    			BoutonDetective[i].setBounds(375, 50, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 3) {
    			BoutonDetective[i].setBounds(450, 125, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 4) {
    			BoutonDetective[i].setBounds(450, 225, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 5) {
    			BoutonDetective[i].setBounds(450, 325, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 6) {
    			BoutonDetective[i].setBounds(375, 400, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 7) {
    			BoutonDetective[i].setBounds(275, 400, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 8) {
    			BoutonDetective[i].setBounds(175, 400, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 9) {
    			BoutonDetective[i].setBounds(100, 325, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 10) {
    			BoutonDetective[i].setBounds(100, 225, 50, 50);
    		} else if (tout.holmesWatsonChien.position[i] == 11) {
    			BoutonDetective[i].setBounds(100, 125, 50, 50);
    		}
    	}
	}
	
	public void changerJeton() {
		for (int i = 0 ; i < 4 ; i++) {
        	Jetons[i].setIcon(new ImageIcon(Fenetre.class.getResource("/Actions/Jeton" + (i + 1) + "" + tout.jetons[i].cote + ".png")));
        }
	}
	
	public void ftHolmesWatsonChien() {
		Bouton1.setVisible(true);
		Bouton2.setVisible(true);
	}
	
	public void ftCarte() {
		Perso flagPerso;
		
		if ((tout.tour % 2 == 1 && (tout.tourTour == 0 || tout.tourTour == 3)) // Tour du detective
				|| (tout.tour % 2 == 0 && (tout.tourTour == 1 || tout.tourTour == 2))) {
			flagPerso = tout.carte.get(0);
			tout.carte.remove(0);
			for (int i = 0 ; i < 3 ; i++) {
				for (int j = 0 ; j < 3 ; j++) {
					if (tout.plateauDeJeu[i][j].perso == flagPerso) {
						BoutonTab[i][j].setIcon(new ImageIcon(Fenetre.class.getResource("/CasePerso/Vide" + tout.plateauDeJeu[i][j].orientationMur + ".png")));
						tout.plateauDeJeu[i][j].retournee = 1;
					}
				}
			}
		}
		else { // Tour de MrJack
			for (int i = 0 ; i < 4 ; i++) {
				if (tout.mrjack.carte[i].sablier == -1) {
					tout.mrjack.carte[i] = tout.carte.get(0);
					tout.carte.remove(0);
					contentPane.add(CartesMechants[i]);
					tout.mrjack.nbSablier = tout.mrjack.nbSablier + tout.mrjack.carte[i].sablier;
					TexteSablier.setText(tout.mrjack.nbSablier + " sabliers");
					break;
				}
			}
		}
	}
	
	public void ftJocker() {
		BoutonC.setVisible(true);
		BoutonW.setVisible(true);
		BoutonH.setVisible(true);
	}
	
	public void vuPasVu(int i, ArrayList<Integer> vu, boolean dedans) {
		if (i == 0) {
			if (tout.plateauDeJeu[0][0].orientationMur != 0) {
				if (vu.contains(0) == false)
					vu.add(0);
				if (tout.plateauDeJeu[0][0].orientationMur != 2 && tout.plateauDeJeu[1][0].orientationMur != 0) {
					if (vu.contains(3) == false)
						vu.add(3);
					if (tout.plateauDeJeu[1][0].orientationMur != 2 && tout.plateauDeJeu[2][0].orientationMur != 0) {
						if (vu.contains(6) == false)
							vu.add(6);
					}
				}
			}
		} else if (i == 1) {
			if (tout.plateauDeJeu[0][1].orientationMur != 0) {
				if (vu.contains(1) == false)
					vu.add(1);
				if (tout.plateauDeJeu[0][1].orientationMur != 2 && tout.plateauDeJeu[1][1].orientationMur != 0) {
					if (vu.contains(4) == false)
						vu.add(4);
					if (tout.plateauDeJeu[1][1].orientationMur != 2 && tout.plateauDeJeu[2][1].orientationMur != 0) {
						if (vu.contains(7) == false)
							vu.add(7);
					}
				}
			}
		} else if (i == 2) {
			if (tout.plateauDeJeu[0][2].orientationMur != 0) {
				if (vu.contains(2) == false)
					vu.add(2);
				if (tout.plateauDeJeu[0][2].orientationMur != 2 && tout.plateauDeJeu[1][2].orientationMur != 0) {
					if (vu.contains(5) == false)
						vu.add(5);
					if (tout.plateauDeJeu[1][2].orientationMur != 2 && tout.plateauDeJeu[2][2].orientationMur != 0) {
						if (vu.contains(8) == false)
							vu.add(8);
					}
				}
			}
		} else if (i == 3) {
			if (tout.plateauDeJeu[0][2].orientationMur != 1) {
				if (vu.contains(2) == false)
					vu.add(2);
				if (tout.plateauDeJeu[0][2].orientationMur != 3 && tout.plateauDeJeu[0][1].orientationMur != 1) {
					if (vu.contains(1) == false)
						vu.add(1);
					if (tout.plateauDeJeu[0][1].orientationMur != 3 && tout.plateauDeJeu[0][0].orientationMur != 1) {
						if (vu.contains(0) == false)
							vu.add(0);
					}
				}
			}
		} else if (i == 4) {
			if (tout.plateauDeJeu[1][2].orientationMur != 1) {
				if (vu.contains(5) == false)
					vu.add(5);
				if (tout.plateauDeJeu[1][2].orientationMur != 3 && tout.plateauDeJeu[1][1].orientationMur != 1) {
					if (vu.contains(4) == false)
						vu.add(4);
					if (tout.plateauDeJeu[1][1].orientationMur != 3 && tout.plateauDeJeu[1][0].orientationMur != 1) {
						if (vu.contains(3) == false)
							vu.add(3);
					}
				}
			}
		} else if (i == 5) {
			if (tout.plateauDeJeu[2][2].orientationMur != 1) {
				if (vu.contains(8) == false)
					vu.add(8);
				if (tout.plateauDeJeu[2][2].orientationMur != 3 && tout.plateauDeJeu[2][1].orientationMur != 1) {
					if (vu.contains(7) == false)
						vu.add(7);
					if (tout.plateauDeJeu[2][1].orientationMur != 3 && tout.plateauDeJeu[2][0].orientationMur != 1) {
						if (vu.contains(6) == false)
							vu.add(6);
					}
				}
			}
		} else if (i == 6) {
			if (tout.plateauDeJeu[2][2].orientationMur != 2) {
				if (vu.contains(8) == false)
					vu.add(8);
				if (tout.plateauDeJeu[2][2].orientationMur != 0 && tout.plateauDeJeu[1][2].orientationMur != 2) {
					if (vu.contains(5) == false)
						vu.add(5);
					if (tout.plateauDeJeu[1][2].orientationMur != 0 && tout.plateauDeJeu[0][2].orientationMur != 2) {
						if (vu.contains(2) == false)
							vu.add(2);
					}
				}
			}
		} else if (i == 7) {
			if (tout.plateauDeJeu[2][1].orientationMur != 2) {
				if (vu.contains(7) == false)
					vu.add(7);
				if (tout.plateauDeJeu[2][1].orientationMur != 0 && tout.plateauDeJeu[1][1].orientationMur != 2) {
					if (vu.contains(4) == false)
						vu.add(4);
					if (tout.plateauDeJeu[1][1].orientationMur != 0 && tout.plateauDeJeu[0][1].orientationMur != 2) {
						if (vu.contains(1) == false)
							vu.add(1);
					}
				}
			}
		} else if (i == 8) {
			if (tout.plateauDeJeu[2][0].orientationMur != 2) {
				if (vu.contains(6) == false)
					vu.add(6);
				if (tout.plateauDeJeu[2][0].orientationMur != 0 && tout.plateauDeJeu[1][0].orientationMur != 2) {
					if (vu.contains(3) == false)
						vu.add(3);
					if (tout.plateauDeJeu[1][0].orientationMur != 0 && tout.plateauDeJeu[0][0].orientationMur != 2) {
						if (vu.contains(0) == false)
							vu.add(0);
					}
				}
			}
		} else if (i == 9) {
			if (tout.plateauDeJeu[2][0].orientationMur != 3) {
				if (vu.contains(6) == false)
					vu.add(6);
				if (tout.plateauDeJeu[2][0].orientationMur != 1 && tout.plateauDeJeu[2][1].orientationMur != 3) {
					if (vu.contains(7) == false)
						vu.add(7);
					if (tout.plateauDeJeu[2][1].orientationMur != 1 && tout.plateauDeJeu[2][2].orientationMur != 3) {
						if (vu.contains(8) == false)
							vu.add(8);
					}
				}
			}
		} else if (i == 10) {
			if (tout.plateauDeJeu[1][0].orientationMur != 3) {
				if (vu.contains(3) == false)
					vu.add(3);
				if (tout.plateauDeJeu[1][0].orientationMur != 1 && tout.plateauDeJeu[1][1].orientationMur != 3) {
					if (vu.contains(4) == false)
						vu.add(4);
					if (tout.plateauDeJeu[1][1].orientationMur != 1 && tout.plateauDeJeu[1][2].orientationMur != 3) {
						if (vu.contains(5) == false)
							vu.add(5);
					}
				}
			}
		} else if (i == 11) {
			if (tout.plateauDeJeu[0][0].orientationMur != 3) {
				if (vu.contains(0) == false)
					vu.add(0);
				if (tout.plateauDeJeu[0][0].orientationMur != 1 && tout.plateauDeJeu[0][1].orientationMur != 3) {
					if (vu.contains(1) == false)
						vu.add(1);
					if (tout.plateauDeJeu[0][1].orientationMur != 1 && tout.plateauDeJeu[0][2].orientationMur != 3) {
						if (vu.contains(2) == false)
							vu.add(2);
					}
				}
			}
		}
	}
	
	public void finTour() {
		ArrayList<Integer> vu = new ArrayList<Integer>();
		boolean dedans = false;
		
		if (tout.holmesWatsonChien.position[0] == 0 || tout.holmesWatsonChien.position[1] == 0
				|| tout.holmesWatsonChien.position[2] == 0)
			vuPasVu(0, vu, dedans);
		if (tout.holmesWatsonChien.position[0] == 1 || tout.holmesWatsonChien.position[1] == 1
				|| tout.holmesWatsonChien.position[2] == 1)
			vuPasVu(1, vu, dedans);
		if (tout.holmesWatsonChien.position[0] == 2 || tout.holmesWatsonChien.position[1] == 2
				|| tout.holmesWatsonChien.position[2] == 2)
			vuPasVu(2, vu, dedans);
		if (tout.holmesWatsonChien.position[0] == 3 || tout.holmesWatsonChien.position[1] == 3
				|| tout.holmesWatsonChien.position[2] == 3)
			vuPasVu(3, vu, dedans);
		if (tout.holmesWatsonChien.position[0] == 4 || tout.holmesWatsonChien.position[1] == 4
				|| tout.holmesWatsonChien.position[2] == 4)
			vuPasVu(4, vu, dedans);
		if (tout.holmesWatsonChien.position[0] == 5 || tout.holmesWatsonChien.position[1] == 5
				|| tout.holmesWatsonChien.position[2] == 5)
			vuPasVu(5, vu, dedans);
		if (tout.holmesWatsonChien.position[0] == 6 || tout.holmesWatsonChien.position[1] == 6
				|| tout.holmesWatsonChien.position[2] == 6)
			vuPasVu(6, vu, dedans);
		if (tout.holmesWatsonChien.position[0] == 7 || tout.holmesWatsonChien.position[1] == 7
				|| tout.holmesWatsonChien.position[2] == 7)
			vuPasVu(7, vu, dedans);
		if (tout.holmesWatsonChien.position[0] == 8 || tout.holmesWatsonChien.position[1] == 8
				|| tout.holmesWatsonChien.position[2] == 8)
			vuPasVu(8, vu, dedans);
		if (tout.holmesWatsonChien.position[0] == 9 || tout.holmesWatsonChien.position[1] == 9
				|| tout.holmesWatsonChien.position[2] == 9)
			vuPasVu(9, vu, dedans);
		if (tout.holmesWatsonChien.position[0] == 10 || tout.holmesWatsonChien.position[1] == 10
				|| tout.holmesWatsonChien.position[2] == 10)
			vuPasVu(10, vu, dedans);
		if (tout.holmesWatsonChien.position[0] == 11 || tout.holmesWatsonChien.position[1] == 11
				|| tout.holmesWatsonChien.position[2] == 11)
			vuPasVu(11, vu, dedans);
		
		for (int j : vu) {
			if (tout.plateauDeJeu[j / 3][j % 3].perso.nom.equals(tout.mrjack.persoMrjack.nom)) {
				dedans = true;
				break;
			}
		}
		if (dedans == false) {
			for (int j : vu) {
				tout.plateauDeJeu[j / 3][j % 3].retournee = 1;
			}
			tout.mrjack.nbSablier++;
			TexteSablier.setText(tout.mrjack.nbSablier + " sabliers");
		} else {
			for (int j = 0 ; j < 9 ; j++) {
				if (vu.contains(j) == false)
					tout.plateauDeJeu[j / 3][j % 3].retournee = 1;
			}
		}
		changerPlateau();
	}
	
	public boolean justeUneCarte() {
		int count = 0;
		
		for (int i = 0 ; i < 3 ; i++) {
			for (int j = 0 ; j < 3 ; j++) {
				if (tout.plateauDeJeu[i][j].retournee == 0) {
					count++;
				}
			}
		}
		if (count == 1)
			return (true);
		return (false);
	}
	
	public boolean finDuFichier() {
		if (tout.tour > 8) {
			System.out.println("MrJack gagne");
			return (true);
		} else if (tout.mrjack.nbSablier >= 6) {
			System.out.println("MrJack gagne");
			return (true);
		} else if (justeUneCarte() == true) {
			System.out.println("Le detective gagne");
			return (true);
		}
		return (false);
	}
	
	public void ftTourSupp() { // Si c'est la fin du tour
		tout.tourTour = 0;
		tout.tour++;
		finTour(); // Fin d'un tour, on regarde quel quartier retourner et tout et tout
		if (finDuFichier() == true) { // Si un des gars a gagne
			this.dispose();
		} // Fin ? Tour 8, ...
		if (tout.tour % 2 == 1) {
			tout.jetons[0].cote = rand.nextInt(2);
			tout.jetons[1].cote = rand.nextInt(2);
			tout.jetons[2].cote = rand.nextInt(2);
			tout.jetons[3].cote = rand.nextInt(2);
		} else {
			tout.jetons[0].changerFace();
			tout.jetons[1].changerFace();
			tout.jetons[2].changerFace();
			tout.jetons[3].changerFace();
		}
		Jetons[0].setVisible(true);
		Jetons[1].setVisible(true);
		Jetons[2].setVisible(true);
		Jetons[3].setVisible(true);
		changerJeton();
	}
	
	public void ftTourTourSupp() { // A la fin de l'action d'un jeu
		tout.tourTour++;
		if (tout.tourTour == 4) { // Si c'est la fin du tour
			ftTourSupp();
		}
		
		if ((tout.tour % 2 == 1 && (tout.tourTour == 0 || tout.tourTour == 3))
				|| (tout.tour % 2 == 0 && (tout.tourTour == 1 || tout.tourTour == 2)))
			TexteTour.setText("Tour du detective - Tour " + tout.tour);
		else
			TexteTour.setText("Tour de MrJack - Tour " + tout.tour);
	}

	@Override
	public void actionPerformed(ActionEvent e) { // Si un bouton est appuye
		if (e.getSource() == Jetons[0] && flag == 0)  { // Jeton 1
			if (tout.jetons[0].cote == 0) { 
				Jetons[0].setVisible(false);
				flag = 1;
			} else if (tout.jetons[0].cote == 1) { // face
				Jetons[0].setVisible(false);
				flag = 4;
			}
		} else if (e.getSource() == Jetons[1] && flag == 0) { // Jeton 2
			if (tout.jetons[1].cote == 0) { // pile
				ftHolmesWatsonChien();
				Jetons[1].setVisible(false);
				flag = 100;
			} else if (tout.jetons[1].cote == 1) { // face
				ftHolmesWatsonChien();
				Jetons[1].setVisible(false);
				flag = 200;
			}
		} else if (e.getSource() == Jetons[2] && flag == 0) { // Jeton 3
			if (tout.jetons[2].cote == 0) { // pile
				ftHolmesWatsonChien();
				Jetons[2].setVisible(false);
				flag = 300;
			} else if (tout.jetons[2].cote == 1) { // face
				ftCarte();
				Jetons[2].setVisible(false);
				ftTourTourSupp();
			}
		} else if (e.getSource() == Jetons[3] && flag == 0) { // Jeton 4
			if (tout.jetons[3].cote == 0) { // pile
				Jetons[3].setVisible(false);
				flag = 1;
			} else if (tout.jetons[3].cote == 1) { // face
				ftJocker();
				Jetons[3].setVisible(false);
				flag = 3;
			}
		} else if (e.getSource() == Bouton1 && flag > 99) { // Si on a appuye sur un des detectives (chien, watson ou holmes) et qu'ensuite on appuie pour avancer de 1
			Bouton1.setVisible(false);
			Bouton2.setVisible(false);
			if (flag == 100) {
				tout.holmesWatsonChien.ajouterPosition(1);
			} else if (flag == 200) {
				tout.holmesWatsonChien.ajouterPosition(0);
			} else if (flag == 300) {
				tout.holmesWatsonChien.ajouterPosition(2);
			}
			changerDetective();
			flag = 0;
			ftTourTourSupp();
		} else if (e.getSource() == Bouton2 && flag > 99) { // Si on a appuye sur un des detectives (chien, watson ou holmes) et qu'ensuite on appuie pour avancer de 2
			Bouton1.setVisible(false);
			Bouton2.setVisible(false);
			if (flag == 100) {
				tout.holmesWatsonChien.ajouterPosition(1);
				tout.holmesWatsonChien.ajouterPosition(1);
			} else if (flag == 200) {
				tout.holmesWatsonChien.ajouterPosition(0);
				tout.holmesWatsonChien.ajouterPosition(0);
			} else if (flag == 300) {
				tout.holmesWatsonChien.ajouterPosition(2);
				tout.holmesWatsonChien.ajouterPosition(2);
			}
			changerDetective();
			flag = 0;
			ftTourTourSupp();
		} else if (e.getSource() == BoutonC && flag == 3) { // Joker -> Avancer le chien
			BoutonC.setVisible(false);
			BoutonH.setVisible(false);
			BoutonW.setVisible(false);
			tout.holmesWatsonChien.ajouterPosition(1);
			changerDetective();
			flag = 0;
			ftTourTourSupp();
		} else if (e.getSource() == BoutonW && flag == 3) { // Joker -> Avancer Watson
			BoutonC.setVisible(false);
			BoutonH.setVisible(false);
			BoutonW.setVisible(false);
			tout.holmesWatsonChien.ajouterPosition(0);
			changerDetective();
			flag = 0;
			ftTourTourSupp();
		} else if (e.getSource() == BoutonH && flag == 3) { // Joker -> Avancer Holmes
			BoutonC.setVisible(false);
			BoutonH.setVisible(false);
			BoutonW.setVisible(false);
			tout.holmesWatsonChien.ajouterPosition(2);
			changerDetective();
			flag = 0;
			ftTourTourSupp();
		}
		else if (e.getSource() == BoutonTab[0][0] || e.getSource() == BoutonTab[0][1] || e.getSource() == BoutonTab[0][2]
				|| e.getSource() == BoutonTab[1][0] || e.getSource() == BoutonTab[1][1] || e.getSource() == BoutonTab[1][2]
				|| e.getSource() == BoutonTab[2][0] || e.getSource() == BoutonTab[2][1] || e.getSource() == BoutonTab[2][2]) {
			if (flag == 1) { // Tourner une case
				BoutonOk.setVisible(true);
				if (e.getSource() == BoutonTab[0][0] && ((flagi == 0 && flagj == 0) || flagi == -1)) {
					if (tout.plateauDeJeu[0][0].orientationMur == 3)
						tout.plateauDeJeu[0][0].orientationMur = 0;
					else
						tout.plateauDeJeu[0][0].orientationMur++;
					flagi = 0;
					flagj = 0;
				} else if (e.getSource() == BoutonTab[0][1] && ((flagi == 0 && flagj == 1) || flagi == -1)) {
					if (tout.plateauDeJeu[0][1].orientationMur == 3)
						tout.plateauDeJeu[0][1].orientationMur = 0;
					else
						tout.plateauDeJeu[0][1].orientationMur++;
					flagi = 0;
					flagj = 1;
				} else if (e.getSource() == BoutonTab[0][2] && ((flagi == 0 && flagj == 2) || flagi == -1)) {
					if (tout.plateauDeJeu[0][2].orientationMur == 3)
						tout.plateauDeJeu[0][2].orientationMur = 0;
					else
						tout.plateauDeJeu[0][2].orientationMur++;
					flagi = 0;
					flagj = 2;
				} else if (e.getSource() == BoutonTab[1][0] && ((flagi == 1 && flagj == 0) || flagi == -1)) {
					if (tout.plateauDeJeu[1][0].orientationMur == 3)
						tout.plateauDeJeu[1][0].orientationMur = 0;
					else
						tout.plateauDeJeu[1][0].orientationMur++;
					flagi = 1;
					flagj = 0;
				} else if (e.getSource() == BoutonTab[1][1] && ((flagi == 1 && flagj == 1) || flagi == -1)) {
					if (tout.plateauDeJeu[1][1].orientationMur == 3)
						tout.plateauDeJeu[1][1].orientationMur = 0;
					else
						tout.plateauDeJeu[1][1].orientationMur++;
					flagi = 1;
					flagj = 1;
				} else if (e.getSource() == BoutonTab[1][2] && ((flagi == 1 && flagj == 2) || flagi == -1)) {
					if (tout.plateauDeJeu[1][2].orientationMur == 3)
						tout.plateauDeJeu[1][2].orientationMur = 0;
					else
						tout.plateauDeJeu[1][2].orientationMur++;
					flagi = 1;
					flagj = 2;
				} else if (e.getSource() == BoutonTab[2][0] && ((flagi == 2 && flagj == 0) || flagi == -1)) {
					if (tout.plateauDeJeu[2][0].orientationMur == 3)
						tout.plateauDeJeu[2][0].orientationMur = 0;
					else
						tout.plateauDeJeu[2][0].orientationMur++;
					flagi = 2;
					flagj = 0;
				} else if (e.getSource() == BoutonTab[2][1] && ((flagi == 2 && flagj == 1) || flagi == -1)) {
					if (tout.plateauDeJeu[2][1].orientationMur == 3)
						tout.plateauDeJeu[2][1].orientationMur = 0;
					else
						tout.plateauDeJeu[2][1].orientationMur++;
					flagi = 2;
					flagj = 1;
				} else if (e.getSource() == BoutonTab[2][2] && ((flagi == 2 && flagj == 2) || flagi == -1)) {
					if (tout.plateauDeJeu[2][2].orientationMur == 3)
						tout.plateauDeJeu[2][2].orientationMur = 0;
					else
						tout.plateauDeJeu[2][2].orientationMur++;
					flagi = 2;
					flagj = 2;
				}
				changerPlateau();
			} else if (flag == 4) { // echanger une case
				if (e.getSource() == BoutonTab[0][0]) {
					flagi = 0;
					flagj = 0;
				} else if (e.getSource() == BoutonTab[0][1]) {
					flagi = 0;
					flagj = 1;
				} else if (e.getSource() == BoutonTab[0][2]) {
					flagi = 0;
					flagj = 2;
				} else if (e.getSource() == BoutonTab[1][0]) {
					flagi = 1;
					flagj = 0;
				} else if (e.getSource() == BoutonTab[1][1]) {
					flagi = 1;
					flagj = 1;
				} else if (e.getSource() == BoutonTab[1][2]) {
					flagi = 1;
					flagj = 2;
				} else if (e.getSource() == BoutonTab[2][0]) {
					flagi = 2;
					flagj = 0;
				} else if (e.getSource() == BoutonTab[2][1]) {
					flagi = 2;
					flagj = 1;
				} else if (e.getSource() == BoutonTab[2][2]) {
					flagi = 2;
					flagj = 2;
				}
				flag = 20;
			} else if (flag == 20) { // echange une case partie 2
				if (e.getSource() == BoutonTab[0][0] && (flagi != 0 || flagj != 0)) {
					Case flagC = tout.plateauDeJeu[flagi][flagj];
					tout.plateauDeJeu[flagi][flagj] = tout.plateauDeJeu[0][0];
					tout.plateauDeJeu[0][0] = flagC;
					changerPlateau();
					flag = 0;
					flagi = -1;
					flagj = -1;
					ftTourTourSupp();
				} else if (e.getSource() == BoutonTab[0][1] && (flagi != 0 || flagj != 1)) {
					Case flagC = tout.plateauDeJeu[flagi][flagj];
					tout.plateauDeJeu[flagi][flagj] = tout.plateauDeJeu[0][1];
					tout.plateauDeJeu[0][1] = flagC;
					changerPlateau();
					flag = 0;
					flagi = -1;
					flagj = -1;
					ftTourTourSupp();
				} else if (e.getSource() == BoutonTab[0][2] && (flagi != 0 || flagj != 2)) {
					Case flagC = tout.plateauDeJeu[flagi][flagj];
					tout.plateauDeJeu[flagi][flagj] = tout.plateauDeJeu[0][2];
					tout.plateauDeJeu[0][2] = flagC;
					changerPlateau();
					flag = 0;
					flagi = -1;
					flagj = -1;
					ftTourTourSupp();
				} else if (e.getSource() == BoutonTab[1][0] && (flagi != 1 || flagj != 0)) {
					Case flagC = tout.plateauDeJeu[flagi][flagj];
					tout.plateauDeJeu[flagi][flagj] = tout.plateauDeJeu[1][0];
					tout.plateauDeJeu[1][0] = flagC;
					changerPlateau();
					flag = 0;
					flagi = -1;
					flagj = -1;
					ftTourTourSupp();
				} else if (e.getSource() == BoutonTab[1][1] && (flagi != 1 || flagj != 1)) {
					Case flagC = tout.plateauDeJeu[flagi][flagj];
					tout.plateauDeJeu[flagi][flagj] = tout.plateauDeJeu[1][1];
					tout.plateauDeJeu[1][1] = flagC;
					changerPlateau();
					flag = 0;
					flagi = -1;
					flagj = -1;
					ftTourTourSupp();
				} else if (e.getSource() == BoutonTab[1][2] && (flagi != 1 || flagj != 2)) {
					Case flagC = tout.plateauDeJeu[flagi][flagj];
					tout.plateauDeJeu[flagi][flagj] = tout.plateauDeJeu[1][2];
					tout.plateauDeJeu[1][2] = flagC;
					changerPlateau();
					flag = 0;
					flagi = -1;
					flagj = -1;
					ftTourTourSupp();
				} else if (e.getSource() == BoutonTab[2][0] && (flagi != 2 || flagj != 0)) {
					Case flagC = tout.plateauDeJeu[flagi][flagj];
					tout.plateauDeJeu[flagi][flagj] = tout.plateauDeJeu[2][0];
					tout.plateauDeJeu[2][0] = flagC;
					changerPlateau();
					flag = 0;
					flagi = -1;
					flagj = -1;
					ftTourTourSupp();
				} else if (e.getSource() == BoutonTab[2][1] && (flagi != 2 || flagj != 1)) {
					Case flagC = tout.plateauDeJeu[flagi][flagj];
					tout.plateauDeJeu[flagi][flagj] = tout.plateauDeJeu[2][1];
					tout.plateauDeJeu[2][1] = flagC;
					changerPlateau();
					flag = 0;
					flagi = -1;
					flagj = -1;
					ftTourTourSupp();
				} else if (e.getSource() == BoutonTab[2][2] && (flagi != 2 || flagj != 2)) {
					Case flagC = tout.plateauDeJeu[flagi][flagj];
					tout.plateauDeJeu[flagi][flagj] = tout.plateauDeJeu[2][2];
					tout.plateauDeJeu[2][2] = flagC;
					changerPlateau();
					flag = 0;
					flagi = -1;
					flagj = -1;
					ftTourTourSupp();
				}
			}
		} else if (e.getSource() == BoutonOk) { // Quand on a finit de tourner
			flagi = -1;
			flagj = -1;
			flag = 0;
			BoutonOk.setVisible(false);
			ftTourTourSupp();
		} else if (e.getSource() == CarteMechant) { // Tourner la carte mechant pour la voir
			if (tout.mrjack.persoMrjack.up == 0) {
				CarteMechant.setIcon(new ImageIcon(Fenetre.class.getResource("/CasePerso/Carte" + tout.mrjack.persoMrjack.nom + ".png")));
				tout.mrjack.persoMrjack.up = 1;
			} else {
				CarteMechant.setIcon(new ImageIcon(Fenetre.class.getResource("/CasePerso/CarteRien.png")));
				tout.mrjack.persoMrjack.up = 0;
			}
		} else if (e.getSource() == CartesMechants[0] || e.getSource() == CartesMechants[1]
				|| e.getSource() == CartesMechants[2] || e.getSource() == CartesMechants[3]) { // Pareil mais avec les autres
			if (e.getSource() == CartesMechants[0]) {
				if (tout.mrjack.carte[0].up == 0) {
					tout.mrjack.carte[0].up = 1;
					CartesMechants[0].setIcon(new ImageIcon(Fenetre.class.getResource("/CasePerso/Carte" + tout.mrjack.carte[0].nom + ".png")));
				} else if (tout.mrjack.carte[0].up == 1) {
					tout.mrjack.carte[0].up = 0;
					CartesMechants[0].setIcon(new ImageIcon(Fenetre.class.getResource("/CasePerso/CarteRien.png")));
				}
			} else if (e.getSource() == CartesMechants[1]) {
				if (tout.mrjack.carte[1].up == 0) {
					tout.mrjack.carte[1].up = 1;
					CartesMechants[1].setIcon(new ImageIcon(Fenetre.class.getResource("/CasePerso/Carte" + tout.mrjack.carte[1].nom + ".png")));
				} else if (tout.mrjack.carte[1].up == 1) {
					tout.mrjack.carte[1].up = 0;
					CartesMechants[1].setIcon(new ImageIcon(Fenetre.class.getResource("/CasePerso/CarteRien.png")));
				}
			} else if (e.getSource() == CartesMechants[2]) {
				if (tout.mrjack.carte[2].up == 0) {
					tout.mrjack.carte[2].up = 1;
					CartesMechants[2].setIcon(new ImageIcon(Fenetre.class.getResource("/CasePerso/Carte" + tout.mrjack.carte[2].nom + ".png")));
				} else if (tout.mrjack.carte[2].up == 1) {
					tout.mrjack.carte[2].up = 0;
					CartesMechants[2].setIcon(new ImageIcon(Fenetre.class.getResource("/CasePerso/CarteRien.png")));
				}
			} else if (e.getSource() == CartesMechants[3]) {
				if (tout.mrjack.carte[3].up == 0) {
					tout.mrjack.carte[3].up = 1;
					CartesMechants[3].setIcon(new ImageIcon(Fenetre.class.getResource("/CasePerso/Carte" + tout.mrjack.carte[3].nom + ".png")));
				} else if (tout.mrjack.carte[3].up == 1) {
					tout.mrjack.carte[3].up = 0;
					CartesMechants[3].setIcon(new ImageIcon(Fenetre.class.getResource("/CasePerso/CarteRien.png")));
				}
			}
		}
	}
}


















