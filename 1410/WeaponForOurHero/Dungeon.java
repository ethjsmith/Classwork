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
	private boolean complete;
	public Dungeon() {
		difficulty = (int) (Math.random()*5)+3;
		complete = false;
		//creates a bunch of enemies based on the difficulty of the dungeon
		//something here
	}
	// shoot, randomencounter is in main... might have to change that

	// edit, OR DUNGEON DIES HERE HAHAHAHAHA

	//edit2 : moved randomencounter , which is now baddy.fight();
	// dungeon is back on Boys
	public void enterdungeon(Hero h1) {
		if (!complete) {
		System.out.println("you find a mysterious dungeon... You can enter if you want, but you expect that you'll face many monster in a row, with a chance for a greater gold reward...");
		System.out.println("1: Enter the dungeon");
		System.out.println("2: Countinue your journey");
		int choice = validnumber(1,2);
		if (choice == 1) {
			System.out.println("You head into the dungeon");
			dungeonHandler(h1);
		}else {
		System.out.println("You return to the site of an old completed dungeon...");
		System.out.println("having killed all the enemies within, this is a very safe place to camp");
		}
	}
	else {
		System.out.println("you decide that you're not feeling a dangerous dungeon right now, so you continue on your way");
	}
}
	public void dungeonHandler(Hero h1) {
		for (int z =0;z<difficulty;z++) {
			Baddy b = new Baddy(h1);
			b.fight(h1);
		}
		int gold = (int) (Math.random()*(8*difficulty))+5*difficulty;
		System.out.println("you best all of the enemies in the dungeon, and at it's heart you find a pile of "+gold+  " gold");
		h1.setGold(h1.getGold()+gold);
		System.out.println("you quickly loot the dungeon, and then make your escape before more evil creatures can attack");
		complete = true;
	}
}
