package ft.groupe.MrJackPaul;

public class Case {
	public Perso perso;
	public int orientationMur; // 0 : nord, 1 : est, 2 : sud et 3 : ouest
	public int retournee;
	
	public Case(Perso perso, int orientationMur) {
		this.perso = perso;
		this.orientationMur = orientationMur;
		this.retournee = 0;
	}
}
