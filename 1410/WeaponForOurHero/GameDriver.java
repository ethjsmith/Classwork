/*

@Author (created/edited by ) Ethan Smith
@ DATE 2/27/19 - 3/14/19
@ Assignment : Weapon for our hero
@Class : Driver
@Favorite Color : RED

*/

// I saved a version of this called "Final" on the 4th... It is now the 12th, and I keep adding stuff ... whoops

//Game driver for testing inheritance demonstration files
//Dr. G
//10-5-18
//Edited 2-17-19

//14. Now let's test our set up so far



// it occurred to me way late in the creation of the RPG elements (towns dungeons, and random encounters) that it would probably have been better to
// make all of those things objects, but that would have changed a lot of things about how I wrote the field, so I decided not to do that.
// anyway, this game works pretty well, except when it doesn't (like when things print on weird parts of the screen, based on what part of the game loop it occurs during.

import java.security.SecureRandom;
import java.util.Scanner;

public class GameDriver
{
	public static void main(String [] args)
	{
		// scanner for getting user input
		Scanner s = new Scanner(System.in);
		Field f1 = new Field(20,20);
		//Create a 20 x 20 field

		//We are going to create a test fight scenario involving a hero and a bad guy
		//For now, we'll ignore moving around the field.
		//Can you see how this is related to your 1400 semester long project?

		//15.
		//Add the ability to take damage and to heal to our hero and bad guy




		// I guess this is more of a JRPG (heh get it ? no character creation options)
		// your name is Idiot, and there's nothing you can do about it :3
		Hero loser = new Hero("Idiot",f1,200,10);
		//Baddy g1 = new Baddy("goblin2", f1,25,1);
		//Baddy g2 = new Baddy("goblin1",f1,25,1);
		//Baddy g3 = new Baddy("Goblin69",f1,23,2000);
		//moveSomeone(loser);
		//fight(loser,g1);
		//Create a Hero with strength 10 and hit points 100

		//Create a 3 Bad guys with strength 5 and hit points 200

		//Create a fight function that accepts a hero and a bad guy let them fight it out
		while (true) {
			//makes it clear what is being printed on the screen
			System.out.println("===============================================");
			System.out.println("");
			System.out.println("");
			System.out.println("");
			travel(loser,f1,s);
// This section can be used to add a delay after every action, to see what happened.
			//try {
			//	Thread.sleep(1000);
			//}
			//catch(InterruptedException e) {
			//	Thread.currentThread().interrupt();
			//}
		}
	}
	public static int validnumber (int min,int max) {
		//this method returns a verified number between min and max, for use with all those choices you have to make
		// it also has error handling if you try to enter a word or something stupid
		int num =0;
		Scanner s = new Scanner(System.in);
		boolean valid = false;
		while (!valid) {
			try {
				num = s.nextInt();
				if (num >= min && num <= max) {
					valid = true;
				}else {
					throw new Exception("wrong number");
				}
			}
			catch (Exception E) {
				s.nextLine();
				System.out.println("please enter an INT between " + min  +" and " + max);

			}
		}
		return num;
	}
	public static void moveSomeone(Hero c, int x, int y,Field f1) {
		// sets the new coordinates
		c.setX(c.getX()+x);
		c.setY(c.getY()+y);
		if (c.getX() < 0) {
			c.setX(f1.getWidth()-1);
		}
		else if (c.getX() > f1.getWidth()-1){
			c.setX(0);
		}
		if (c.getY() < 0) {
			c.setY(f1.getHeight()-1);
		}
		else if (c.getY() > f1.getHeight()-1) {
			c.setY(0);
		}
		String currentPos = f1.WhereAmI(c.getX(),c.getY());
		System.out.println(c.getX() + ", "+c.getY());
		System.out.println(currentPos);
		if (currentPos == ".") {
			// random encounter, pokemon style, you have a chance to run into an enemy
			// if you don't see an enemy, something else might happen...
			// this will happen only on the empty squares of the map (IE ".")
			// I don't know why I did the comparason this way instead of like
			// math.random() > .5 ...
			if ((int) (Math.random()*2)+1 == 1) {
				randomencounter(c);
			}
			else if ((int) (Math.random()*2)+1 == 1) {
				System.out.println("As you are walking, you come across a traveling merchant. He has many weapons for sale");
				shopkeeper(c);
			}
			else {
				System.out.println("you come to a quiet field... seems like those are rare these days");
			}
		}
		else if (currentPos == "T") {
			//town handler here
			town(c);
		}
		else if (currentPos == "D") {
			// dungeon handler here
			dungeon(c);
		}
		else {
			System.out.println("You create a rip in the time space continuum, breaking the game in this place");
			// whoops
		}
		// lets your character wrap on the map, going to the top, or the bottom.
		// lol there used to be code to let you wrap on the map here, IDK where that went, afaik you can still do that


	}

