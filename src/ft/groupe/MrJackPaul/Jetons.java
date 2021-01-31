package ft.groupe.MrJackPaul;

public class Jetons {
	public String name1;
	public String name2;
	public int cote; // 0 : pile et 1 : face
	
	public Jetons(String name1, String name2) {
		this.name1 = name1;
		this.name2 = name2;
		this.cote = -1;
	}
	
	public void changerFace() {
		if (cote == 0)
			cote = 1;
		else
			cote = 0;
	}
}
