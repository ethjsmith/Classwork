/*

@Author (created/edited by ) Ethan Smith
@ DATE 3/14/19
@ Assignment : Weapon for our hero
@Class : Character
@Favorite Color : RED

*/
public class Dungeon extends Object {
// im not really sure that this has to inherit at all
	//protected Baddy enemies [];
	private int difficulty;
	public Dungeon() {
		difficulty = (int) (Math.random()*5)+3;
		//creates a bunch of enemies based on the difficulty of the dungeon
		//something here
	}
	// shoot, randomencounter is in main... might have to change that
	
	// edit, OR DUNGEON DIES HERE HAHAHAHAHA
	/*public void dungeonHandler(Hero h1) {
		for (int z =0;z<difficulty;z++) {
			randomencounter(h1);
		}
	}*/
}
