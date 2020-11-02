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
	// shoot, randomencounter is in main... which means I can't call it form here afaik ( I don't know how I would )

	// edit, OR DUNGEON DIES HERE HAHAHAHAHA Ill just scrap dungeon

	//edit2 : moved randomencounter , which is now baddy.fight();
	// dungeon is back on Boys
	public void enterdungeon(Hero h1) {
		// if you haven't beat the dungeon before you can fight it
		if (!complete) {
			System.out.println("you find a mysterious dungeon... You can enter if you want, but you expect that you'll face many monster in a row, with a chance for a greater gold reward...");
			System.out.println("1: Enter the dungeon");
			System.out.println("2: Countinue your journey");
			int choice = validnumber(1,2);
			if (choice == 1) {
				System.out.println("You head into the dungeon");
				dungeonHandler(h1);
			}else {
				System.out.println("you decide that you're not feeling a dangerous dungeon right now, so you continue on your way");
			}
		}else {
			// if you already completed the dungeon it stays empty... this isn't skyrim
			System.out.println("You return to the site of an old completed dungeon...");
			System.out.println("having killed all the enemies within, this is a very safe place to camp");
		}
	}
	// there is a bug, where if you just run away from all the enemies in the dungeon , you can loot it as if you beat it .... not really optimal, but whatever
	// a loop that makes you fight a bunch of enemies based on the difficulty of the dungeon
	public void dungeonHandler(Hero h1) {
		for (int z =0;z<difficulty;z++) {
			//75% that you fight a monster, 25% chance that you run into a trap
			// now 80 and 20 chances
			if (Math.random() > .2) {
				Baddy b = new Baddy(h1);
				b.fight(h1);
			}else {
				trap(h1);
				System.out.println("");
				System.out.println("");
			}
		}
		//dungeons reward a LOT of gold (possibly)
		int gold = (int) (Math.random()*(8*difficulty))+3*difficulty;
		System.out.println("you best all of the enemies in the dungeon, and at it's heart you find a pile of "+gold+  " gold");
		h1.setGold(h1.getGold()+gold);
		System.out.println("you quickly loot the dungeon, and then make your escape before more evil creatures can attack");
		complete = true;
	}
	public void trap(Hero h1) {
		//some random traps, to make dungeons more interesting
		//most of this is just if/elseif/else chains... nothing too impressive programmatically...
		double whichtrap = Math.random();
		if (whichtrap > .7) {
			System.out.println("You see some odd tiles on the floor... looks like it could be a trap");
			System.out.println("1: Step on the Black Tiles");
			System.out.println("2: Step on the White Tiles");
			int choice = validnumber(1,2);
			// lol 50% chance whatever you pick hehhehehehehehehehahahahahahHAAHAHAHAHAHAHAHAHA screw the player xD
			if (Math.random() > .5) {
				System.out.println("Nothing happens, I guess you picked the right tiles this time");
			}else {
				System.out.println("as soon as you step on the tile, some darts shoot out of the wall, hitting you, and dealing 5 dmg");
				h1.changeHp(-5);
			}
		}else if (whichtrap > .2) {// 2 kinds of traps... how interesting
			System.out.println("You see something glittering in the darkness... it could be some gold, or another trap!");
			System.out.println("1: Grab the glittering thing");
			System.out.println("2: Leave it alone");
			int choice = validnumber(1,2);
			if (choice == 1) {
				if (Math.random() > .5) {
					int dmg = (int)(Math.random()*5)+3;
					System.out.println("As you grab the thing, a bear trap snaps shut on your arm, dealing "+dmg+" damage!");
					h1.changeHp(dmg*-1);
				}
				int gld = (int)(Math.random()*8)+2;
				System.out.println("You get the glittery thing... it ends up being "+gld+" gold !");
				h1.setGold(h1.getGold()+gld);
			}
			else {
				System.out.println("You decide that it isn't worth it, and continue exploring");
			}
		}else {
			System.out.println("You come to a fork in the road, with 2 paths... Which way would you like to go?");
			System.out.println("1: Go left");
			System.out.println("2: Go Right");
			int choice = validnumber(1,2);
			if (choice == 1) {
				System.out.println("You come to a glowing pool of water");
				System.out.println("1: Bathe in the water");
				System.out.println("2: Skirt around the pool, avoiding it");
				int c2 = validnumber(1,2);
				if (c2 == 1) {
					System.out.println("You climb into the glowing water");
					if (Math.random() > .5) {
						System.out.println("You feel your wounds start to close... the water is healing you!");
						h1.changeHp(15);
					}
					else {
						System.out.println("Suddenly the water starts to burn your skin... you jump out, but not before some damage is done");
						h1.changeHp(-10);
					}
				}else {
					System.out.println("You Skirt around the pool... it's best to leave something like that alone");
				}
			}else {
				System.out.println("You see something sitting on the floor in the middle of a dark room... it could be a weapon!");
				System.out.println("1: Grab the weapon");
				System.out.println("2: Rush quickly through the room, avoiding the weapon, and any possible traps");
				int c2 = validnumber(1,2);
				if (c2 == 1) {
					System.out.println("It's a Ritual blade!, a rare and powerful weapon!");
					if (h1.canAddItem()) {
						Weapon z = new Ritualsword();
						h1.addItemToInventory(z);
						System.out.println("You grab it, and hurry along the path");
					}else {
						System.out.println("unforunately you can't carry anything else");
					}
				}else {
					int dmg = (int)(Math.random()*4)+5;
					System.out.println("As you are rushing through, you hit a tripwire, triggering an arrow, which hits you in the side, dealing "+ dmg + " Damage");
					h1.changeHp(dmg*-1);
				}
			}
		}
	}
}