	public static void town(Hero h1) {
		// handle the town... IDK
		Town t = new Town();
		t.HandleTown(h1);
	}
	public static void dungeon(Hero h1) {
		Dungeon d = new Dungeon();
		d.enterdungeon(h1);
		// this method should probably be an object, but to do that I would have to make the randomencounter method a method in baddy ( or something)
		// and fix a bunch of other flaws in my code, so I'll just leave it here as a method... Don't think too poorly of me for being lazy in this.
		/*System.out.println("you find a mysterious dungeon... You can enter if you want, but you expect that you'll face many monster in a row, with a chance for a greater gold reward...");
		System.out.println("1: Enter the dungeon");
		System.out.println("2: Countinue your journey");
		int choice = validnumber(1,2);
		if (choice == 1) {
			System.out.println("You head into the dungeon");
		int difficulty = (int) (Math.random()*5)+3;
			for (int z =0;z<difficulty;z++) {
				randomencounter(h1);
			}
			int gold = (int) (Math.random()*(7*difficulty))+3*difficulty;
			System.out.println("you best all of the enemies in the dungeon, and at it's heart you find a pile of "+gold+  " gold");
			h1.setGold(h1.getGold()+gold);
			System.out.println("you quickly loot the dungeon, and then make your escape before more evil creatures can attack");

		}
		else {
			System.out.println("you decide that you're not feeling a dangerous dungeon right now, so you continue on your way");
		}*/
	}


	// randomly come across a wandering shopkeeper...
	// shopkeeper is the wrong work, probably like merchant or something

	public static void shopkeeper(Hero h1) {
		//uses a merchant object, which is reused in towns.
		Merchant m = new Merchant();
		m.buyloop(h1);
	}
	//creates a monster for you to fight against, which is both random, and near you in stats


	// this is the random encounter ( and fight ) handler
	public static void randomencounter(Hero h1) {
		Baddy b = new Baddy(h1);
		b.fight(h1);
	}

	public static void travel (Hero h1, Field f1,Scanner s) {
		//prints the field, and asks the player where to go
		printField(f1,h1);
		System.out.println("where do you want to go?");
		System.out.println("1: Up");
		System.out.println("2: Down");
		System.out.println("3: Left");
		System.out.println("4: Right");
		System.out.println("5: Check stats/Inventoy");
		System.out.println("6: Discard Item");
		int x = validnumber(1,6);
		// moves your character based on your actions
		if (x == 1) {
			moveSomeone(h1,0,-1,f1);
		}
		else if (x==2) {
			moveSomeone(h1,0,1,f1);
		}
		else if (x==3) {
			moveSomeone(h1,-1,0,f1);
		}
		else if (x==4) {
			moveSomeone(h1,1,0,f1);
		}
		//print out your current stats.
		else if (x==5) {
			System.out.println(h1.getHp() + ":Current HP , " + h1.getMana() + ":Current Mana , " + h1.getStrength() + ":Strength ");
			System.out.println("~~~ Inventory: ~~~");
			h1.showInventory();
		}
		else if (x==6) {
			discardItems(h1);
		}
		// passive regeneration... you heal 1hp&1M every time you move
		// #hiddenMechanics
		h1.changeHp(1);
		h1.setMana(h1.getMana() + 1);
	}
	public static void discardItems(Hero h1) {
		h1.showInventory();
		System.out.println("Enter the number for the item you wish to discard!");
		h1.removeItemFromInventory(validnumber(1,h1.getInventory().length+1));
	}

	//draws a visual representation of the field
	public static void printField(Field f1,Hero h1) {
		for (int i=0;i<f1.getWidth();i++) {
			for (int j = 0; j<f1.getHeight(); j++){
				if (h1.getX() == j && h1.getY()==i){
					System.out.print("X ");
				}
				else {
					System.out.print (f1.WhereAmI(j,i) + " ");
					//System.out.print(". ");
				}
			}
			System.out.println("");
		}
		System.out.println("");
	}


}
