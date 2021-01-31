package ft.groupe.MrJackPaul;

public class HolmesWatsonChien {
	public int[] position = new int[3]; //0 : Watson, 1 : Chien et 2 : Holmes
	public String[] name = new String[3];
	
	public HolmesWatsonChien() {
		position[0] = 3;
		position[1] = 7;
		position[2] = 11;
		name[0] = "Watson";
		name[1] = "Chien";
		name[2] = "Holmes";
	}
	
	public void ajouterPosition(int i) {
		if (position[i] == 11) {
			position[i] = 0;
		} else {
			position[i]++;
		}
	}
}
